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

    private AnalyticsComponent analyticsComponent;
    private ErrorTrackingComponent errorTrackingComponent;
    private NetworkComponent networkComponent;
    private RadioPlayerComponent radioPlayerComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);

        analyticsComponent = new AnalyticsComponent();
        errorTrackingComponent = new ErrorTrackingComponent();
        networkComponent = new NetworkComponent();
        radioPlayerComponent = new RadioPlayerComponent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        analyticsComponent.init();
        errorTrackingComponent.start();
        networkComponent.start();
        radioPlayerComponent.allocate();

    }

    @Override
    protected void onStop() {
        super.onStop();
        analyticsComponent.finish();
        errorTrackingComponent.stop();
        networkComponent.stop();
        radioPlayerComponent.cleanUp();
    }
}
