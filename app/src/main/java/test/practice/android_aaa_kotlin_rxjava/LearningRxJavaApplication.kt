package test.practice.android_aaa_kotlin_rxjava

import android.app.Application
import androidx.room.Room
import com.google.gson.Gson
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import test.practice.android_aaa_kotlin_rxjava.common.fromJson
import test.practice.android_aaa_kotlin_rxjava.model_layer.persistence_layer.LocalDatabase
import test.practice.android_aaa_kotlin_rxjava.model_layer.persistence_layer.PersistenceLayer
import test.practice.android_aaa_kotlin_rxjava.model_layer.persistence_layer.PhotoDescription
import test.practice.android_aaa_kotlin_rxjava.rx_observable_example.SimpleRx


class LearningRxJavaApplication : Application() {

    companion object {
        lateinit var database: LocalDatabase
    }

    override fun onCreate() {
        super.onCreate()

        println("Simple App being used.")

        //setupDatabase()

        SimpleRx.relayExample()
        SimpleRx.subjectExample()
        SimpleRx.observableExample()
        SimpleRx.otherExamplesOfObservable()
    }

    //region Database Setup Methods

    fun setupDatabase() {
        LearningRxJavaApplication.database =
            Room.databaseBuilder(this, LocalDatabase::class.java, "LearningRxJavaLocalDatabase")
                .build()

        GlobalScope.launch {
            val photoDescriptions = loadJson()
            PersistenceLayer.shared.prepareDb(photoDescriptions)
        }
    }

    private fun loadJson(): List<PhotoDescription> {
        val json = loadDescriptionsFromFile()
        val photoDescriptions = Gson().fromJson<List<PhotoDescription>>(json)
        return photoDescriptions
    }

    private fun loadDescriptionsFromFile(): String {
        //ignoring IOExceptions
        val inputStream = assets.open("PhotoDescription.json")
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        val json = String(buffer, Charsets.UTF_8)
        return json
    }

    //endregion
}

