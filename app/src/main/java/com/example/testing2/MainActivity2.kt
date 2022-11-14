package com.example.testing2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity2 : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnPindah: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btnPindah = findViewById(R.id.button_pindah2)

        btnPindah.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        if(v.id == R.id.button_pindah2){
            val moveIntent = Intent(this@MainActivity2, MainActivity::class.java)
            startActivity(moveIntent)
        }
    }
}