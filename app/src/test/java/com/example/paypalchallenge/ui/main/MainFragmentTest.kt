package com.example.paypalchallenge.ui.main

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.paging.PagingData
import com.example.paypalchallenge.model.Countries
import com.example.paypalchallenge.model.Country
import com.example.paypalchallenge.network.MobileXoomAPI
import com.example.paypalchallenge.repositories.CountryRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.mock

class MainFragmentTest{
    @get:Rule
    val rule = InstantTaskExecutorRule()
    @Mock
    lateinit var api :MobileXoomAPI

    /*@Before
    fun setup(){
        api = mock(MobileXoomAPI::class.java)
        `when`(api.getCountriesFromNetwork(Matchers.anyInt(),Matchers.anyInt()))
        val countries = mock(Countries::class.java)
        `when`(countries.items).thenReturn(listOf(Country("Brazil", "BR"), Country("Guatemala", "GT")))
        `when`(repository.getCountriesFromNetwork()).thenReturn(countries)
    }
    @Test
    fun `test`(){
        val vm = MainViewModel(repository)
    }*/

}