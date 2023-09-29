package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val action: Button = findViewById(R.id.btnOperation)
        val plus: Button = findViewById(R.id.btnPlus)
        val minus: Button = findViewById(R.id.btnMinus)
        val multiple: Button = findViewById(R.id.btnX)
        val divide: Button = findViewById(R.id.btnDivide)
        val point: Button = findViewById(R.id.btnPoint)
        val left: Button = findViewById(R.id.btnOpen)
        val right: Button = findViewById(R.id.btnClose)
        val numberOne: TextView = findViewById(R.id.tvNum1)
        val numberTwo: TextView = findViewById(R.id.tvNum2)
        val result: TextView = findViewById(R.id.tvResult)
        val numNull: Button = findViewById(R.id.btn0)
        val numOne: Button = findViewById(R.id.btn1)
        val numTwo: Button = findViewById(R.id.btn2)
        val numThree: Button = findViewById(R.id.btn3)
        val numFour = findViewById<Button>(R.id.btn4)
        val numFive: Button = findViewById(R.id.btn5)
        val numSix: Button = findViewById(R.id.btn6)
        val numSeven: Button = findViewById(R.id.btn7)
        val numEight: Button = findViewById(R.id.btn8)
        val numNine: Button = findViewById(R.id.btn9)
        val C: Button = findViewById(R.id.btnC)
        val AC: Button = findViewById(R.id.btnAC)
        val equal: Button = findViewById(R.id.btnEqual)
        var switcher = 1


        fun calculate(tv1: TextView, tv2: TextView, oper: Button): String {
            val x = tv1.text.toString().toDouble()
            val y = tv2.text.toString().toDouble()
            val op = oper.text.toString()
            var otv=""
            val sum = when (op) {
                "+" -> (x + y)
                "-" -> (x - y)
                "*" -> (x * y)
                "/" -> (x / y)
                else -> 0.0
            }
            if ((sum * 10 % 10).equals(0.0)) {
                otv = sum.toInt().toString()
            } else {
                otv = "%.1f".format(sum).toString()
            }
            return otv
        }

        AC.setOnClickListener {
            if(result.text.isNotEmpty()){
                numberTwo.setText(null)
                numberOne.setText(result.text.toString())
                result.setText(null)
                action.setText(null)
                switcher=1
            }
            if (switcher == 1) {
                numberOne.text = numberOne.text.toString().dropLast(1)
            }
            if (switcher == 2) {
                numberTwo.text = numberTwo.text.toString().dropLast(1)
            }
        }

        point.setOnClickListener {
            if(result.text.isNotEmpty()){
                if (!result.text.toString().contains(".")) {
                    val currentText = result.text.toString()
                    val buttonText = point.text.toString()
                    numberOne.text = currentText + buttonText
                    numberTwo.setText(null)
                    result.setText(null)
                    switcher=1
                    action.setText(null)
                }
                else{
                    val currentText = result.text.toString()
                    numberOne.text = currentText
                    numberTwo.setText(null)
                    result.setText(null)
                    switcher=1
                    action.setText(null)
                }
            }
            if (switcher == 1) {
                if (!numberOne.text.toString().contains(".")) {
                    val currentText = numberOne.text.toString()
                    val buttonText = point.text.toString()
                    numberOne.text = currentText + buttonText
                }
            } else {
                if (!numberTwo.text.toString().contains(".")) {
                    val currentText = numberTwo.text.toString()
                    val buttonText = point.text.toString()
                    numberTwo.text = currentText + buttonText
                }
            }
        }

        equal.setOnClickListener {
            if ((numberOne.text.isNotEmpty() && numberTwo.text.isNotEmpty()) || result.text.isNotEmpty() && numberTwo.text.isNotEmpty())
                result.text = calculate(numberOne, numberTwo, action)
        }

        C.setOnClickListener {
            numberOne.setText(null)
            numberTwo.setText(null)
            action.setText(null)
            result.setText(null)
            switcher = 1
        }



        left.setOnClickListener { switcher = 1 }
        right.setOnClickListener { switcher = 2 }

        val inptNums = View.OnClickListener {
//            if(result.text.isNotEmpty()){
//                numberTwo.setText(null)
//                numberOne.setText(result.text.toString())
//                result.setText(null)
//                action.setText(null)
//                switcher=1
//            }
            if (switcher == 1) {
                val s = "${numberOne.text.toString()}${(it as Button).text}"
                numberOne.setText(s)
            } else if (switcher == 2) {
                val s = "${numberTwo.text.toString()}${(it as Button).text}"
                numberTwo.setText(s)
            }
        }

        val inptActions = View.OnClickListener{
            if(action.text.isNotEmpty()&&numberOne.text.isNotEmpty()&&numberTwo.text.isNotEmpty()){
                result.text=calculate(numberOne,numberTwo,action)
                numberOne.setText(null)
                numberTwo.setText(null)
                val s = "${(it as Button).text}"
                action.setText(s)
                numberOne.setText(result.text)
                result.setText(null)
                switcher=2
            }
            else{
                val s = "${(it as Button).text}"
                action.setText(s)
                switcher=2
            }
        }


        numNull.setOnClickListener(inptNums)
        numOne.setOnClickListener(inptNums)
        numTwo.setOnClickListener(inptNums)
        numThree.setOnClickListener(inptNums)
        numFour.setOnClickListener(inptNums)
        numFive.setOnClickListener(inptNums)
        numSix.setOnClickListener(inptNums)
        numSeven.setOnClickListener(inptNums)
        numEight.setOnClickListener(inptNums)
        numNine.setOnClickListener(inptNums)


        plus.setOnClickListener(inptActions)
        minus.setOnClickListener(inptActions)
        divide.setOnClickListener(inptActions)
        multiple.setOnClickListener(inptActions)

    }
}

