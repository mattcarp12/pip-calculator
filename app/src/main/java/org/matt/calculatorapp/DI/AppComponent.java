package org.matt.calculatorapp.DI;

import org.matt.calculatorapp.AppView.MainActivity;
import org.matt.calculatorapp.Application.InitApplication;
import org.matt.calculatorapp.Model.Calculator;

import dagger.Component;

@Component (modules = {AppModule.class, ContextModule.class, CalculatorModule.class})
public interface AppComponent {
    void inject(InitApplication initApplication);
    Calculator getCalculator();
}
