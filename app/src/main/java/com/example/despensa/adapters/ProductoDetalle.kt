package com.example.despensa.adapters

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.TextView
import com.example.despensa.R
import com.example.despensa.Producto

class ProductoDetalle (
    context: Context,
    private val producto: Producto
) : Dialog(context) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.list_item_producto)

        val textViewName = findViewById<TextView>(R.id.Nombre)
        val textViewEmail = findViewById<TextView>(R.id.Precio)
        val textViewRoom = findViewById<TextView>(R.id.Precio)

        textViewName.text = producto.nombre
        textViewEmail.text = producto.tienda
        textViewRoom.text = producto.precio


    }
}

