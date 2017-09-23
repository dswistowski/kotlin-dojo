package data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ExternalUrls (
        @SerializedName("spotify")
                         @Expose
                         var spotify: String)