package com.example.paypalchallenge.model

import com.example.paypalchallenge.network.BASE_IMAGE_URL
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Country(
    val name: String,
    val code: String
){
    val image = BASE_IMAGE_URL.replace("{country_code}", code.toLowerCase())
}