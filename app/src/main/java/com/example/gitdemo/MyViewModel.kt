package com.example.gitdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel:ViewModel() {
    val _number = MutableLiveData(0)
    val number:LiveData<Int>
        get() = _number
    fun add(n:Int){
        _number.value = _number.value?.plus(n)
    }
    fun resetData(){
        _number.value = 0
    }
}