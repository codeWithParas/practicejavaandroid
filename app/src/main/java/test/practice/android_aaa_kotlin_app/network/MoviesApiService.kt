package test.practice.android_aaa_kotlin_app.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import test.practice.android_aaa_kotlin_app.model.MoviesData
import test.practice.android_aaa_kotlin_app.model.WeatherData

//https://api.androidhive.info/json/movies.json

private const val BASE_URL = "https://weatherdbi.herokuapp.com/data/weather/"

//private const val BASE_URL = "https://api.androidhive.info/json/"
private const val BASE_IMG_URL = "https://api.androidhive.info/json/movies/"
//http://api.openweathermap.org/2.5/weather?q=Noida&appid=5ecffcaea0ceebc2f7783825dee9084a

//use retrofit builder with scalarConverterFactory and base_url
private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

private val retrofitImg = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl(BASE_IMG_URL)
    .build()

interface MoviesApiService {
    @GET("movies.json")
    fun getMoviesData(): Call<List<MoviesData>>
}

interface WeatherService {
    //@GET("movies.json")
    @GET("london")
    fun getWeatherData(): Call<WeatherData>
}

interface ImageAPIService {
    @GET("1.jpg")
    fun getImage():
            Call<ResponseBody>
}

object MoviesApi {
    val moviesService: MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)
    }
}

object WeatherServiceApi {
    val weatherService: WeatherService by lazy {
        retrofit.create(WeatherService::class.java)
    }
}

object ImageApi {
    val imageService: ImageAPIService by lazy {
        retrofitImg.create(ImageAPIService::class.java)
    }
}