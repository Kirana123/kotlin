package com.example.edittext

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.regex.Pattern

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val mobile:EditText = findViewById<EditText>(R.id.editText)
    //    val email:EditText = findViewById<EditText>(R.id.editText)
        val btn:Button = findViewById<Button>(R.id.button)
        btn.setOnClickListener {
            Toast.makeText(this, "Details saved successfully.", Toast.LENGTH_SHORT).show();
        }

        mobile.addTextChangedListener(object :TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                   if(mobileValidate(mobile.text.toString()))
                      btn.isEnabled = true;
                else {
                        btn.isEnabled = false;
                        mobile.setError("Invalid number")
                       // email.setError("Email is invaid")
                   }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })

    }

    private fun mobileValidate(text: String?): Boolean {
        var p = Pattern.compile("[6-9][0-9]{9}")
        var m = p.matcher(text)
        return m.matches()
    }
}