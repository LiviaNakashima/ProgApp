package com.example.calculadora_lucro

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun calcular(componente:View){
        if (et_produto.length() < 2 ){
            Toast.makeText(this, "Valor incorreto, o nome do produto deve ter pelo menos 2 letras.", Toast.LENGTH_SHORT).show()
        } else if (et_receita.getText().toString().trim().equals("") || et_custo.getText().toString().trim().equals("")){
            Toast.makeText(this, "Valores incorretos, todos os campos devem estar preenchidos.",Toast.LENGTH_SHORT).show()
        }
        else{
            val lucro = et_receita.text.toString().toDouble() - et_custo.text.toString().toDouble()
            val margemLucro = (lucro/et_receita.text.toString().toDouble())*100

            when {
                margemLucro < 50.0 -> {
                    tv_frase.visibility = View.VISIBLE
                    tv_frase.setTextColor(Color.RED)
                    tv_frase.text = "Vixi, você só consegue R$${"%.2f".format(lucro)} de lucro com seu produto ${et_produto.text}, isso significa que sua margem de lucro" +
                            " é de ${"%.2f".format(margemLucro)}%.Você precisa estudar mais para não sair no prejuízo"
                }
                margemLucro > 70.0 -> {
                    tv_frase.visibility = View.VISIBLE
                    tv_frase.setTextColor(Color.GREEN)
                    tv_frase.text = "MEU DEUS! você consegue R$${"%.2f".format(lucro)} de lucro com seu produto ${et_produto.text}, isso significa que sua margem de lucro" +
                            " é de ${"%.2f".format(margemLucro)}%.Você é o deus dos lucros!!!"
                }
                else -> {
                    tv_frase.setTextColor(Color.BLUE)
                    tv_frase.text = "Caramba, você consegue R$${"%.2f".format(lucro)} de lucro com seu produto ${et_produto.text}, isso significa que sua margem de lucro" +
                            " é de ${"%.2f".format(margemLucro)}%.Você está se saindo bem!"
                    tv_frase.visibility = View.VISIBLE
                }
            }
        }
    }

}