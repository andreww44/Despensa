package com.example.despensa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.example.despensa.adapters.ProductoDetalle


import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback.Default
import com.example.despensa.adapters.ProductoListAdapter


class ListaDespensa : AppCompatActivity() {

    private lateinit var listViewProductos: ListView
    private var listOption: Boolean = true
    private var detailOption: Boolean = false
    private lateinit var productos: MutableList<Producto>
    private lateinit var adapterItems: ProductoListAdapter
    private lateinit var buttonExit : Button

    private lateinit var buttongo: Button;
    companion object {
        const val REQUEST_REGISTER = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_despensa)

        buttongo = findViewById(R.id.button8)
        listViewProductos = findViewById(R.id.listViewProducts)
        buttonExit = findViewById(R.id.button3)

        productos = mutableListOf(
            Producto("Coca cola", "Santa Isabel", "1500"),
            Producto("Pepsi", "Acuenta", "1500"),
            Producto("InkaCOla", "Santa Isabel", "2000"),
        )

        adapterItems = ProductoListAdapter(this, R.layout.card_view, productos)
        listViewProductos.adapter = adapterItems

        listViewProductos.setOnItemClickListener { _, _, position, _ ->
            val selectedProduct = productos[position]
            listOption = !listOption
            if (detailOption) {
                showPatientDetailDialog(selectedProduct)
            }
            else {
                val intent = Intent(this, DetalleProductoActivity::class.java)
                intent.putExtra("producto", selectedProduct)
                startActivity(intent)
            }
        }

        buttongo.setOnClickListener()
        {
            val intent = Intent(this, AddProduct::class.java)
            startActivityForResult(intent, REQUEST_REGISTER)
        }
        buttonExit.setOnClickListener(){
            finish();
        }

    }



    private fun showPatientDetailDialog(producto: Producto) {
        val dialog = ProductoDetalle(this, producto)
        dialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == REQUEST_REGISTER && resultCode == RESULT_OK) {
            val newPatient = data?.getParcelableExtra<Producto>("new")
            if (newPatient != null) {
                productos.add(newPatient)
                if (listOption) {

                }
                adapterItems.notifyDataSetChanged()
            }
        }
    }

}