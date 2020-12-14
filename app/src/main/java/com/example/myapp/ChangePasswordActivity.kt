package com.example.myapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ChangePasswordActivity : AppCompatActivity() {

    private lateinit var NewPasswordEditText : EditText
    private lateinit var SubmitButton : Button

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_password)

        auth = FirebaseAuth.getInstance()

        NewPasswordEditText = findViewById(R.id.NewPasswordeditTextText)
        SubmitButton = findViewById(R.id.NewPasswordSubmit)

        SubmitButton.setOnClickListener {
            val NewPassword = NewPasswordEditText.toString()
            auth.currentUser?.updatePassword(NewPassword)?.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this,"Success", Toast.LENGTH_LONG).show()
                }else {
                    Toast.makeText(this, "Error!", Toast.LENGTH_LONG).show()
                }
            }


        }
    }
}