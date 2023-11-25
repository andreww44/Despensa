package com.example.despensa.adapters

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.despensa.AccessActivity
import com.example.despensa.R

class MiPerfilActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mi_perfil)



        setSupportActionBar(findViewById(R.id.toolbar2))
        val listaTarjetas = ArrayList<Tarjeta>()
        val adapter = ArrayAdapter(this, R.layout.item_tarjeta, R.id.nombreTextView, listaTarjetas)
        val listView: ListView = findViewById(R.id.tarjetas)
        listView.adapter = adapter

        val tarjetaEjemplo = Tarjeta(
            nombre = "Juan Pérez",
            numero = "1234-5678-9012-3456",
            banco = "Banco Ejemplo"
        )


        listaTarjetas.add(tarjetaEjemplo)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuitemperfil, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.id_volver -> {
                finish()
                Toast.makeText(this, "holaaaa", Toast.LENGTH_SHORT).show()
                return true
            }
            R.id.id_cerrar_sesion-> {
                val intentPreferences = Intent(this, AccessActivity::class.java)
                finish()
                startActivity(intentPreferences)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
        return super.onContextItemSelected(item)
    }
}