package com.minjaeheo.bmicalckt

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import kotlin.math.pow

class ResultActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        // java에선 getIntent 지만 코틀린에선 그냥 intent로 통일
        val height = intent.getIntExtra("height", 0)
        val weight = intent.getIntExtra("weight", 0)

        Log.d("ResultActivity", "height : $height, weight = $weight")

        // pow는 double형을 넣어야 하기 때문에 변수에 double을 치환하는 것이 아닌
        // 나누는 값에 그냥 소숫점을 넣으면 double로 자동 치환이 된다.
        // java 방식은 math.pow(값, 곱할 값) 이지만 코틀린에선 이런 식으로 표현이 됨.
        val bmi = weight / (height / 100.0).pow(2.0)

        val resultText = when {
            bmi >= 35.0 -> "고도 비만"
            bmi >= 30.0 -> "중정도 비만"
            bmi >= 25.0 -> "경도 비만"
            bmi >= 23.0 -> "과체중 비만"
            bmi >= 18.5 -> "정상 체중"
            else -> "저체중"
        }

        val resultValueTextView = findViewById<TextView>(R.id.tv_bmiResult)
        val resultStringTextView = findViewById<TextView>(R.id.tv_result)

        resultValueTextView.text = bmi.toString()
        resultStringTextView.text = resultText
    }
}