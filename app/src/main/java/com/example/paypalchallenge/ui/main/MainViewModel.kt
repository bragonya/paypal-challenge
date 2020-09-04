package com.example.paypalchallenge.ui.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.paypalchallenge.repositories.CountryRepository

class MainViewModel @ViewModelInject constructor(private val countryRepository: CountryRepository): ViewModel() {

    fun updateCountryList() = countryRepository.getCountriesFromNetwork()
}