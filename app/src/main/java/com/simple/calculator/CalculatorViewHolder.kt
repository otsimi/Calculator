package com.simple.calculator

import android.view.View
import android.widget.Button
import android.widget.TextView

class CalculatorViewHolder(view:View) {
    val display: TextView = view.findViewById(R.id.textview)
    val button0: Button = view.findViewById(R.id.button0)
    val button1: Button = view.findViewById(R.id.button1)
    val button2: Button = view.findViewById(R.id.button2)
    val button3: Button = view.findViewById(R.id.button3)
    val button4: Button = view.findViewById(R.id.button4)
    val button5: Button = view.findViewById(R.id.button5)
    val button6: Button = view.findViewById(R.id.button6)
    val button7: Button = view.findViewById(R.id.button7)
    val button8: Button = view.findViewById(R.id.button8)
    val button9: Button = view.findViewById(R.id.button9)

    val buttonPlus: Button = view.findViewById(R.id.buttonplus)
    val buttonMinus: Button = view.findViewById(R.id.buttonminus)
    val buttonMultiply: Button = view.findViewById(R.id.buttonmultiply)
    val buttonDivide: Button = view.findViewById(R.id.buttondivide)

    val buttonClear: Button = view.findViewById(R.id.buttonClear)
    val buttonEquals: Button = view.findViewById(R.id.buttonEquals)
}