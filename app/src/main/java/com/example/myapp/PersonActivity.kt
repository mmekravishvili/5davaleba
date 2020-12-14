package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class PersonActivity : AppCompatActivity() {

    private lateinit var userinfoTextView: TextView
    private lateinit var changePasswordButton: Button
    private lateinit var LogoutBotton : Button

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person)

        userinfoTextView = findViewById(R.id.UserInfotextView)
        changePasswordButton = findViewById(R.id.PasswordChangeButton)
        LogoutBotton = findViewById(R.id.LogoutButton)

        userinfoTextView.text = auth.currentUser?.uid

        LogoutBotton.setOnClickListener {
            auth.signOut()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        changePasswordButton.setOnClickListener {
            startActivity(Intent(this, ChangePasswordActivity::class.java))
        }
    }
}