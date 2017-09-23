package com.yoyowallet.kotlindojo.io


import com.yoyowallet.kotlindojo.io.webservice.SpotifyService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

private const val SPOTIFY_WEB_API_ENDPOINT = "https://api.spotify.com/"


object SpotifyApi {

    lateinit var token: String
    val service by lazy { restAdapter.create(SpotifyService::class.java) }
    private val client by lazy {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY
        OkHttpClient.Builder()
                .addInterceptor({ chain ->
                    val newRequest = chain.request().newBuilder()
                            .header("Authorization", "Bearer $token")
                            .build()
                    chain.proceed(newRequest)
                })
                .addInterceptor(logging)
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()
    }

    private val restAdapter by lazy {
        Retrofit.Builder()
            .baseUrl(SPOTIFY_WEB_API_ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
            .build()
    }
}