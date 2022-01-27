package com.lorrane.alcoolougasolina

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcularPreco(view: View){

        //recuperar valores digitados
        val precoAlcool = editPrecoAlcool.text.toString()
        val precoGasolina = editPrecoGasolina.text.toString()

        val validaCampos = validarCampos(precoAlcool, precoGasolina)

        if (validaCampos){
            calcularMelhorPreco(precoAlcool, precoGasolina)
        }else {
            textResultado.text = "Preencha os preços primeiro!"
        }
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String) {

        //Converte valores string para numeros
        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina = precoGasolina.toDouble()

        val resultadoPreco = valorAlcool / valorGasolina
        if (resultadoPreco >= 0.7){
            textResultado.text = "Melhor utilizar Gasolina"
        }else {
            textResultado.text = "Melhor utilizar Alcool"
        }
    }

    fun validarCampos(precoAlcool: String, precoGasolina: String): Boolean {

        var camposValidados: Boolean = true
        if (precoAlcool.isEmpty() || precoAlcool.equals("")){
            camposValidados = false
        }else if (precoGasolina.isEmpty() || precoGasolina.equals("")){
            camposValidados = false
        }

        return camposValidados
    }
}