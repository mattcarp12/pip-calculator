package org.matt.calculatorapp.DI;

import org.matt.calculatorapp.Application.InitApplication;
import org.matt.calculatorapp.Model.Calculator;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, CalculatorModule.class})
public interface AppComponent {
    void inject(InitApplication initApplication);

    Calculator getCalculator();
}
