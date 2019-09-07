package org.matt.calculatorapp.DI;

import org.matt.calculatorapp.AppView.MainActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = AppComponent.class, modules = MvpModule.class)
public interface ActivityComponent {
    void inject(MainActivity mainActivity);
}
