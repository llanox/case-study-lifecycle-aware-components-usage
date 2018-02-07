package com.radio.llanox.radioapp.ui.components;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * @gabriel.gutierrez
 */

public class NetworkComponent implements LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_ANY)
    public void validate(){

    }


    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {

    }
}
