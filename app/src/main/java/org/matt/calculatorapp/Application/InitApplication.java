package org.matt.calculatorapp.Application;

import android.app.Application;
import android.content.Context;

import org.matt.calculatorapp.DI.AppComponent;
import org.matt.calculatorapp.DI.DaggerAppComponent;

public class InitApplication extends Application {

    private AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.create();
    }

    public static InitApplication get(Context context) {
        return (InitApplication) context.getApplicationContext();
    }

    public AppComponent getAppComponent() {
        return component;
    }
}
