package com.yoyowallet.kotlindojo.domain

data class Album (val href: String, val name: String)
data class Albums (val items: List<Album>)
data class GetNewReleasesReponse(val albums: Albums)