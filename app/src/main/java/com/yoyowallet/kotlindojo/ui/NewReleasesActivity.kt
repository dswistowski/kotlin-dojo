package com.yoyowallet.kotlindojo.ui

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import com.yoyowallet.kotlindojo.R
import com.yoyowallet.kotlindojo.domain.GetNewReleasesReponse
import com.yoyowallet.kotlindojo.io.SpotifyApi
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.async
import kotlinx.coroutines.experimental.launch
import kotlinx.coroutines.experimental.runBlocking
import org.jetbrains.anko.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.sdk25.coroutines.onClick
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
object ResponseCallback {

}

class NewReleasesActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        scrollView {
            verticalLayout {
                padding = dip(30)
                button("Load data") {
                    textSize = 26f
                    onClick {
                        runBlocking {
                            val response = async(CommonPool) {
                                callTheApi()
                            }.await()
                            response?.body()?.albums?.items?.map {
                                textView(it.name)
                            }
                        }
                    }
                }

            }
        }
    }
    suspend fun callTheApi(): Response<GetNewReleasesReponse>? {
        return SpotifyApi.service.getNewReleases().execute()
    }

}
