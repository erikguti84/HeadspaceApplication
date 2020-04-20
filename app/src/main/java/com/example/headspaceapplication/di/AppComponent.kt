package com.example.headspaceapplication.di

import com.example.headspaceapplication.MyApp
import com.example.headspaceapplication.di.module.AppModule
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class
    ]
)
interface AppComponent : AndroidInjector<MyApp> {

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<MyApp>
}