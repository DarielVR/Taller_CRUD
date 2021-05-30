package com.prueba.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val adaptador = Adaptador (
        {clickListener -> deleteItemClick(clickListener)},
        {longListener -> changeItemClick(longListener)}
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")

        adaptador.setItems(items)

        button.setOnClickListener {
            adaptador.addItem("Nuevo Item")
        }

        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador
    }

    private fun deleteItemClick(position:Int){
        val item = adaptador.getItem(position)
        adaptador.removeItem(item)
    }

    private fun changeItemClick(position: Int) {
        adaptador.changeItem(position, "Modificado")
    }
}