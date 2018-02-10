#Case Study Where We Can Use Lifecycle Aware Components to Improve Our Apps
How to use the new Google library lifecycle aware component to improve some aspects regarding with maintainability and reliability concerns for Android apps.

##Example App Radio APP without LifeCycle Aware Components

*Before*
```Java

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

```

*After*

```Java
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
```

