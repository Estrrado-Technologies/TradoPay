package com.estrrado.tradopay.ui.app

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class TradoPay : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this@TradoPay)
    }
}