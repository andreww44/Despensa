package com.example.despensa.adapters

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.example.despensa.R

class ListaTienda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tienda)

        val card1View = findViewById<View>(R.id.card1)
        val card2View = findViewById<View>(R.id.card2)

        card1View.findViewById<TextView>(R.id.Nombre).setText("Nombre = Santa Isabel")
        card1View.findViewById<TextView>(R.id.Direccion).setText("1 Sur")
        card1View.findViewById<ImageView>(R.id.imageView).setImageResource(R.mipmap.ic_santaisabel_foreground)


        card2View.findViewById<TextView>(R.id.Nombre).setText("Nombre = Acuenta")
        card2View.findViewById<TextView>(R.id.Direccion).setText("22 Norte")
        card2View.findViewById<ImageView>(R.id.imageView).setImageResource(R.mipmap.ic_acuenta_foreground)


    }
}