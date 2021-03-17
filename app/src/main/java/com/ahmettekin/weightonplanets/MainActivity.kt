package com.ahmettekin.weightonplanets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        saturn.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked && dunyaKilo.text.isNotEmpty()) {
                val dunyaKilo = dunyaKilo.text.toString().toDouble()
                textView.text = "Satürn'deki kilonuz: ${String.format("%.2f",dunyaKilo * 0.982)}"
                mars.isChecked = false
                jupiter.isChecked = false
            } else if (isChecked && dunyaKilo.text.isEmpty()) {
                Toast.makeText(this, "Lütfen bir değer girin", Toast.LENGTH_LONG).show()
                saturn.isChecked = false
            }
        }

        mars.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked && dunyaKilo.text.isNotEmpty()) {
                val dunyaKilo = dunyaKilo.text.toString().toDouble()
                textView.text = "Mars'taki kilonuz: ${String.format("%.2f",dunyaKilo * 0.377)}"
                saturn.isChecked = false
                jupiter.isChecked = false
            } else if (isChecked && dunyaKilo.text.isEmpty()) {
                Toast.makeText(this, "Lütfen bir değer girin", Toast.LENGTH_LONG).show()
                mars.isChecked = false
            }

        }
        
        jupiter.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked && dunyaKilo.text.isNotEmpty()) {
                val dunyaKilo = dunyaKilo.text.toString().toDouble()
                textView.text = "Jüpiter'deki kilonuz: ${String.format("%.2f",dunyaKilo * 2.33)}"
                mars.isChecked = false
                saturn.isChecked = false
            } else if (isChecked && dunyaKilo.text.isEmpty()) {
                Toast.makeText(this, "Lütfen bir değer girin", Toast.LENGTH_LONG).show()
                jupiter.isChecked = false
            }
        }
    }
}
