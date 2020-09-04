package com.example.paypalchallenge.network

import com.example.paypalchallenge.model.Countries
import retrofit2.http.GET
import retrofit2.http.Query

interface MobileXoomAPI {

    @GET("/catalog/v2/countries")
    suspend fun getCountriesFromNetwork(
        @Query("page") page: Int,
        @Query("size") size: Int = NUM_OF_COUNTRIES
    ): Countries
}