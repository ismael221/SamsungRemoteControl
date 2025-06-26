package com.ismael.samsung.remote.control.network

import android.content.Context
import android.util.Base64
import android.util.Log
import okhttp3.*
import okio.ByteString
import org.json.JSONObject
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager

class SamsungWebSocketClient(private val context: Context) {

    private var webSocket: WebSocket? = null
    private val prefs = context.getSharedPreferences("tv_prefs", Context.MODE_PRIVATE)

    fun connect(ip: String, onMessage: (String) -> Unit) {
        val savedToken = prefs.getString("tv_token", "") ?: ""
        val deviceName = "Controle Kotlin"
        val encodedName = Base64.encodeToString(deviceName.toByteArray(), Base64.NO_WRAP)
        val appId = "com.ismael.remote"
        val deviceId = "1234567"

//        val url =
//            "ws://$ip:8001/api/v2/channels/samsung.remote.control" +
//                    "?name=$encodedName&app_id=$appId&device_id=$deviceId&token=$savedToken"

        val url =
            "wss://$ip:8002/api/v2/channels/samsung.remote.control" +
                    "?name=$encodedName&app_id=$appId&device_id=$deviceId&token=$savedToken"

        val request = Request.Builder().url(url).build()
        val client = createUnsafeOkHttpClient()

        webSocket = client.newWebSocket(request, object : WebSocketListener() {

            override fun onOpen(webSocket: WebSocket, response: Response) {
                Log.i("SamsungWebSocket", "Conectado à TV")
            }

            override fun onMessage(webSocket: WebSocket, text: String) {
                Log.i("SamsungWebSocket", "Resposta da TV: $text")
                onMessage(text)

                val json = JSONObject(text)
                if (json.optString("event") == "ms.channel.connect") {
                    val token = json.optJSONObject("data")?.optString("token")
                    if (!token.isNullOrEmpty()) {
                        prefs.edit().putString("tv_token", token).apply()
                        Log.i("SamsungWebSocket", "Token salvo: $token")
                    }
                }

                if (json.optString("event") == "ms.channel.unauthorized") {
                    Log.w("SamsungWebSocket", "TV recusou conexão: sem pareamento")
                }
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                Log.e("SamsungWebSocket", "Erro na conexão: ${t.message}")
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                Log.i("SamsungWebSocket", "Fechando conexão: $reason")
                webSocket.close(1000, null)
            }

            override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
                Log.i("SamsungWebSocket", "Conexão encerrada: $reason")
            }
        })
    }

    fun sendKey(key: String) {
        val command = """
            {
              "method": "ms.remote.control",
              "params": {
                "Cmd": "Click",
                "DataOfCmd": "$key",
                "Option": "false",
                "TypeOfRemote": "SendRemoteKey"
              }
            }
        """.trimIndent()

        webSocket?.send(command)
    }

    fun launchApp(appId: String) {
        val command = """
        {
          "method": "ms.channel.emit",
          "params": {
            "event": "ed.installedApp.get",
            "to": "host",
            "data": {}
          }
        }
    """.trimIndent()
        print(command)

        webSocket?.send(command)
    }

    fun disconnect() {
        webSocket?.close(1000, "Desconectado")
    }

    fun createUnsafeOkHttpClient(): OkHttpClient {
        try {
            val trustAllCerts = arrayOf<TrustManager>(
                object : X509TrustManager {
                    override fun checkClientTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {}
                    override fun checkServerTrusted(chain: Array<java.security.cert.X509Certificate>, authType: String) {}
                    override fun getAcceptedIssuers(): Array<java.security.cert.X509Certificate> = arrayOf()
                }
            )

            val sslContext = SSLContext.getInstance("SSL")
            sslContext.init(null, trustAllCerts, java.security.SecureRandom())
            val sslSocketFactory = sslContext.socketFactory

            val builder = OkHttpClient.Builder()
            builder.sslSocketFactory(sslSocketFactory, trustAllCerts[0] as X509TrustManager)
            builder.hostnameVerifier { _, _ -> true }

            return builder.build()
        } catch (e: Exception) {
            throw RuntimeException(e)
        }
    }

}