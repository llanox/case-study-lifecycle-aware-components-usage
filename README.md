# Case Study Where We Can Use Lifecycle Aware Components to Improve Our Apps
How to use the new Google library lifecycle aware component to improve some aspects regarding with maintainability and reliability concerns for Android apps.

## Example Dummy App Radio APP

As an example, Radio APP has several components. All these components need to trigger some process on specific lifecycle events. Currently, we can't be sure that the Android system is going to call the lifecycle callback's in order. So, if one of these components try to execute a process in a non-valid state we get an error and also to impact the reliability of the application. In addition, when the components make part of third party library who are using it needs to know what process to execute for each lifecycle callback and duplicate that code in each Activity/Fragment that needs be aware of executing these processes. So, that library becomes hard to maintain and use. 

**Before**
https://github.com/llanox/case-study-lifecycle-aware-components-usage/blob/master/app/src/main/java/com/radio/llanox/radioapp/ui/RadioActivity.java
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
**After**
https://github.com/llanox/case-study-lifecycle-aware-components-usage/blob/feature/lifecycle_aware_components/app/src/main/java/com/radio/llanox/radioapp/ui/RadioActivity.java

Making components lifecycle aware, we delegate all logic to the component itself. So, who's using one of these components only need to add them as observers to the current LifeCycle and don't care anymore about it. With that simple implementation, we've improved the maintainability and reliability of our app.

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

