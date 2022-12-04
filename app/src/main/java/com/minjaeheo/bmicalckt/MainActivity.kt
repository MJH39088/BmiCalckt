package com.minjaeheo.bmicalckt

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // xml에서 Ctrl + Alt + L 을 누르면 코드들을 재정렬 할 수 있음.

        // 명시적 표시
        val et_height : EditText = findViewById(R.id.et_height)
        val et_weight : EditText = findViewById(R.id.et_weight)

        // 추론적 표시
        val btn_result = findViewById<Button>(R.id.btn_result)

        // 람다식으로 치환하여 {} 사용  자바는 ()을 쓰는 전통적인 방식
        btn_result.setOnClickListener{
            Log.d("MainActivity", "btn_result 버튼이 클릭되었습니다.")

            // null 체크를 하지 않으면 익셉션이 뜨면서 앱이 강제 종료 됨.
            if (et_height.text.isEmpty() || et_weight.text.isEmpty()) {
                Toast.makeText(this, "빈 값이 있어요.", Toast.LENGTH_SHORT).show()

                // 현재 onCreate, onClick 안에 있기 때문에 어떤 부분에서 리턴을 해야하는지 명시
                return@setOnClickListener
            }
            // 이 아래로는 절대 빈 값이 올 수가 없음.
            // 정수값을 입력받아야 하기 때문에 String 형식으로 변환 후 다시 Int형으로 변환
            val height : Int = et_height.text.toString().toInt()
            val weight : Int = et_weight.text.toString().toInt()

            // $변수 를 쓰면 변수 값을 로그에서 볼 수 있다.
            Log.d("MainActivity", "height : $height, weight = $weight")

            // 매개변수는 (넘어가기 전 클래스, 넘어갈 클래스::class.java) 자바의 클래스.class와 같다.
            val intent = Intent(this, ResultActivity::class.java)

            intent.putExtra("height", height)
            intent.putExtra("weight", weight)

            startActivity(intent)

        }
    }
}