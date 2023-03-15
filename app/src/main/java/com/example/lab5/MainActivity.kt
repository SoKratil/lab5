package com.example.lab5

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    private lateinit var Button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Button= findViewById(R.id.button)
        val dotgroup : RadioGroup = findViewById(R.id.dotgroup)
        val edittext : EditText = findViewById(R.id.addnum)
        var price = 0



        dotgroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.A4 -> price = 10
                R.id.A3 -> price = 30
                R.id.A2 -> price = 100
            }
        }
        Button.setOnClickListener {

            if (dotgroup.checkedRadioButtonId == -1) {

                Toast.makeText(this, "Нужно выбрать формат листа!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val pagesText = edittext.text.toString()
            if (pagesText.isBlank() || !pagesText.matches("\\d+".toRegex())) {
                Toast.makeText(this, "Cтрока пустая!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

                val pages = edittext.text.toString().toInt()
            val totalprice = pages * price
            try {
                val intent = Intent(this, MainActivity2::class.java)
                intent.putExtra("total_price", totalprice)
                startActivity(intent)
            }
            catch (e: Exception) {
                e.printStackTrace()
                Toast.makeText(this, "Произошла ошибка: ${e.message}", Toast.LENGTH_SHORT).show()
            }







        }
    }

}





