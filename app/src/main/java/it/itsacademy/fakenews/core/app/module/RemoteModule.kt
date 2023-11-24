package it.itsacademy.fakenews.core.app.module

import it.itsacademy.fakenews.core.remote.api.NewsAPI
import it.itsacademy.fakenews.core.remote.repository.NewsRepository
import okhttp3.OkHttpClient
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val RETROFIT_BASE_SERVICE_URL = "https://jsonplaceholder.typicode.com/"
private const val RETROFIT_BASE_SERVICE = "retrofit_base_service"
private const val OKHTTP_CLIENT = "okhttp_client"

val remoteModule = module {
    single(named(OKHTTP_CLIENT)){
        OkHttpClient.Builder().build()
    }

    single(named(RETROFIT_BASE_SERVICE)){
        Retrofit.Builder()
            .client(get(named(OKHTTP_CLIENT)))
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(RETROFIT_BASE_SERVICE_URL)
            .build()
    }

    single { (get(named(RETROFIT_BASE_SERVICE)) as Retrofit).create(NewsAPI::class.java) }
    single { NewsRepository(get()) }

}