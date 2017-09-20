package com.yoyowallet.kotlindojo.app

import android.app.Application
import com.yoyowallet.kotlindojo.io.SpotifyApi

class KotlinDojoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        val adapter = SpotifyApi.getAdapter()
    }
}