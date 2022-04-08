package test.practice.android_coroutines.data.network

import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import test.practice.android_coroutines.data.models.Movie
import test.practice.android_coroutines.data.models.QuotesResponse

interface MyApi {

    @GET("mvvm/quotes")
    suspend fun getQuotes(): Response<QuotesResponse>

    @GET("recyclerview/movies")
    suspend fun getMovies(): Response<List<Movie>>

//    @GET("quotes")
//    fun getMovies(): Call<QuotesResponse>

    companion object {
        operator fun invoke(): MyApi {
            return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl("http://api.simplifiedcoding.in/course-apis/")
                .build()
                .create(MyApi::class.java)
        }
    }
}
