package com.example.testing2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.text.TextUtils
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var editLength: EditText
    private lateinit var editWidth: EditText
    private lateinit var editHeight: EditText
    private lateinit var btnCalculate: Button
    private lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editLength = findViewById(R.id.edit_length)
        editWidth = findViewById(R.id.edit_width)
        editHeight = findViewById(R.id.edit_height)
        btnCalculate = findViewById(R.id.button_calculate)
        tvResult = findViewById(R.id.tv_result)

        btnCalculate.setOnClickListener(this)

        if(savedInstanceState != null){
            val result = savedInstanceState.getString("STATE_RESULT") as String
            tvResult.text = result
        }
    }

    override fun onClick(view: View) {
        if(view.id == R.id.button_calculate){

            var isEmpty: Boolean = false
            var isDouble: Boolean = false

            var inputLength: String = editLength.text.toString().trim()
            var inputWidth: String = editWidth.text.toString().trim()
            var inputHeight: String = editHeight.text.toString().trim()

            var length: Double? = convertToDouble(inputLength)
            var width: Double? = convertToDouble(inputWidth)
            var height: Double? = convertToDouble(inputHeight)

            if(TextUtils.isEmpty(inputLength)){
                isEmpty = true
                editLength.error = "Tidak Boleh Kosong"
            }
            else if(length == null){
                isDouble = true
                editLength.error = "Nilai Tidak Valid"
            }
            if(TextUtils.isEmpty(inputWidth)){
                isEmpty = true
                editWidth.error = "Tidak Boleh Kosong"
            }
            else if(width == null){
                isDouble = true
                editWidth.error = "Nilai Tidak Valid"
            }
            if(TextUtils.isEmpty(inputHeight)) {
                isEmpty = true
                editHeight.error = "Tidak Boleh Kosong"
            }
            else if(height == null){
                isDouble = true
                editHeight.error = "Nilai Tidak Valid"
            }

            if(!isDouble && !isEmpty){
                if(length != null && width != null && height != null) {
                    var volume: Double = length * width * height
                    tvResult.text = volume.toString()
                }
            }
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("STATE_RESULT", tvResult.text.toString())
    }

    private fun convertToDouble(str: String):Double?{

        return try {
            str.toDouble()
        }catch (e : NumberFormatException){
            null
        }
    }
}