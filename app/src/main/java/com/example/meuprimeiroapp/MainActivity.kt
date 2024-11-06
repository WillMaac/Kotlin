package com.example.meuprimeiroapp

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.math.round

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

fun calcularImc(view : View){

    val textResultado = findViewById<TextView>(R.id.textResultado)
    val editPeso = findViewById<EditText>(R.id.editPeso)
    val editAltura = findViewById<EditText>(R.id.editAltura)

    val peso = editPeso.getText().toString()
    val altura = editAltura.getText().toString()

    val pesoConvertido: Double = peso.toDouble()
    val alturaConvertido: Double = altura.toDouble()

    val resultadoIMC = pesoConvertido/(alturaConvertido * alturaConvertido)
    val arredondado = round(resultadoIMC)
    textResultado.setText("O seu IMC é $arredondado")

}