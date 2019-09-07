package org.matt.calculatorapp.DI;

import org.matt.calculatorapp.Model.AppCalculator;
import org.matt.calculatorapp.Model.Calculator;

import dagger.Module;
import dagger.Provides;

@Module
public class CalcModule {

    @Provides
    Calculator provideCalculator(AppCalculator calculator) {
        return calculator;
    }

}