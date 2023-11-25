package com.example.despensa.adapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despensa.DespensaCasaActivity
import com.example.despensa.ListaDespensa
import com.example.despensa.R
import com.example.despensa.Tienda
import kotlin.system.exitProcess

class ListaTienda : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tienda)

        setSupportActionBar(findViewById(R.id.toolbar))

        val listaTiendas = listOf(
            Tienda("Acuenta", "Norte 1", R.mipmap.ic_acuenta_foreground),
            Tienda("Santa Isabel", "Norte 2", R.mipmap.ic_santaisabel_foreground)
        )

        val recyclerView: RecyclerView = findViewById(R.id.tiendas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val adapter = TiendaAdapter(this, listaTiendas)
        recyclerView.adapter = adapter


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menuitemtienda, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.id_agregar-> {

                return true;
            }
            R.id.id_salir->{
                val intent = Intent(this, ListaDespensa::class.java)
                finish();
                return true;
            }
        }
        return super.onOptionsItemSelected(item)
    }
}