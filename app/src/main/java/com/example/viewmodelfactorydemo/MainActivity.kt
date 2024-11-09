package com.example.viewmodelfactorydemo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatTextView
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
    private var txtCounter: AppCompatTextView? = null
    private var btnIncreaseCounter: AppCompatButton? = null
    private var mainViewModel: MainViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()

        btnIncreaseCounter?.setOnClickListener {
            mainViewModel?.increaseCounter()
            setCounterValue()
        }
    }

    private fun initViews() {
        btnIncreaseCounter = findViewById(R.id.btn_increase_counter)
        txtCounter = findViewById(R.id.txt_counter)

        mainViewModel = ViewModelProvider(this, MainViewModelFactory(10))[MainViewModel::class.java]
        setCounterValue()
    }

    private fun setCounterValue() {
        txtCounter?.text = mainViewModel?.counter.toString()
    }
}