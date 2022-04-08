package test.practice.android_aaa_kotlin_rxjava.model_layer

import com.jakewharton.rxrelay2.BehaviorRelay
import io.reactivex.Single
import test.practice.android_aaa_kotlin_rxjava.model_layer.entities.Message
import test.practice.android_aaa_kotlin_rxjava.model_layer.network_layer.NetworkLayer
import test.practice.android_aaa_kotlin_rxjava.model_layer.persistence_layer.PersistenceLayer
import test.practice.android_aaa_kotlin_rxjava.model_layer.persistence_layer.PhotoDescription

class ModelLayer {

    companion object {
        val shared = ModelLayer()
    }

    val photoDescriptions = BehaviorRelay.createDefault(listOf<PhotoDescription>())
    val messages = BehaviorRelay.createDefault(listOf<Message>())

    private val networkLayer = NetworkLayer.instance
    private val persistenceLayer = PersistenceLayer.shared         //database

    fun loadAllPhotoDescription() {
        //result may be immediate but better to use asynchronous calling

        persistenceLayer.loadAllPhotoDescriptions { photoDescription ->
            this.photoDescriptions.accept(photoDescription)
        }
    }

    fun getMessages() {
        return networkLayer.getMessages({ message ->
            this.messages.accept(message)
        }, {
            notifyError("errormsg")
        })
    }

    private fun notifyError(errormsg: String) {
        println("Error Occurred : $errormsg")
    }

    fun getMessagesRx(): Single<List<Message>> {
        return networkLayer.getMessagesRx()
    }
}