package test.practice.android_coroutines.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import test.practice.android_coroutines.data.models.Movie
import test.practice.android_coroutines.data.models.Quote
import test.practice.android_coroutines.data.network.MyApi

class QuoteViewModel : ViewModel() {

    private val TAG = "QuoteViewModel"

    val quotes: LiveData<List<Quote>?> = MutableLiveData()

    init {
        viewModelScope.launch {
            quotes as MutableLiveData
            for (i in 1..5) {
                val quotes1 = async { getQuotes() }
                val quotes2 = async { getQuotes() }
                val quotes3 = async { getQuotes() }

                val movies1 = async { getMovies() }
                val movies2 = async { getMovies() }
                val movies3 = async { getMovies() }
            }
        }
    }

    private suspend fun getQuotes(): List<Quote>? {
        return withContext(Dispatchers.IO) {
            android.util.Log.i(TAG, "Getting Quotes")
            MyApi().getQuotes().body()?.quotes
        }
    }

    private suspend fun getMovies(): List<Movie>? {
        return withContext(Dispatchers.IO) {
            android.util.Log.e(TAG, "Getting Movies")
            MyApi().getMovies().body()
        }
    }
}