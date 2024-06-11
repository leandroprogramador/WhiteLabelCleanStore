package com.leandro.whitelabelstore.utils

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText

class CurrencyTextWatcher(private val editText: EditText) : TextWatcher {
    private var currentValue : String = ""
    private var updating : Boolean = false
    override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

    }

    override fun afterTextChanged(s: Editable?) {
        if(updating) return
        val stringValue = s.toString()
        if(currentValue!=stringValue){
            updating = true
            val doubleValue = stringValue.fromCurrency()
            val formatted = getFormattedValue(doubleValue)
            updateValue(formatted)
        }
    }

    private fun getFormattedValue(value : Double) = if(value == 0.0) "" else value.toCurrency()

    private fun updateValue(formatted : String) {
        editText.setText(formatted)
        editText.setSelection(formatted.length)
        updating = false
    }
}