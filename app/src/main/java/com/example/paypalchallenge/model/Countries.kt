package com.example.paypalchallenge.model

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Countries(
    val items: List<Country>
)