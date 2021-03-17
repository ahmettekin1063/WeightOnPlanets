package com.ahmettekin.weightonplanets

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), CompoundButton.OnCheckedChangeListener,
    View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        textView.text=savedInstanceState?.getString("sonuc")

        Glide.with(this).load(R.drawable.space).into(imageView)
        /* saturn.setOnCheckedChangeListener { _, isChecked ->
              if (isChecked && dunyaKilo.text.isNotEmpty()) {
                  val dunyaKilo = dunyaKilo.text.toString().toDouble()
                  textView.text = "Satürn'deki kilonuz: ${String.format("%.2f", dunyaKilo * 0.982)}"
                  mars.isChecked = false
                  jupiter.isChecked = false
              } else if (isChecked && dunyaKilo.text.isEmpty()) {
                  Toast.makeText(applicationContext, "Lütfen bir değer girin", Toast.LENGTH_LONG)
                      .show()
                  saturn.isChecked = false
              }
          }

          mars.setOnCheckedChangeListener { _, isChecked ->
              if (isChecked && dunyaKilo.text.isNotEmpty()) {
                  val dunyaKilo = dunyaKilo.text.toString().toDouble()
                  textView.text = "Mars'taki kilonuz: ${String.format("%.2f", dunyaKilo * 0.377)}"
                  saturn.isChecked = false
                  jupiter.isChecked = false
              } else if (isChecked && dunyaKilo.text.isEmpty()) {
                  Toast.makeText(applicationContext, "Lütfen bir değer girin", Toast.LENGTH_LONG)
                      .show()
                  mars.isChecked = false
              }

          }

          jupiter.setOnCheckedChangeListener { _, isChecked ->
              if (isChecked && dunyaKilo.text.isNotEmpty()) {
                  val dunyaKilo = dunyaKilo.text.toString().toDouble()
                  textView.text = "Jüpiter'deki kilonuz: ${String.format("%.2f", dunyaKilo * 2.33)}"
                  mars.isChecked = false
                  saturn.isChecked = false
              } else if (isChecked && dunyaKilo.text.isEmpty()) {
                  Toast.makeText(applicationContext, "Lütfen bir değer girin", Toast.LENGTH_LONG).show()
                  jupiter.isChecked = false
              }
          }*/

        jupiter.setOnCheckedChangeListener(this)
        saturn.setOnCheckedChangeListener(this)
        mars.setOnCheckedChangeListener(this)

        venus.setOnClickListener(this)
        uranus.setOnClickListener(this)
        neptun.setOnClickListener(this)

        //radioGroup.setOnCheckedChangeListener(this)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("sonuc",textView.text.toString())

    }

    override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {

        if (isChecked && dunyaKilo.text.isNotEmpty()) {
            val dunyaKilo = dunyaKilo.text.toString().toDouble()
            buttonView?.hesapla(dunyaKilo)
        } else if (isChecked && dunyaKilo.text.isEmpty()) {
            Toast.makeText(applicationContext, "Lütfen bir değer girin", Toast.LENGTH_LONG).show()
            buttonView?.isChecked = false
        }
    }

    fun CompoundButton.hesapla(dunyaKilo: Double) {
        when (this.id) {
            R.id.jupiter -> {
                textView.text = "Jüpiter'deki kilonuz: ${String.format("%.2f", dunyaKilo * 2.33)}"
                mars.isChecked = false
                saturn.isChecked = false
            }
            R.id.mars -> {
                textView.text = "Mars'taki kilonuz: ${String.format("%.2f", dunyaKilo * 0.377)}"
                jupiter.isChecked = false
                saturn.isChecked = false
            }
            R.id.saturn -> {
                textView.text = "Satürn'deki kilonuz: ${String.format("%.2f", dunyaKilo * 0.982)}"
                mars.isChecked = false
                jupiter.isChecked = false
            }
        }
    }


    /*override fun onCheckedChanged(group: RadioGroup?, checkedId: Int) {

        checkedRadioButton = group?.findViewById(checkedId)!!
        var isChecked = checkedRadioButton?.isChecked


        if (isChecked!! && dunyaKilo.text.isNotEmpty()) {
            val dunyaKilo = dunyaKilo.text.toString().toDouble()
            checkedRadioButton?.hesapla(dunyaKilo)

        } else if (isChecked && dunyaKilo.text.isEmpty()) {
            Toast.makeText(applicationContext, "Lütfen bir değer girin", Toast.LENGTH_LONG).show()
            checkedRadioButton?.isChecked = false
        }

    }*/

    fun RadioButton.hesapla(dunyaKilo: Double) {

        when (this.id) {
            R.id.neptun -> textView.text =
                "Neptün'deki kilonuz: ${String.format("%.2f", dunyaKilo * 2.33)}"

            R.id.uranus -> textView.text =
                "Uranüs'teki kilonuz: ${String.format("%.2f", dunyaKilo * 0.377)}"

            R.id.venus -> textView.text =
                "Venüs'deki kilonuz: ${String.format("%.2f", dunyaKilo * 0.982)}"
        }
    }

    override fun onClick(v: View?) {

        v as RadioButton
        val checked = v.isChecked
        if (checked && dunyaKilo.text.isNotEmpty()) {
            val dunyaKilo = dunyaKilo.text.toString().toDouble()
            v.hesapla(dunyaKilo)
        } else if (checked && dunyaKilo.text.isEmpty()) {
            Toast.makeText(applicationContext, "Lütfen bir değer girin", Toast.LENGTH_LONG).show()
        }
    }
}
