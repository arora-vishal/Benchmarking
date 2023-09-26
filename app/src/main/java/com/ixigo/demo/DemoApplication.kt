package com.ixigo.demo

import android.app.Application

class DemoApplication : Application(){
    override fun onCreate() {
        super.onCreate()
        // add some initialization stuff here which takes significant time
    }
}