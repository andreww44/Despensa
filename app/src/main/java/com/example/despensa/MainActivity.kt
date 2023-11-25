package com.example.despensa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.despensa.adapters.ListaTienda
import com.example.despensa.adapters.MiPerfilActivity
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbar2))

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menutoolbarmain, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.id_tienda-> {  val intent = Intent(this, ListaTienda::class.java)
                                startActivity(intent);
                                return true;
            }
            R.id.id_lista->{  val intent = Intent(this, ListaTienda::class.java)
                startActivity(intent);
                return true;
            }
            R.id.id_invetario-> {  val intent = Intent(this, ListaTienda::class.java)
                startActivity(intent);
                return true;
            }
            R.id.id_perfil->{  val intent = Intent(this, MiPerfilActivity::class.java)
                startActivity(intent);
                return true;
            }
            R.id.id_salir-> {  val intent = Intent(this, ListaTienda::class.java)
                exitProcess(0)
                return true;
            }
        }
        return super.onOptionsItemSelected(item)
    }
}