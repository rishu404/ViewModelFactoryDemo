package com.example.viewmodelfactorydemo

import androidx.lifecycle.ViewModel
import com.example.viewmodelfactorydemo.utils.AppUtils

class MainViewModel(initialCounter: Int) : ViewModel() {
    var counter: Int = initialCounter

    fun increaseCounter() {
        counter++
        AppUtils.showLog("counter: $counter")
    }

}