package com.example.paypalchallenge.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * This component is used for network purposes
 * it is placed in the application component since
 * it can be injected on any other modules where
 * it is needed
 *
 * @author Brayan Yaquián
 *
 * */
@Module
@InstallIn(ApplicationComponent::class)
class NetworkModule {
    @Provides
    fun provideMobileXoomAPI(client: OkHttpClient) = Retrofit.Builder()
        .baseUrl(BASE_URL_MOBILE_XOOM_API)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(client)
        .build()
        .create(MobileXoomAPI::class.java)

    @Provides
    fun provideLogger(): OkHttpClient{
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
        return httpClient.build()
    }

}