package com.example.despensa

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast

class DetalleProductoActivity : AppCompatActivity() {

    private lateinit var textName: TextView
    private lateinit var textStore: TextView
    private lateinit var textPrice: TextView


    private lateinit var product: Producto
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalle_producto)


        textName = findViewById(R.id.Nombre);
        textStore = findViewById(R.id.Tienda);
        textPrice = findViewById(R.id.Precio);


        if (Build.VERSION.SDK_INT >= 33){ // TIRAMISU
            product = intent.getParcelableExtra("producto",Producto::class.java) ?: Producto("", "", "", "","")
        }else{
            product = intent.getParcelableExtra("producto") ?: Producto("", "", "","","")
        }



        if (product != null) {
            textName.text = product.nombre
            textStore.text = product.tienda
            textPrice.text = product.precio

        }
        textName.setOnClickListener(){
            Toast.makeText(this,product.nombre, Toast.LENGTH_LONG).show()
        }

    }
}