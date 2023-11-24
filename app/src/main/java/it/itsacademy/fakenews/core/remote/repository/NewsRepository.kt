package it.itsacademy.fakenews.core.remote.repository

import it.itsacademy.fakenews.core.remote.api.NewsAPI
import it.itsacademy.fakenews.core.remote.response.NewsResponse
import retrofit2.await

class NewsRepository (private val newsAPI: NewsAPI) {

    suspend fun getAllPost(): List<NewsResponse> {
        return newsAPI.getAllPost().await()
    }

}