package com.ismael.samsung.remote.control.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import com.ismael.samsung.remote.control.network.SamsungWebSocketClient

class RemoteControlViewModel(application: Application) : AndroidViewModel(application) {
    private val client = SamsungWebSocketClient(application.applicationContext)

    fun conectarComTv(ip: String) {
        client.connect(ip) { mensagem ->
            Log.d("ViewModel", "Resposta: $mensagem")
        }
    }

    fun enviarComando(key: String) {
        client.sendKey(key)
    }

    fun abrirApp(key: String) {
        client.launchApp(key)
    }

    override fun onCleared() {
        client.disconnect()
        super.onCleared()
    }
}