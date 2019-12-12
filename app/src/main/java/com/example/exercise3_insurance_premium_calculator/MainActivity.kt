package com.example.exercise3_insurance_premium_calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {
    lateinit var spinnerage: Spinner
    lateinit var gender: RadioGroup
    lateinit var smoker: CheckBox
    lateinit var viewpremium: TextView
    lateinit var buttonCal: Button
    lateinit var btnReset: Button

    private val premiumPrice: IntArray = intArrayOf(60, 70, 90, 120, 150, 150)
    private val extraMalePrice: IntArray = intArrayOf(0, 50, 100, 150, 200, 200)
    private val extraSmokerPrice: IntArray = intArrayOf(0, 100, 150, 200, 250, 300)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        spinnerage = findViewById(R.id.spinnerAge)
        gender = findViewById(R.id.radioGroupGender)
        smoker = findViewById(R.id.checkBoxSmoker)
        viewpremium = findViewById(R.id.textViewPremium)
        buttonCal = findViewById(R.id.buttonCalculate)
        buttonCal.setOnClickListener { CalculateInsurance() }
        btnReset = findViewById(R.id.buttonReset)
        btnReset.setOnClickListener { Reset() }
    }

    private fun CalculateInsurance() {
        var premiumTotal = 0
        if (spinnerage.selectedItemPosition != -1) {
            premiumTotal += premiumPrice[spinnerage.selectedItemPosition]
        }

        if (gender.radioButtonMale.isChecked) {
            premiumTotal += extraMalePrice[spinnerage.selectedItemPosition]
        }

        if (smoker.isChecked) {
            premiumTotal += extraSmokerPrice[spinnerage.selectedItemPosition]
        }

        viewpremium.text = ("Insurance Premium: RM" + premiumTotal)
    }

    private fun Reset() {
        spinnerage.setSelection(0)
        gender.clearCheck()
        viewpremium.text = ("Insurance Premium:")
        if (smoker.isChecked) {
            smoker.toggle()
        }
    }
}