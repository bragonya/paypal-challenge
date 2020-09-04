package com.example.paypalchallenge.di

import com.example.paypalchallenge.network.MobileXoomAPI
import com.example.paypalchallenge.repositories.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class GeneralComponents {

    @Provides
    fun repositoryProvider(pokeAPI: MobileXoomAPI) = CountryRepository(pokeAPI)
}