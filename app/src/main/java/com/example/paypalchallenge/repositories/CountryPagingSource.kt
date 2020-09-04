package com.example.paypalchallenge.repositories

import androidx.paging.PagingSource
import com.example.paypalchallenge.model.Country
import com.example.paypalchallenge.network.NUM_OF_COUNTRIES
import com.example.paypalchallenge.network.MobileXoomAPI
import com.squareup.moshi.JsonDataException
import retrofit2.HttpException
import java.io.IOException

class CountryPagingSource(
    private val service: MobileXoomAPI
): PagingSource<Int, Country>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Country> {
        val position = params.key ?: 1
        return try {
            val response = service.getCountriesFromNetwork(position, NUM_OF_COUNTRIES)
            LoadResult.Page(
                data = response.items,
                prevKey = if (position == 1) null else position - 1,
                nextKey = if (response.items.isEmpty()) null else position + 1
            )
        }catch (exception: IOException){
            return LoadResult.Error(exception)
        } catch (exception: HttpException){
            return LoadResult.Error(exception)
        }catch (exception: JsonDataException){
            return LoadResult.Error(exception)
        }
    }
}