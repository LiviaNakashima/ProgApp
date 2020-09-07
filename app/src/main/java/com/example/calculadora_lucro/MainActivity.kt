package com.example.calculadora_lucro

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

    fun clicar(componente:View){

     if (et_produto.length() < 2 ){
         Toast.makeText(this, "O nome do produto deve ter mais que 1 letra", Toast.LENGTH_SHORT).show()
     } else {
         val produto = et_produto.text }

     if (et_receita.length() > 200){
         Toast.makeText(this, "A receita não pode ser maior que 200", Toast.LENGTH_SHORT).show()
     } else{
         val receita = et_receita.text
     }
    }
}