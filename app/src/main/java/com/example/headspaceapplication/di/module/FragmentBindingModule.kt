package com.example.headspaceapplication.di.module

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.headspaceapplication.di.FragmentKey
import com.example.headspaceapplication.di.factory.InjectingFragmentFactory
import com.example.headspaceapplication.view.ListFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentBindingModule {

    @Binds
    @IntoMap
    @FragmentKey(ListFragment::class)
    abstract fun bindListFragment(mainFragment: ListFragment): Fragment

    @Binds
    abstract fun bindFragmentFactory(factory: InjectingFragmentFactory): FragmentFactory
}