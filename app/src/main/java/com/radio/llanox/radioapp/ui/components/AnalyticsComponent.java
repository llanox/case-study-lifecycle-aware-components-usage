package com.radio.llanox.radioapp.ui.components;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * @gabriel.gutierrez
 */

public class AnalyticsComponent implements LifecycleObserver{

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void init() {
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void finish() {
    }
}
