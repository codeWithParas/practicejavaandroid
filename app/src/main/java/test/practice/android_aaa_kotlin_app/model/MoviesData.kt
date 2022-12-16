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

data class WeatherData(
    @SerializedName("region")
    var region: String,
    //@SerializedName("currentConditions")
    //var currentConditions: String,
    //@SerializedName("next_days")
    //var next_days: String,
    @SerializedName("data_source")
    var data_source: String
)