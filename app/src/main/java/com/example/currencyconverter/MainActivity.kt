package com.example.currencyconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.currencyconverter.databinding.ActivityMainBinding
import java.math.RoundingMode
import kotlin.math.round

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var naira: Double = 0.0

    companion object{
        const val KEY_NAIRA = "naira_value"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(savedInstanceState != null) {
            naira = savedInstanceState.getInt(KEY_NAIRA, 0).toDouble()

        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.etBtc.text = naira.toString()

//        if(naira != 0.0) {
//        binding.etBtc.text = naira.toString()
//        }

        binding.btnConvert.setOnClickListener {
            calcBtc()
        }


    }
    private fun calcBtc() {
        val dollar = binding.etAmount.text.toString().toDoubleOrNull()

        if (dollar == null || dollar == 0.0) {
            dispBtc(0.0)
            return
        }
            naira = dollar * 500

            dispBtc(naira)
        }

        private fun dispBtc(btc: Double) {
            val btcValue = "$btc"
            binding.etBtc.text = getString(R.string.naira_equiv, btcValue)
        }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(KEY_NAIRA, naira.toInt())

    }
    }