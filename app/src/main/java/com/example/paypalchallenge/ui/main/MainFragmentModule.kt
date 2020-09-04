package com.bragonya.daggerdemo.ui.mainlist

import com.example.paypalchallenge.repositories.CountryRepository
import com.example.paypalchallenge.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

@Module
@InstallIn(ActivityRetainedComponent::class)
class MainFragmentModule {

    @Provides
    fun mainViewModelProvider(repository: CountryRepository) = MainViewModel(repository)
}