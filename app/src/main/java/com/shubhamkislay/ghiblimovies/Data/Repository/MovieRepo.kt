package com.shubhamkislay.ghiblimovies.Data.Repository

import com.shubhamkislay.ghiblimovies.Data.Model.Movies
import com.shubhamkislay.ghiblimovies.Data.Remote.ApiService
import retrofit2.Response

class MovieRepo(
    val apiService: ApiService
) {
    suspend fun getMovies(): Response<Movies> = apiService.getMovies()
}