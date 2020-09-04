package com.example.paypalchallenge.ui.main

import com.example.paypalchallenge.model.Country

//SAM Interface to support lambdas :)
fun interface CountryClickListener{
    fun onClick(country: Country)
}