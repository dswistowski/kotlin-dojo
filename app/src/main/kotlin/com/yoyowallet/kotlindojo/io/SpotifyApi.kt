package com.yoyowallet.kotlindojo.io


import com.yoyowallet.kotlindojo.io.webservice.SpotifyService
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit


/**
 * Created by enzobelli on 16/09/2017.
 */
private const val SPOTIFY_WEB_API_ENDPOINT = "https://api.spotify.com/v1"
private const val TOKEN = "1fa8ee50629446dca567675a36d689b0"

object SpotifyApi {

    private val client = OkHttpClient.Builder()
            .addInterceptor({ chain ->
                val newRequest = chain.request().newBuilder()
                        .header("Authorization", "Bearer " + TOKEN)
                        .build()

                chain.proceed(newRequest)
            })
            .connectTimeout(20, TimeUnit.SECONDS)
            .readTimeout(20, TimeUnit.SECONDS)
            .build()

    private var restAdapter = Retrofit.Builder()
            .baseUrl(SPOTIFY_WEB_API_ENDPOINT)
            .client(client)
            .build()


    fun getAdapter() : SpotifyService{
        return restAdapter.create(SpotifyService::class.java)
    }

}