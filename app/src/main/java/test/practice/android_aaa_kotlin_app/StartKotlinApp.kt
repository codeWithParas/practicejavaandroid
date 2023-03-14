package test.practice.android_aaa_kotlin_app

import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import test.practice.R
import test.practice.android_aaa_kotlin_app.adapter.RecyclerViewAdapter
import test.practice.android_aaa_kotlin_app.model.MoviesData
import test.practice.android_aaa_kotlin_app.model.MyName
import test.practice.android_aaa_kotlin_app.model.WeatherData
import test.practice.android_aaa_kotlin_app.network.ImageApi
import test.practice.android_aaa_kotlin_app.network.WeatherServiceApi
import test.practice.databinding.ActivityKotlinBinding


/*
* Refer : https://developer.android.com/reference
* Refer : https://developer.android.com/guide
* Refer : https://codelabs.developers.google.com/android-kotlin-fundamentals/
*
*
* */

public class StartKotlinApp : AppCompatActivity()
{
    /*
    * Through binding initialization of UI has already been done at compilation time only.
    * So directly use the UI objects.
    *
    * Use Movies Data : https://api.androidhive.info/json/movies.json
    * */
    //private lateinit var binding: ActivityKotlinBinding
    //private lateinit var myName : MyName


    private lateinit var recyclerViewAdapter: RecyclerViewAdapter
    private lateinit var gridLayoutManager: GridLayoutManager
    private lateinit var myName: MyName
    private lateinit var binding: ActivityKotlinBinding
    lateinit var allMovieList : List<MoviesData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_kotlin)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_kotlin)

        binding.button.setOnClickListener(View.OnClickListener
        {
            Toast.makeText(this,"Hello", Toast.LENGTH_LONG).show()

            //it the api server
            //get the response in json....pass it thrugh GSON
            //myName = MyName("Paras")
            //binding.myName = myName

            updateData()
        })
    }

    private fun initUI() {


        recyclerViewAdapter = RecyclerViewAdapter(this, allMovieList /*IRecylerHolderClicks*/)
        //binding.recyclerView.adapter = recyclerViewAdapter
        //recyclerview.setAdapter(adapter)
        gridLayoutManager = GridLayoutManager(this, 1, LinearLayoutManager.VERTICAL, false)
        binding.recyclerView.setLayoutManager(gridLayoutManager)
        binding.recyclerView.adapter = recyclerViewAdapter
    }

    private fun updateData() {

        /*MoviesApi.moviesService.getMoviesData().enqueue(object : retrofit2.Callback<WeatherData> {
            override fun onFailure(call: Call<List<MoviesData>>, t: Throwable) {

                System.out.println(">> Response onFailure Output ")
            }

            override fun onResponse(call: Call<List<MoviesData>>, response: Response<List<MoviesData>>) {

                System.out.println(">> Response Output : " +response)

                allMovieList = response.body()!!
                //val moviesList = MoviesList(allMovieList)
                //val title = moviesList.list.get(0)
                binding.myMovies = allMovieList.get(0)
                initUI()
                //recyclerViewAdapter.notifyDataSetChanged()

                *//*Handler().post(Runnable {
                    updateImg()
                })*//*

            }
        })*/

        WeatherServiceApi.weatherService.getWeatherData()
            .enqueue(object : retrofit2.Callback<WeatherData> {
                override fun onFailure(call: Call<WeatherData>, t: Throwable) {

                    System.out.println(">> Response onFailure Output ")
                }

                override fun onResponse(call: Call<WeatherData>, response: Response<WeatherData>) {

                    System.out.println(">> Response Output : " + response)

                    //allMovieList = response.body()!!
                    //val moviesList = MoviesList(allMovieList)
                    //val title = moviesList.list.get(0)
                    //binding.myMovies = allMovieList.get(0)
                    //initUI()
                    //recyclerViewAdapter.notifyDataSetChanged()

                    /*Handler().post(Runnable {
                        updateImg()
                    })*/

                }
            })
    }

    private fun updateImg() {

        ImageApi.imageService.getImage().enqueue(object  : Callback<ResponseBody> {
            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {

                Log.d("onResponse error", "image Response came from server error img")
            }

            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                val bmp = BitmapFactory.decodeStream(response.body()!!.byteStream())
                //binding..setImageBitmap(bmp)
                Handler().post(Runnable {
                    binding.imgMovie.setImageBitmap(bmp)
                })
            }

        })

    }

}