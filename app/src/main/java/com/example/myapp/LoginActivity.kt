package com.example.myapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : AppCompatActivity()/*,*//*View.OnClickListener*/ {
    lateinit var edtMobile: EditText
    lateinit var edtPassword: EditText
    lateinit var btnLogIn: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView
    lateinit var sharePrefences: SharedPreferences
    var validMobileNumber = "0123456789"
    var validPassword = arrayOf("thanos", "tony", "steve", "bruce")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharePrefences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)
        var isLoggedIn = sharePrefences.getBoolean("isLoggedIn",false)
        setContentView(R.layout.activity_login)
        if(isLoggedIn)
        {
            var intent = Intent(this@LoginActivity,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
        setContentView(R.layout.activity_login)
        }
        title = "Log-in"
        edtMobile = findViewById(R.id.edtMobile)
        edtPassword = findViewById(R.id.edtPassword)
        btnLogIn = findViewById(R.id.btnogIn)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)

        btnLogIn.setOnClickListener {
            var mobileNumber = edtMobile.text.toString()
            var password = edtPassword.text.toString()
            var nameOfAvenger = "Avenger"
            var intent = Intent(this@LoginActivity, MainActivity::class.java)
            if ((mobileNumber == validMobileNumber)) {
                if (password == validPassword[0]) {
                    nameOfAvenger = "Iron Man"
                    startActivity(intent)
                    savePreferences(nameOfAvenger)
                } else if (password == validPassword[1]) {
                    nameOfAvenger = "Bat Man"
                    startActivity(intent)
                    savePreferences(nameOfAvenger)
                } else if (password == validPassword[2]) {
                    nameOfAvenger = "thanos"
                    startActivity(intent)
                    savePreferences(nameOfAvenger)
                } else if (password == validPassword[3]) {
                    nameOfAvenger = "Caption America"
                    startActivity(intent)
                    savePreferences(nameOfAvenger)
                }
                var intent = Intent(this@LoginActivity, MainActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this@LoginActivity, "wrong Credentials", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title :String) {
        sharePrefences.edit().putBoolean("isLoggedIn",true).apply()
        sharePrefences.edit().putString("Title",title).apply()
    }
}
