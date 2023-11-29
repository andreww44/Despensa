package com.example.despensa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.despensa.database.AppDatabase
import com.example.despensa.entity.User

class AccessActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var listUsers : MutableList<User>
    private lateinit var loginButton: Button
    private lateinit var signButton: Button
    private lateinit var textPass: TextView
    private lateinit var db : AppDatabase


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access2)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        signButton = findViewById(R.id.buttonsign)
        textPass = findViewById(R.id.textView)

        //val usuarioDao = Sign.database.usuarioDao()



        loginButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val username = usernameEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (esValido(username, password)) {
                    val intent = Intent(applicationContext, MainActivity::class.java)
                    startActivity(intent)
                } else {
                    //Mensaje de error
                    textPass.setText("Ingrese los datos nuevamente")
                }
            }
        })

        signButton.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View) {
                val intent = Intent(applicationContext, SingActivity::class.java)
                startActivity(intent)
            }
        })
    }

    private fun esValido(username: String, password: String): Boolean {
        //Preguntar si esta correcto
        if("alvaro" == username && "1234" == password)
        {
            return true;
        }

        textPass.text = "Usuario No registrado"
        return false;

    }


}