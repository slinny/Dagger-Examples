package com.codingwithmitch.daggerpractice.di.auth;


import com.codingwithmitch.daggerpractice.models.User;
import com.codingwithmitch.daggerpractice.network.auth.AuthApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public abstract class AuthModule {

    @AuthScope
    @Provides
    static AuthApi provideSessionApi(Retrofit retrofit){
        return retrofit.create(AuthApi.class);
    }

}



















