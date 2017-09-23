package data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Artist (

    @SerializedName("external_urls")
    @Expose
    var externalUrls: ExternalUrls? = null,
    @SerializedName("href")
    @Expose
    var href: String? = null,
    @SerializedName("id")
    @Expose
    var id: String? = null,
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
