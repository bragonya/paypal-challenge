package com.example.paypalchallenge.model

import com.example.paypalchallenge.network.BASE_IMAGE_URL
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CountryTest{

    //GIVEN
    @Mock
    private lateinit var country: Country

    @Before
    fun setup(){
        //WHEN
        country = Country("Brazil", "BR")
    }

    @Test
    fun `verify image format`() {
        //THEN
        Assert.assertEquals(country.image, BASE_IMAGE_URL.replace("{country_code}", country.code.toLowerCase()))
    }
}