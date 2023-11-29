package com.example.despensa

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.room.Room
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class AddProduct : AppCompatActivity() {

    private lateinit var nameEdit : EditText
    private lateinit var precioEdit : EditText
    private lateinit var storeEdit : EditText
    private lateinit var button : Button
    private lateinit var buttonclear : Button
    private lateinit var buttonExit : Button
    private lateinit var list : ListView
    private lateinit var listTextos : ArrayList<String>
    private lateinit var adapter : ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_product)


        nameEdit = findViewById(R.id.nombreEdit)
        precioEdit = findViewById(R.id.editTextTextEmailAddress)
        storeEdit = findViewById(R.id.editTextTextEmailAddress2)

        button = findViewById(R.id.button5)
        buttonclear = findViewById(R.id.button4)
        buttonExit = findViewById(R.id.button6)
        list = findViewById(R.id.listita)
        listTextos = ArrayList()

        adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, listTextos)
        list.adapter = adapter

        button.setOnClickListener{
            Toast.makeText(this,nameEdit.text, Toast.LENGTH_LONG).show()
            listTextos.add(nameEdit.text.toString())
            adapter.notifyDataSetChanged()

            val nuevaProducto = Producto(
                id = 1,
                nombre = nameEdit.text.toString(),
                tienda = storeEdit.text.toString(),
                precio = precioEdit.text.toString(),
                cantegoria = "cualquier",
                cantidad = "2"
                )
            val context: Context = this
            /*
            GlobalScope.launch {
                val productoDao = DatabaseProvider.obtenerProductoDatabase(context).productoDao()
                productoDao.insertarTienda(nuevaProducto)
            }*/
            nameEdit.setText("")
            precioEdit.setText("")
            storeEdit.setText("")
        }

        buttonclear.setOnClickListener(){
            nameEdit.setText("")
            precioEdit.setText("")
            storeEdit.setText("")
        }

        buttonExit.setOnClickListener(){
            finish();
        }

    }
}

