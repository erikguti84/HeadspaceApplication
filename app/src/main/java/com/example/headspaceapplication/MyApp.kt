package com.example.headspaceapplication

import com.example.headspaceapplication.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class MyApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out MyApp> =
        DaggerAppComponent.factory().create(this)
}