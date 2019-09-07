package org.matt.calculatorapp.DI;

import android.app.Application;

import org.matt.calculatorapp.Application.InitApplication;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class AppModule {

    private InitApplication initApplication;

    public AppModule(InitApplication initApplication) {
        this.initApplication = initApplication;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return initApplication;
    }

}
