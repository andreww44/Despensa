package com.example.despensa.adapters

import android.app.Dialog
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.EditText
import androidx.room.Room
import com.example.despensa.R
import com.example.despensa.SingActivity
import com.example.despensa.database.AppDatabase
import com.example.despensa.entity.User

class UserNew(
    context: SingActivity,
    idUser: Int,
    act: SingActivity
) : Dialog(context) {

    private lateinit var username : EditText
    private lateinit var password : EditText
    private lateinit var db : AppDatabase
    private var id : Int = idUser
    private var act : SingActivity = act

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_user_new)

        username = findViewById(R.id.editTextFirstname)
        password = findViewById(R.id.editTextLastname)

        db = Room.databaseBuilder(
            context,
            AppDatabase::class.java, "database-name"
        ).allowMainThreadQueries().build()


        val buttonAddAndGoBack : Button = findViewById(R.id.buttonAddAndGoBack)
        // Set a click listener for the "Go Back" button to dismiss the dialog
        buttonAddAndGoBack.setOnClickListener {
            //Add user to database
            db.userDao().insertAll(
                User(id, username.text.toString(),password.text.toString())

            )

            act.refreshFromDatabase()
            dismiss()
        }
    }


}