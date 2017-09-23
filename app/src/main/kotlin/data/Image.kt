package data


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class Image (@SerializedName("height")
                  @Expose
                  val height: Int,
    @SerializedName("url")
    @Expose
    val url: String,
    @SerializedName("width")
    @Expose
    val width: Int)