package com.example.paypalchallenge.repositories

import androidx.lifecycle.LiveData
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.example.paypalchallenge.model.Country
import com.example.paypalchallenge.network.COUNTRIES_MAX_SIZE
import com.example.paypalchallenge.network.NUM_OF_COUNTRIES
import com.example.paypalchallenge.network.MobileXoomAPI
import javax.inject.Inject

class CountryRepository @Inject constructor(private val service: MobileXoomAPI){

    fun getCountriesFromNetwork(): LiveData<PagingData<Country>>{
        return Pager(
            config = PagingConfig(
                pageSize = NUM_OF_COUNTRIES,
                enablePlaceholders = true
            ),
            pagingSourceFactory =  { CountryPagingSource(service)}
        ).liveData
    }
}