package com.ismael.samsung.remote.control.network

import java.net.DatagramPacket
import java.net.DatagramSocket
import java.net.InetAddress
import java.net.SocketTimeoutException

import android.util.Log

fun discoverTvs(onResult: (List<InetAddress>) -> Unit) {
    Thread {
        val foundDevices = mutableListOf<InetAddress>()
        try {
            val multicastAddress = InetAddress.getByName("239.255.255.250")
            val socket = DatagramSocket().apply {
                broadcast = true
                soTimeout = 5000
                reuseAddress = true
            }

            val message = """
                M-SEARCH * HTTP/1.1
                HOST: 239.255.255.250:1900
                MAN: "ssdp:discover"
                MX: 2
                ST: ssdp:all
            """.trimIndent().replace("\n", "\r\n") + "\r\n\r\n"

            val data = message.toByteArray()
            val packet = DatagramPacket(data, data.size, multicastAddress, 1900)

            Log.i("DISCOVERY", "📡 Enviando SSDP...")
            socket.send(packet)

            val buffer = ByteArray(2048)
            val start = System.currentTimeMillis()

            while (System.currentTimeMillis() - start < 5000) {
                try {
                    val response = DatagramPacket(buffer, buffer.size)
                    socket.receive(response)

                    val resposta = String(response.data, 0, response.length)
                    val deviceAddress = response.address

                    if (resposta.contains("samsung", true)) {
                        Log.i("DISCOVERY", "📺 Samsung encontrada: ${deviceAddress.hostAddress}")
                        if (!foundDevices.contains(deviceAddress)) {
                            foundDevices.add(deviceAddress)
                        }
                    }
                } catch (e: SocketTimeoutException) {
                    Log.w("DISCOVERY", "⏰ Timeout - sem mais respostas")
                    break
                }
            }

            socket.close()
            onResult(foundDevices)
        } catch (e: Exception) {
            Log.e("DISCOVERY", "❌ Erro: ${e.message}", e)
            onResult(emptyList())
        }
    }.start()
}

