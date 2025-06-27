package com.ismael.samsung.remote.control.viewmodel

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.ismael.samsung.remote.control.network.discoverTvs
import java.net.InetAddress

class TvDiscoveryViewModel : ViewModel() {
    private val _tvs = mutableStateListOf<InetAddress>()
    val tvs: List<InetAddress> = _tvs

    fun buscarTvs() {
        _tvs.clear()
        discoverTvs { encontrados ->
            _tvs.addAll(encontrados)
        }
    }
}
