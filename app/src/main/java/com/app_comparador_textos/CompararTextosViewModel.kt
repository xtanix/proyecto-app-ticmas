package com.app_comparador_textos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CompararTextosViewModel : ViewModel() {

    private val _resultado = MutableLiveData<String>()
    val resultado: LiveData<String> = _resultado

    fun compararTextos(textoA: String, textoB: String) {
        _resultado.value = if (textoA == textoB) {
            "Los textos son iguales"
        } else {
            "Los textos son diferentes"
        }
    }
}
