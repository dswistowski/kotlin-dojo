package com.yoyowallet.kotlindojo.ui

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import com.spotify.sdk.android.authentication.AuthenticationClient
import com.spotify.sdk.android.authentication.AuthenticationRequest
import com.spotify.sdk.android.authentication.AuthenticationResponse
import com.yoyowallet.kotlindojo.R
import com.yoyowallet.kotlindojo.io.SpotifyApi
import com.yoyowallet.kotlindojo.io.webservice.SpotifyService

// import data.Albums
import retrofit2.Call

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val builder = AuthenticationRequest.Builder(CLIENT_ID, AuthenticationResponse.Type.TOKEN, REDIRECT_URI)

        builder.setScopes(arrayOf("streaming"))
        val request = builder.build()

        AuthenticationClient.openLoginActivity(this, REQUEST_CODE, request)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, intent: Intent) {
        super.onActivityResult(requestCode, resultCode, intent)

        // Check if result comes from the correct activity
        if (requestCode == REQUEST_CODE) {
            val response = AuthenticationClient.getResponse(resultCode, intent)

            when (response.type) {
            // Response was successful and contains auth token
                AuthenticationResponse.Type.TOKEN -> {
                    SpotifyApi.token = response.accessToken
                startActivity(Intent(this, NewReleasesActivity::class.java))
            }
            // Auth flow returned an error
                AuthenticationResponse.Type.ERROR -> {
                    Log.d("Spotify",response.error)
                }
            }// Handle error response
            // Most likely auth flow was cancelled
            // Handle other cases
        }
    }

    companion object {


        // Request code will be used to verify if result comes from the login activity. Can be set to any integer.
        private val REQUEST_CODE = 1337
        private val REDIRECT_URI = "yoyowallet://kotlindojo"
        private val CLIENT_ID = "cf057dec516f4fe8a19d90f3c5abe332"
    }
}
