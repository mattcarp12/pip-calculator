package org.matt.calculatorapp.Application;

import android.app.Application;

import org.matt.calculatorapp.DI.AppComponent;
import org.matt.calculatorapp.DI.DaggerAppComponent;

public class InitApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.create();
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
