package it.itsacademy.fakenews.core.remote.api

import it.itsacademy.fakenews.core.remote.response.NewsResponse
import retrofit2.Call
import retrofit2.http.GET

interface NewsAPI {

    @GET("/posts")
    fun getAllPost() : Call<List<NewsResponse>>
}