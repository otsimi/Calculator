package com.simple.calculator

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentInput = ""
    private var operator = ""
    private var firstOperand = 0.0
    private var secondOperand = 0.0
    private lateinit var viewHolder:calculatorViewHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewHolder = calculatorViewHolder(findViewById(R.id.main))

        if (savedInstanceState != null) {
            currentInput = savedInstanceState.getString("currentInput", "")
            operator = savedInstanceState.getString("operator", "")
            firstOperand = savedInstanceState.getDouble("firstOperand", 0.0)
            secondOperand = savedInstanceState.getDouble("secondOperand", 0.0)
            viewHolder.display.text = savedInstanceState.getString("displayText", "0")
        }

        setNumberButtonListeners()
        setOperatorListeners()
        viewHolder.buttonClear.setOnClickListener { clear() }
        viewHolder.buttonEquals.setOnClickListener { calculateResult() }
    }

    private fun setNumberButtonListeners() {
        val buttons = listOf(
            viewHolder.button0,
            viewHolder.button1,
            viewHolder.button2,
            viewHolder.button3,
            viewHolder.button4,
            viewHolder.button5,
            viewHolder.button6,
            viewHolder.button7,
            viewHolder.button8,
            viewHolder.button9,
            viewHolder.buttonClear,
            viewHolder.buttonEquals

        )
        for (button in buttons) {
            button.setOnClickListener { appendNumber(button.text.toString()) }
        }
    }

    private fun setOperatorListeners() {
        val operators = mapOf(
            viewHolder.buttonPlus to "+",
            viewHolder.buttonMinus to "-",
            viewHolder.buttonMultiply to "*",
            viewHolder.buttonDivide to "/"
        )
        for ((button, op) in operators) {
            button.setOnClickListener { setOperator(op) }
        }
    }

    private fun appendNumber(number: String) {
        currentInput += number
        viewHolder.display.text = currentInput
    }

    private fun setOperator(op: String) {
        if (currentInput.isNotEmpty()) {
            firstOperand = currentInput.toDouble()
            currentInput += " $op "
            viewHolder.display.text = currentInput
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
            viewHolder.display.text = "${firstOperand.toString()} $operator ${secondOperand.toString()} = $result"
            currentInput = result.toString()
        }
    }

    private fun clear() {
        currentInput = ""
        operator = ""
        firstOperand = 0.0
        secondOperand = 0.0
        viewHolder.display.text = "0"
    }
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("currentInput", currentInput)
        outState.putString("operator", operator)
        outState.putDouble("firstOperand", firstOperand)
        outState.putDouble("secondOperand", secondOperand)
        outState.putString("displayText", viewHolder.display.text.toString())
    }
}
