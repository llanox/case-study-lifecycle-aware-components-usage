package com.radio.llanox.radioapp.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.radio.llanox.radioapp.R;
import com.radio.llanox.radioapp.ui.components.AnalyticsComponent;
import com.radio.llanox.radioapp.ui.components.ErrorTrackingComponent;
import com.radio.llanox.radioapp.ui.components.NetworkComponent;
import com.radio.llanox.radioapp.ui.components.RadioPlayerComponent;

/**
 *  @gabriel.gutierrez
 */
public class RadioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
        getLifecycle().addObserver(new AnalyticsComponent());
        getLifecycle().addObserver(new ErrorTrackingComponent());
        getLifecycle().addObserver(new NetworkComponent());
        getLifecycle().addObserver(new RadioPlayerComponent());
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}
