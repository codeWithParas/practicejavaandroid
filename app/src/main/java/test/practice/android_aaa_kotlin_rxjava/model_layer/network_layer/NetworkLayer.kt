package test.practice.android_aaa_kotlin_rxjava.model_layer.network_layer

import io.reactivex.Observable
import io.reactivex.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.adapter.rxjava2.Result
import test.practice.android_aaa_kotlin_rxjava.common.NullBox
import test.practice.android_aaa_kotlin_rxjava.common.StringLambda
import test.practice.android_aaa_kotlin_rxjava.common.VoidLambda
import test.practice.android_aaa_kotlin_rxjava.model_layer.entities.Message
import test.practice.android_aaa_kotlin_rxjava.model_layer.entities.Person
import test.practice.android_aaa_kotlin_rxjava.model_layer.network_layer.endpoint_interfaces.JsonPlaceHolder
import test.practice.android_aaa_kotlin_rxjava.model_layer.network_layer.helpers.ServiceGenerator
import java.io.IOException


typealias MessageLambda = (Message?) -> Unit
typealias MessagesLambda = (List<Message>?) -> Unit

class NetworkLayer {
    companion object {
        val instance = NetworkLayer()
    }

    private val placeHolderApi: JsonPlaceHolder

    init {
        placeHolderApi = ServiceGenerator.createService(JsonPlaceHolder::class.java)
    }

    //FIRST LEVEL
    //region End Point - SemiRx Way

    fun getMessages(success: MessagesLambda, failure: StringLambda) {
        val call = placeHolderApi.getMessages()

        call.enqueue(object : Callback<List<Message>> {
            override fun onResponse(
                call: Call<List<Message>>?,
                response: Response<List<Message>>?
            ) {
                val article = parseRespone(response)
                success(article)
            }

            override fun onFailure(call: Call<List<Message>>?, t: Throwable?) {
                println("Failed to GET Message: ${t?.message}")
                failure(t?.localizedMessage ?: "Unknown error occured")
            }
        })
    }

    fun getMessage(articleId: String, success: MessageLambda, failure: VoidLambda) {
        val call = placeHolderApi.getMessage(articleId)

        call.enqueue(object : Callback<Message> {
            override fun onResponse(call: Call<Message>?, response: Response<Message>?) {
                val article = parseRespone(response)
                success(article)
            }

            override fun onFailure(call: Call<Message>?, t: Throwable?) {
                println("Failed to GET Message: ${t?.message}")
                failure()
            }
        })
    }

    fun postMessage(message: Message, success: MessageLambda, failure: VoidLambda) {
        val call = placeHolderApi.postMessage(message)

        call.enqueue(object : Callback<Message> {
            override fun onResponse(call: Call<Message>?, response: Response<Message>?) {
                val article = parseRespone(response)
                success(article)
            }

            override fun onFailure(call: Call<Message>?, t: Throwable?) {
                println("Failed to POST Message: ${t?.message}")
                failure()
            }
        })
    }

    private fun <T> parseRespone(response: Response<T>?): T? {
        val article = response?.body() ?: null

        if (article == null) {
            parseResponeError(response)
        }

        return article
    }

    private fun <T> parseResponeError(response: Response<T>?) {
        if (response == null) return

        val responseBody = response.errorBody()

        if (responseBody != null) {
            try {
                val text = "responseBody = ${responseBody.string()}"
                println("$text")
            } catch (e: IOException) {
                e.printStackTrace()
            }
        } else {
            val text = "responseBody == null"
            println("$text")
        }
    }

    //endregion

    //SECOND LEVEL : MORE OPTIMIZED FORM THEN FIRST LEVEL USING SINGLE
    //region End Point - Fully Rx

    fun getMessageRx(articleId: String): Single<Message> {
        return placeHolderApi.getMessageRx(articleId)
    }

    fun getMessagesRx(): Single<List<Message>> {
        return placeHolderApi.getMessagesRx()
    }

    fun postm(message: Message): Single<Message> {
        return placeHolderApi.postMessageRx(message)

    }

    //endregion

    //THIRD LEVEL : GROUPING network CALLS
    //region Task Example

    //3)Make one observable for each person in a list

    //2)Wrap task in reactive observable

    //2) This pattern is used often for units of work
    private fun buildgetInfoNetworkCallFor(person: Person): Observable<NullBox<String>> {
        return Observable.create { observer ->
            //Execute request - do actual work here
            getInfoFor(person) { result, exception ->
                //result.
            }
        }
    }

    //1)Create a network task
    fun getInfoFor(person: Person, finished: (Result<NullBox<String>>, Exception) -> Unit) {

        //Execute on Background thread
        //Do your task here
        GlobalScope.launch(Dispatchers.Default) {
            println("Start network call $person")
            val randomTime = person.age * 1000   // to milliseconds
            delay(randomTime.toLong())
            println("finished nwrk call: $person")

            //just randomly make odd people null
            var result = NullBox(person.toString())

        }
    }

    //endregion

}