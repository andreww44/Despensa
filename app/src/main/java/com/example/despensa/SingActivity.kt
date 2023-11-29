package com.example.despensa

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.room.Room
import com.example.despensa.adapters.UserNew
import com.example.despensa.database.AppDatabase
import com.example.despensa.entity.User
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.system.exitProcess

class SingActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var listUsers : MutableList<User>
    private lateinit var loginButton: Button
    private lateinit var textPass: TextView
    private lateinit var list: List<User>
    private lateinit var db : AppDatabase

    private lateinit var listViewUsers : ListView
    private lateinit var adapter : ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing)
        setSupportActionBar(findViewById(R.id.toolbar3))

        listViewUsers = findViewById(R.id.listview)

        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()


        listUsers = mutableListOf(
            User(1, "Manuel", "Moscoso"),
            User(2, "Alejandro", "Dominguez")
            // Add more users as needed
        )

        val list : List<User> = db.userDao().getAll()
        listUsers = list.toMutableList()
        //adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, list.map { it.firstName })
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listUsers.map { it.username })
        Toast.makeText(this,"Hi: "+listUsers.size.toString(),Toast.LENGTH_LONG).show()
        listViewUsers.adapter = adapter

        list.size

        val fab : FloatingActionButton = findViewById(R.id.idFabUser)
        fab.setOnClickListener{
            val dialog = UserNew(this,list.size+1,this)
            dialog.show()
        }

        registerForContextMenu(listViewUsers)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menuitemusuariolog, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.id_volver-> {
                exitProcess(0)
                return true;
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun deleteItem(itemPosition: Int) {

        deleteFromDatabase(listUsers[itemPosition])
        refreshFromDatabase()
    }

    public fun saveUserToDatabase(user : User) {
        if (user != null){
            db.userDao().insertAll(user)
            refreshFromDatabase()
        }
    }

    public fun deleteFromDatabase(user : User) {
        db.userDao().delete(user)
    }

    public fun refreshFromDatabase(){
        val list : List<User> = db.userDao().getAll()
        Toast.makeText(this,"Hi: "+list.size.toString(),Toast.LENGTH_LONG).show()
        listUsers = list.toMutableList()
        Toast.makeText(this,"Hi: "+listUsers.size.toString(),Toast.LENGTH_LONG).show()
        listViewUsers.invalidate()
        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, listUsers.map { it.username })
        listViewUsers.adapter = adapter
    }
}