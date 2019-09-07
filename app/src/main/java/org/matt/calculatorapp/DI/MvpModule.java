package org.matt.calculatorapp.DI;

import org.matt.calculatorapp.AppView.AppView;
import org.matt.calculatorapp.Presenter.AppPresenter;
import org.matt.calculatorapp.Presenter.Presenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MvpModule {

    private AppView appView;

    public MvpModule(AppView appView) {
        this.appView = appView;
    }

    @Provides
    AppView providesAppView() {
        return appView;
    }

    @Provides
    Presenter providesPresenter(AppPresenter presenter) {
        return presenter;
    }
}
