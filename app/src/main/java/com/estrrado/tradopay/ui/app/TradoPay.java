package com.estrrado.tradopay.ui.app;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;

public class TradoPay extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Fresco.initialize(TradoPay.this);
    }
}
