package com.example.despensa

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.despensa.adapters.ProductoDetalle


import androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback.Default
import com.example.despensa.adapters.ListaTienda
import com.example.despensa.adapters.MiPerfilActivity
import com.example.despensa.adapters.ProductoListAdapter
import kotlin.system.exitProcess


class ListaDespensa : AppCompatActivity() {

    private lateinit var listViewProductos: ListView
    private var listOption: Boolean = true
    private var detailOption: Boolean = false
    private lateinit var productos: MutableList<Producto>
    private lateinit var adapterItems: ProductoListAdapter

    private lateinit var orderby : Button
    private lateinit var filter: Button;
    companion object {
        const val REQUEST_REGISTER = 1
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_despensa)

        setSupportActionBar(findViewById(R.id.toolbar))

        listViewProductos = findViewById(R.id.listViewProducts)
        orderby = findViewById(R.id.orderby)
        filter = findViewById(R.id.filter)

        productos = mutableListOf(
            Producto("Coca cola", "Santa Isabel", "1500", "2", "Bebiba"),
            Producto("Pepsi", "Acuenta", "1500", "1", "Bebida"),
            Producto("B", "B", "B", "B", "B"),
            Producto("A", "A", "A", "A", "A")
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


        orderby.setOnClickListener {
            productos.sortBy { it.nombre }
            adapterItems = ProductoListAdapter(this, R.layout.card_view, productos)
            listViewProductos.adapter = adapterItems
            //listViewProductos.adapter = adapterItems.sortedBy { it.nombre }
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menulistadespensa, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.id_add-> {  val intent = Intent(this, AddProduct::class.java)
                startActivity(intent);
                return true;
            }
            R.id.id_atras->{
                finish()
                return true;
            }

        }
        return super.onOptionsItemSelected(item)
    }

}