package org.matt.calculatorapp.DI;

import org.matt.calculatorapp.Model.AppCalculator;
import org.matt.calculatorapp.Model.Calculator;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class CalculatorModule {
    @Binds
    abstract Calculator bindsCalculator(AppCalculator calculator);
}
