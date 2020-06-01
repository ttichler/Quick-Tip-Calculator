package com.example.quicktipcalculator

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Amount.addTextChangedListener(object : TextWatcher{

            override fun afterTextChanged(s: Editable) {}

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
                fif_per_text.text = calcTip(s.toString(), .15)
                twen_per_text.text = calcTip(s.toString(), .2)
                twenfive_per_text.text = calcTip(s.toString(), .25)
            }
        })
    }

    private fun calcTip(amount: String, tipAmount: Double): String {
        val toDouble = amount.toDouble()
        val tip = toDouble * tipAmount
        return tip.toString()
    }

}
