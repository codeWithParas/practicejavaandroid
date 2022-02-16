package test.practice.android_aaa_kotlin_rxjava.common

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

val Int.isEven: Boolean
    get() = this % 2 == 0

fun Disposable.disposedBy(bag: CompositeDisposable) {
    bag.add(this)
}

inline fun <reified T> Gson.fromJson(json: String) =
    this.fromJson<T>(json, object : TypeToken<T>() {}.type)
