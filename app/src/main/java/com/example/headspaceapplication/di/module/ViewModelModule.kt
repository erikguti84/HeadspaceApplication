package com.example.headspaceapplication.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.headspaceapplication.di.ViewModelKey
import com.example.headspaceapplication.di.factory.ViewModelFactory
import com.example.headspaceapplication.viewmodel.MyViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    // Add viewmodels below
    @Binds
    @IntoMap
    @ViewModelKey(MyViewModel::class)
    internal abstract fun postMyViewModel(viewModel: MyViewModel): ViewModel

}