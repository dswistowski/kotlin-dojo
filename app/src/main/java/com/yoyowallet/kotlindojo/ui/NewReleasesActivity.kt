package com.yoyowallet.kotlindojo.ui

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View
import com.yoyowallet.kotlindojo.R
import com.yoyowallet.kotlindojo.io.SpotifyApi
import data.Albums
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NewReleasesActivity : AppCompatActivity(), Callback<Albums> {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_releases)
        val toolbar = findViewById(R.id.toolbar) as Toolbar
        setSupportActionBar(toolbar)

        val fab = findViewById(R.id.fab) as FloatingActionButton
        fab.setOnClickListener({
            val newReleases = SpotifyApi.service.getNewReleases()
            newReleases.enqueue(this)
        })
    }

    override fun onFailure(call: Call<Albums>?, t: Throwable?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onResponse(call: Call<Albums>?, response: Response<Albums>) {
        if (response.isSuccessful) {

        } else {
            Log.e("Error", "" + response.code())
            Log.e("Error",response.errorBody().toString())
        }
    }

}
