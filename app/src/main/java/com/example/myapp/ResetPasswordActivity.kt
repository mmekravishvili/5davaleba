package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ResetPasswordActivity : AppCompatActivity() {

    private lateinit var ResetButton : Button
    private lateinit var ResetEmailEditText : EditText

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reset_password)

        auth = FirebaseAuth.getInstance()

        ResetButton = findViewById(R.id.ResetSendbutton)
        ResetEmailEditText= findViewById(R.id.ResetEmaileditTextText)

        ResetButton.setOnClickListener {
            val Email = ResetEmailEditText.text.toString()
            auth.sendPasswordResetEmail(Email).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Check Email!", Toast.LENGTH_LONG).show()
                } else {
                    Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}