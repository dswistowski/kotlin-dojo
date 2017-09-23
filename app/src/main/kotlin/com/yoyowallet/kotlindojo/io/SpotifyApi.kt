package com.yoyowallet.kotlindojo.io


import com.yoyowallet.kotlindojo.io.webservice.SpotifyService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


/**
 * Created by enzobelli on 16/09/2017.
 */
private const val SPOTIFY_WEB_API_ENDPOINT = "https://api.spotify.com/v1/"

object SpotifyApi {

    lateinit var token: String
    val service by lazy { restAdapter.create(SpotifyService::class.java) }
    private val client by lazy {
        OkHttpClient.Builder()
                .addInterceptor({ chain ->
                    val newRequest = chain.request().newBuilder()
                            .header("Authorization", "Bearer $token")
                            .build()

                    chain.proceed(newRequest)
                })
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(20, TimeUnit.SECONDS)
                .build()
    }

    private val restAdapter by lazy {
        Retrofit.Builder()
            .baseUrl(SPOTIFY_WEB_API_ENDPOINT)
            .client(client)
            .build()
    }
}