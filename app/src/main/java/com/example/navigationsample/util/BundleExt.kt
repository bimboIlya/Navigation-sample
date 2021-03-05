package com.example.navigationsample.util

import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

typealias Args = Bundle

fun argsOf(block: Args.() -> Unit): Args {
    return Args().apply { block() }
}

fun Args.getIntOrNull(key: String): Int? {
    return get(key) as? Int
}

fun Args.getIntOrThrow(key: String): Int {
    return getIntOrNull(key) ?: throw IllegalArgumentException("No integer argument with key $key")
}

inline fun <reified T : Serializable> Args.getSerializableOrNull(key: String): T? {
    return getSerializable(key) as? T
}

inline fun <reified T : Serializable> Args.getSerializableOrThrow(key: String): T {
    return getSerializableOrNull(key)
        ?: throw IllegalArgumentException("No ${T::class.java.simpleName} argument with key $key")
}

inline fun <reified T : Parcelable> Args.getParcelableOrNull(key: String): T? {
    return getParcelable(key) as? T
}

inline fun <reified T : Parcelable> Args.getParcelableOrThrow(key: String): T {
    return getParcelableOrNull(key)
        ?: throw IllegalArgumentException("No ${T::class.java.simpleName} argument with key $key")
}
