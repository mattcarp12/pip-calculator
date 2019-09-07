package org.matt.calculatorapp.DI;

import org.matt.calculatorapp.AppView.MainActivity;
import org.matt.calculatorapp.Model.Calculator;
import org.matt.calculatorapp.Presenter.AppPresenter;

import dagger.Component;

@Component (modules = {CalcModule.class})
public interface CalcComponent {
    //Calculator getCalculator();
    void inject(AppPresenter appPresenter);
}
