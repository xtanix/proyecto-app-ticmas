package com.app_comparador_textos

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CompararTextosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this)[CompararTextosViewModel::class.java]

        val editTextA = findViewById<EditText>(R.id.TextoA)
        val editTextB = findViewById<EditText>(R.id.editText)
        val resultadoTextView = findViewById<TextView>(R.id.resultadoTextView)
        val compararButton = findViewById<Button>(R.id.button)

        compararButton.setOnClickListener {
            val textoA = editTextA.text.toString()
            val textoB = editTextB.text.toString()
            viewModel.compararTextos(textoA, textoB)
        }

        viewModel.resultado.observe(this) { resultado ->
            resultadoTextView.text = resultado
        }
    }
}