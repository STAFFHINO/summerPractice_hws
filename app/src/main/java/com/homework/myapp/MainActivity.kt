package com.homework.myapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var nameEditText: EditText
    private lateinit var heightEditText: EditText
    private lateinit var weightEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var calculateButton: Button
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.editTextName)
        heightEditText = findViewById(R.id.editTextHeight)
        weightEditText = findViewById(R.id.editTextWeight)
        ageEditText = findViewById(R.id.editTextAge)
        calculateButton = findViewById(R.id.buttonCalculate)
        resultTextView = findViewById(R.id.textViewResult)

        calculateButton.setOnClickListener {
            calculateResult()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun calculateResult() {
        val name = nameEditText.text.toString()
        val height = heightEditText.text.toString().toFloatOrNull()
        val weight = weightEditText.text.toString().toFloatOrNull()
        val age = ageEditText.text.toString().toIntOrNull()

        if (name.isEmpty() || height == null || weight == null || age == null) {
            resultTextView.text = "Данные введены некорректно."
            return
        }

        if (name.length > 50 || height <= 0 || height >= 250) {
            resultTextView.text = "Данные введены некорректно."
            return
        }
        if (weight <= 0 || weight >= 250) {
            resultTextView.text = "Данные введены некорректно."
            return
        }

        if (age <= 0 || age >= 150) {
            resultTextView.text = "Данные введены некорректно."
            return
        }
        val signs = listOf<String>("Овен","Телец","Близнецы","Рак","Лев","Дева",
            "Весы","Скорпион","Стрелец","Козерог","Водолей","Рыбы")
        val result = signs[(age * (name.length + (height - weight)) % 12).toInt()]
        resultTextView.text = "Ответ: you are $result"
    }
}