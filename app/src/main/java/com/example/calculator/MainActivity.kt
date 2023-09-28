package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var action:Button=findViewById(R.id.btnOperation)
        var plus:Button=findViewById(R.id.btnPlus)
        var minus:Button=findViewById(R.id.btnMinus)
        var multiple:Button=findViewById(R.id.btnX)
        var divide:Button=findViewById(R.id.btnDivide)
        var point:Button=findViewById(R.id.btnPoint)
        var left:Button=findViewById(R.id.btnOpen)
        var right:Button=findViewById(R.id.btnClose)
        var numberOne:TextView=findViewById(R.id.tvNum1)
        var numberTwo:TextView=findViewById(R.id.tvNum2)
        var result:TextView=findViewById(R.id.tvResult)
        var numNull: Button =findViewById(R.id.btn0)
        var numOne:Button=findViewById(R.id.btn1)
        var numTwo:Button=findViewById(R.id.btn2)
        var numThree:Button=findViewById(R.id.btn3)
        var numFour:Button=findViewById(R.id.btn4)
        var numFive:Button=findViewById(R.id.btn5)
        var numSix:Button=findViewById(R.id.btn6)
        var numSeven:Button=findViewById(R.id.btn7)
        var numEight:Button=findViewById(R.id.btn8)
        var numNine:Button=findViewById(R.id.btn9)
        var C:Button=findViewById(R.id.btnC)
        var AC:Button=findViewById(R.id.btnAC)
        var equal:Button=findViewById(R.id.btnEqual)
        val answer:Int=0
        var switcher=1




        fun calculate(tv1: TextView, tv2: TextView, oper: Button): String {
            val x = tv1.text.toString().toDouble()
            val y = tv2.text.toString().toDouble()
            val op = oper.text.toString()
            var otv = ""
            var sum = when (op) {
                "+" -> (x + y)
                "-" -> (x - y)
                "*" -> (x * y)
                "/" -> (x / y)
                else -> 0.0
            }
            if ((sum * 10 % 10).equals(0.0)) {
                otv = sum.toInt().toString()
            } else {
                otv = sum.toString()
            }
            return otv
        }

        AC.setOnClickListener {
            if(switcher==1){
                numberOne.text=numberOne.text.toString().dropLast(1)
            }
            if(switcher==2){
                numberTwo.text=numberTwo.text.toString().dropLast(1)
            }
        }

        point.setOnClickListener {
            if (action.text.isEmpty()) {
            val currentText = numberOne.text.toString()
            val buttonText = point.text.toString()
            numberOne.text = currentText + buttonText
        } else {
            val currentText = numberTwo.text.toString()
            val buttonText = point.text.toString()
            numberTwo.text = currentText + buttonText
        }  }

        equal.setOnClickListener {
            if((numberOne.text.isNotEmpty()&&numberTwo.text.isNotEmpty())||result.text.isNotEmpty()&&numberTwo.text.isNotEmpty())
            result.text=calculate(numberOne,numberTwo,action)
        }

        C.setOnClickListener {
            numberOne.setText(null)
            numberTwo.setText(null)
            action.setText(null)
            result.setText(null)
            switcher=1
        }

        plus.setOnClickListener {
            if(result.text.toString().isNotEmpty()){
                switcher=2
                numberOne.setText(result.text.toString())
                action.text=plus.text.toString()
                numberTwo.setText(null)
            }
            if(!numberOne.text.isEmpty()){
                action.text=plus.text.toString()
                switcher=2
            }
        }

        minus.setOnClickListener {
            if(result.text.toString().isNotEmpty()){
                switcher=2
                numberOne.setText(result.text.toString())
                action.text=minus.text.toString()
                numberTwo.setText(null)
            }
            if(!numberOne.text.isEmpty()){
            action.text=minus.text.toString()
                switcher=2
        }
        }

        divide.setOnClickListener {
            if(result.text.toString().isNotEmpty()){
                switcher=2
                numberOne.setText(result.text.toString())
                action.text=divide.text.toString()
                numberTwo.setText(null)
            }
            if(!numberOne.text.isEmpty()){
            action.text=divide.text.toString()
                switcher=2
        }
        }

        multiple.setOnClickListener {
            if(result.text.toString().isNotEmpty()){
                switcher=2
                numberOne.setText(result.text.toString())
                action.text=multiple.text.toString()
                numberTwo.setText(null)
            }
            if(!numberOne.text.isEmpty()) {
                action.text = multiple.text.toString()
            switcher=2}
        }

        left.setOnClickListener { switcher=1 }
        right.setOnClickListener { switcher=2 }

        val inptNums = View.OnClickListener {
            if (switcher == 1) {
                val s = "${numberOne.text.toString()}${(it as Button).text}"
                numberOne.setText(s)
            } else if(switcher==2) {
                val s = "${numberTwo.text.toString()}${(it as Button).text}"
                numberTwo.setText(s)
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
        point.setOnClickListener(inptNums)



    }
}


