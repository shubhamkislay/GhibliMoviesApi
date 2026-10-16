package com.shubhamkislay.ghiblimovies.Data.Remote

import com.shubhamkislay.ghiblimovies.Data.Model.Movies
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

//https://ghibliapi.vercel.app/films
    @GET("films")
    suspend fun getMovies(): Response<Movies>
}