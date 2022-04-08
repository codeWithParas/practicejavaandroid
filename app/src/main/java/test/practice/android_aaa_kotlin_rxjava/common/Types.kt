package test.practice.android_aaa_kotlin_rxjava.common

typealias VoidLambda = () -> Unit
typealias StringLambda = (String) -> Unit

class NullBox<T>(val value: T?)

class EmptyDescriptionException(override var message: String) : Exception(message)