package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth

class RegisterActivity : AppCompatActivity() {

    private lateinit var EmailInput : EditText
    private lateinit var  PasswordInput : EditText
    private lateinit var RegisterButton : Button

    private lateinit var mAuth: FirebaseAuth



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        mAuth = FirebaseAuth.getInstance()

        EmailInput = findViewById(R.id.SingupEmail)
        PasswordInput = findViewById(R.id.SingUpPassword)
        RegisterButton = findViewById(R.id.SingUpButton)

        RegisterButton.setOnClickListener {

            val Email = EmailInput.text.toString()
            val Password = PasswordInput.text.toString()

            if (Email.isEmpty() || Password.isEmpty()) {

                Toast.makeText(this, "Empty", Toast.LENGTH_LONG).show()

                    return@setOnClickListener
            }

            mAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener {task ->
                    if (task.isSuccessful) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    } else
                        Toast.makeText( this, "Error!", Toast.LENGTH_SHORT).show()


            }
                }
        }
    }




