package com.ismael.samsung.remote.control.viewmodel

import android.app.Application
import android.content.Context
import android.util.Log
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
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

    override fun onCleared() {
        client.disconnect()
        super.onCleared()
    }
}