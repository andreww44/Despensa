package com.example.despensa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
class SplashScreen : AppCompatActivity(){

    private val SPLASH_TIMEOUT: Long = 3000 // 3 segundos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        // Usamos un Handler para retrasar la apertura de la actividad principal
        Handler().postDelayed({
            val intent = Intent(this, AccessActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_TIMEOUT)
    }
}