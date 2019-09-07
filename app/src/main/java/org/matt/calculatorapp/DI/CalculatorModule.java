package org.matt.calculatorapp.DI;

import org.matt.calculatorapp.Model.AppCalculator;
import org.matt.calculatorapp.Model.Calculator;

import dagger.Module;
import dagger.Provides;

@Module
public class CalculatorModule {

    @Provides
    Calculator providesCalculator(AppCalculator calculator) {
        return calculator;
    }
}
