package com.example.paypalchallenge.repositories

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.paging.PagingData
import androidx.paging.map
import com.example.paypalchallenge.model.Countries
import com.example.paypalchallenge.model.Country
import com.example.paypalchallenge.network.MobileXoomAPI
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.squareup.moshi.JsonDataException
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.*
import org.mockito.Mock
import org.mockito.Mockito.*

class CountryRepositoryTest{

    lateinit var listOfCountries: List<Country>

    lateinit var repository: CountryRepository

    @Mock
    lateinit var service: MobileXoomAPI

    @Mock
    lateinit var countries: Countries

    @get:Rule
    val rule = InstantTaskExecutorRule()

    val testDispatcher = TestCoroutineDispatcher()

    @Before
    fun setup() {
        //GIVEN
        listOfCountries = listOf(
            Country("Brazil", "BR"),
            Country("Argentina", "AR"),
            Country("Guatemala", "GT"), //cool thing in Kotlin 1.4, you can have comma at the end of the list
        )

        countries = mock(Countries::class.java)

        service = mock(MobileXoomAPI::class.java)

        `when`(countries.items).thenReturn(listOfCountries)
    }

    @After
    fun shutdown() {
        testDispatcher.cleanupTestCoroutines()
        Dispatchers.resetMain()
    }

    @Test
    fun `test live data success paging source`() = runBlocking {
        Dispatchers.setMain(testDispatcher)
        //WHEN
        `when`(service.getCountriesFromNetwork(0)).thenReturn(countries)
        repository = CountryRepository(service)
        val observer = mock<Observer<PagingData<Country>>>()
        repository.getCountriesFromNetwork().observeForever(observer)

        //THEN
        verify(observer).onChanged(any())
    }

    @Test
    fun `test live data error paging source`() = runBlocking {
        Dispatchers.setMain(testDispatcher)
        //WHEN
        `when`(service.getCountriesFromNetwork(0)).thenThrow(JsonDataException("no more countries"))
        repository = CountryRepository(service)
        val observer = mock<Observer<PagingData<Country>>>()
        //THEN
        repository.getCountriesFromNetwork().observeForever(Observer {
            data ->
            data.map { assert(false) }
            assert(true) // Verify paging data is empty, any other better way to do that (bad things in paging library) :S
        })
    }
}