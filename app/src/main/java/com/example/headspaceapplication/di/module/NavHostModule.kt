package com.example.headspaceapplication.di.module

import com.example.headspaceapplication.view.InjectingNavHostFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class NavHostModule {

    @ContributesAndroidInjector(modules = [FragmentBindingModule::class, ViewModelModule::class])
    abstract fun navHostFragmentInjector(): InjectingNavHostFragment
}