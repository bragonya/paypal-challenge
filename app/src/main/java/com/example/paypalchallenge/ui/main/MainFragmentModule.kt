package com.bragonya.daggerdemo.ui.mainlist

import com.example.paypalchallenge.repositories.CountryRepository
import com.example.paypalchallenge.ui.main.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent

/**
 * This module needs to be installed on ActivityRetainedComponent since it has a ViewModel
 * and it needs to survive in rotations
 *
 * @author Brayan Yaquián
 *
 * */
@Module
@InstallIn(ActivityRetainedComponent::class)
class MainFragmentModule {

    @Provides
    fun mainViewModelProvider(repository: CountryRepository) = MainViewModel(repository)
}