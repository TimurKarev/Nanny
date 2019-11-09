package com.maryjustudio.radionanny.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    // TODO: Implement the ViewModel

    val message = MutableLiveData<Any>()

    fun setMsgCommunicator(msg:String){
        message.setValue(msg)
    }
}
