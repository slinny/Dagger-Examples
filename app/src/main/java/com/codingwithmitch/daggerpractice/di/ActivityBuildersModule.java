package com.codingwithmitch.daggerpractice.di;


import com.codingwithmitch.daggerpractice.di.auth.AuthActivitySubcomponent;
import com.codingwithmitch.daggerpractice.di.auth.AuthModule;
import com.codingwithmitch.daggerpractice.di.auth.AuthScope;
import com.codingwithmitch.daggerpractice.di.auth.AuthViewModelsModule;
import com.codingwithmitch.daggerpractice.di.main.MainViewModelsModule;
import com.codingwithmitch.daggerpractice.ui.auth.AuthActivity;
import com.codingwithmitch.daggerpractice.ui.main.MainActivity;
import com.codingwithmitch.daggerpractice.di.main.MainFragmentBuildersModule;
import com.codingwithmitch.daggerpractice.di.main.MainModule;
import com.codingwithmitch.daggerpractice.di.main.MainScope;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.android.ContributesAndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;


@Module
public abstract class ActivityBuildersModule {

//    @AuthScope
//    @ContributesAndroidInjector(
//            modules = {AuthModule.class, AuthViewModelsModule.class})
//    abstract AuthActivity contributeAuthActivity();

    @Binds
    @IntoMap
    @ClassKey(AuthActivity.class)
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(AuthActivitySubcomponent.Factory builder);
    

    /*
      NOTE:
      Activities MUST install modules here. They can't be installed in the Component class.
      (Fragments are different)
     */
    @MainScope
    @ContributesAndroidInjector(
            modules = {MainModule.class, MainViewModelsModule.class, MainFragmentBuildersModule.class})
    abstract MainActivity contributeMainActivity();
}













