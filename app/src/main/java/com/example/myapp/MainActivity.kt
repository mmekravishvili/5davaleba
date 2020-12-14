package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {

    private lateinit var EmailInput: EditText
    private lateinit var PasswordInput: EditText
    private lateinit var EnterButton: Button
    private lateinit var RegisterButton: Button
    private lateinit var PasswordResetButton: Button


    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mAuth = FirebaseAuth.getInstance()

        if (mAuth.currentUser != null) {
            gotoPerson()
        }

        setContentView(R.layout.activity_main)


        EmailInput = findViewById(R.id.SingInEmail)
        PasswordInput = findViewById(R.id.SingInPassword)
        EnterButton = findViewById(R.id.SingInButton)
        RegisterButton = findViewById(R.id.RegisterButton)
        PasswordResetButton = findViewById(R.id.ResetButton)


        EnterButton.setOnClickListener {

            val Email = EmailInput.text.toString()
            val Password = PasswordInput.text.toString()

            mAuth.signInWithEmailAndPassword(Email, Password).addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    gotoPerson()
                } else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }


            }
            RegisterButton.setOnClickListener {
                startActivity(Intent(this, RegisterActivity::class.java))
            }

            PasswordResetButton.setOnClickListener {
                startActivity(Intent(this, ResetPasswordActivity::class.java))
            }


        }





    }


    private fun gotoPerson() {
        startActivity(Intent(this, PersonActivity::class.java))
        finish()




}



    }


}