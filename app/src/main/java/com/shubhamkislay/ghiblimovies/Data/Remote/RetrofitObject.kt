package com.shubhamkislay.ghiblimovies.Data.Remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitObject {
    val baseUrl = "https://ghibliapi.vercel.app/"

    private val retrofit  = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create())
        .build()


    fun getApiService() : ApiService = retrofit.create(ApiService::class.java)


}