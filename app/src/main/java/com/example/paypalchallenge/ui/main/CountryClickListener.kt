package com.example.paypalchallenge.ui.main

import com.example.paypalchallenge.model.Country

/**
 * SAM Interface to support lambdas :)
 * this is very important because you can use lambdas in kotlin (You don't need to create an object
 * of type CountryClickListener interface)
 * and it has compatibility with Java because you can still passing the interface
 *
 * @author Brayan Yaquián
 *
 */
fun interface CountryClickListener{
    fun onClick(country: Country)
}