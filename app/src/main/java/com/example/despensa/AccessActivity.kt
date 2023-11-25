package com.example.despensa

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AccessActivity : AppCompatActivity() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var textPass: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_access2)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        textPass = findViewById(R.id.textView)

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
    }

    private fun esValido(username: String, password: String): Boolean {
        //Preguntar si esta correcto
        if(username == "alvaro" && password == "1234")
        {
            return true;
        }
        return false;

    }
}