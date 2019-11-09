package com.maryjustudio.radionanny

import android.app.Application
import android.content.Context
import com.maryjustudio.radionanny.model.main.MainModel

class NannyApp : Application() {

    val model: MainModel
        get() = MainModel()

    companion object {
        var ctx: Context? = null
    }

    override fun onCreate() {
        super.onCreate()
        ctx = applicationContext
    }
}