package com.radio.llanox.radioapp.ui.components;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * @gabriel.gutierrez
 */

public class ErrorTrackingComponent implements LifecycleObserver {


    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void start() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void stop() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void sendCollectedData(){

    }
}
