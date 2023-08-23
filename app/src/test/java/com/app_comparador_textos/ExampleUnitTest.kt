package com.app_comparador_textos

import org.junit.Test
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import org.junit.Before
import org.junit.Rule

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: CompararTextosViewModel

    @Before
    fun setup() {
        viewModel = CompararTextosViewModel()
    }

    @Test
    fun compararTextos_Diferentes() {
        // Arrange
        val textoA = "Hola"
        val textoB = "Mundo"

        // Act
        viewModel.compararTextos(textoA, textoB)

        // Assert
        assert(viewModel.resultado.value == "Los textos son diferentes")
    }

    @Test
    fun compararTextos_Iguales() {
        // Arrange
        val textoA = "Hola"
        val textoB = "Hola"

        // Act
        viewModel.compararTextos(textoA, textoB)

        // Assert
        assert(viewModel.resultado.value == "Los textos son iguales")
    }
}