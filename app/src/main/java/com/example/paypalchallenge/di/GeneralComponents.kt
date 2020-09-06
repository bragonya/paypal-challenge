package com.example.paypalchallenge.di

import com.example.paypalchallenge.network.MobileXoomAPI
import com.example.paypalchallenge.repositories.CountryRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

/**
 * This component is used for general purposes
 * it is placed in the application component since
 * it can be injected on any other modules where
 * it is needed
 *
 * @author Brayan Yaquián
 *
 * */
@Module
@InstallIn(ApplicationComponent::class)
class GeneralComponents {

    @Provides
    fun repositoryProvider(pokeAPI: MobileXoomAPI) = CountryRepository(pokeAPI)
}