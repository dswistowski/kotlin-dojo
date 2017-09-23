package data


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Item (

    @SerializedName("album_type")
    @Expose
    var albumType: String? = null,
    @SerializedName("artists")
    @Expose
    var artists: List<Artist>? = null,
    @SerializedName("available_markets")
    @Expose
    var availableMarkets: List<String>? = null,
    @SerializedName("external_urls")
    @Expose
    var externalUrls: ExternalUrls? = null,
    @SerializedName("href")
    @Expose
    var href: String? = null,
    @SerializedName("id")
    @Expose
    var id: String? = null,
    @SerializedName("images")
    @Expose
    var images: List<Image>? = null,
    @SerializedName("name")
    @Expose
    var name: String? = null,
    @SerializedName("type")
    @Expose
    var type: String? = null,
    @SerializedName("uri")
    @Expose
    var uri: String? = null

)