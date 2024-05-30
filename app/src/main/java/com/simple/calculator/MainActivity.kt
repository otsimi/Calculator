package com.simple.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentInput = ""
    private var operator = ""
    private var firstOperand = 0.0
    private var secondOperand = 0.0
    private lateinit var display: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        display = findViewById(R.id.textview)
        setNumberButtonListeners()
        setOperatorListeners()
        findViewById<Button>(R.id.buttonClear).setOnClickListener { clear() }
        findViewById<Button>(R.id.buttonEquals).setOnClickListener { calculateResult() }
    }

    private fun setNumberButtonListeners() {
        val buttons = listOf(
            findViewById<Button>(R.id.button0),
            findViewById<Button>(R.id.button1),
            findViewById<Button>(R.id.button2),
            findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button4),
            findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button9)
        )
        for (button in buttons) {
            button.setOnClickListener { appendNumber(button.text.toString()) }
        }
    }

    private fun setOperatorListeners() {
        val operators = mapOf(
            findViewById<Button>(R.id.buttonplus) to "+",
            findViewById<Button>(R.id.buttonminus) to "-",
            findViewById<Button>(R.id.buttonmultiply) to "*",
            findViewById<Button>(R.id.buttondivide) to "/"
        )
        for ((button, op) in operators) {
            button.setOnClickListener { setOperator(op) }
        }
    }

    private fun appendNumber(number: String) {
        currentInput += number
        display.text = currentInput
    }

    private fun setOperator(op: String) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDouble()
            currentInput += " $op "
            display.text = currentInput
            currentInput = ""
            operator = op
        }
    }

    private fun calculateResult() {
        if (currentInput.isNotEmpty()) {
            secondOperand = currentInput.toDouble()
            val result = when (operator) {
                "+" -> firstOperand + secondOperand
                "-" -> firstOperand - secondOperand
                "*" -> firstOperand * secondOperand
                "/" -> firstOperand / secondOperand
                else -> 0.0
            }
            display.text = "${firstOperand.toString()} $operator ${secondOperand.toString()} = $result"
            currentInput = result.toString()
        }
    }

    private fun clear() {
        currentInput = ""
        operator = ""
        firstOperand = 0.0
        secondOperand = 0.0
        display.text = "0"
    }
}
