package org.matt.calculatorapp.Application;

import android.app.Application;

import org.matt.calculatorapp.DI.AppComponent;
import org.matt.calculatorapp.DI.DaggerAppComponent;
import org.matt.calculatorapp.Model.AppCalculator;

import javax.inject.Inject;
import javax.inject.Singleton;

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
