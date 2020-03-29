package test.practice.android_aaa_kotlin_app.model


import com.google.gson.annotations.SerializedName

data class MoviesData(
    @SerializedName("genre")
    var genre: List<String>,
    @SerializedName("image")
    var image: String,
    @SerializedName("rating")
    var rating: Double,
    @SerializedName("releaseYear")
    var releaseYear: Int,
    @SerializedName("title")
    var title: String
)