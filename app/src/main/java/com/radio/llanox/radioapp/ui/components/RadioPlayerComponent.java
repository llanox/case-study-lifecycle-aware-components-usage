package com.radio.llanox.radioapp.ui.components;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

/**
 * @gabriel.gutierrez
 */

public class RadioPlayerComponent implements LifecycleObserver {

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void allocate() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void cleanUp() {

    }
}
