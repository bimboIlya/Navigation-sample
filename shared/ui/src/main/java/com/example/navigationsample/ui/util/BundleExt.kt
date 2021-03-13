@file:Suppress("NOTHING_TO_INLINE")

package com.example.navigationsample.ui.util

import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

typealias Args = Bundle

inline fun argsOf(block: Args.() -> Unit): Args = Args().apply { block() }

inline fun Args.getIntOrNull(key: String): Int? = get(key) as? Int

inline fun Args.getIntOrThrow(key: String): Int =
    getIntOrNull(key) ?: throw IllegalArgumentException("No Integer argument with key $key")

inline fun Args.getLongOrNull(key: String): Long? = get(key) as? Long

inline fun Args.getLongOrThrow(key: String): Long =
    getLongOrNull(key) ?: throw IllegalArgumentException("No Long argument with key $key")

inline fun Args.getFloatOrNull(key: String): Float? = get(key) as? Float

inline fun Args.getFloatOrThrow(key: String): Float =
    getFloatOrNull(key) ?: throw IllegalArgumentException("No Float argument with key $key")

inline fun Args.getDoubleOrNull(key: String): Double? = get(key) as? Double

inline fun Args.getDoubleOrThrow(key: String): Double =
    getDoubleOrNull(key) ?: throw IllegalArgumentException("No Double argument with key $key")

inline fun Args.getBooleanOrNull(key: String): Boolean? = get(key) as? Boolean

inline fun Args.getBooleanOrThrow(key: String): Boolean =
    getBooleanOrNull(key) ?: throw IllegalArgumentException("No Boolean argument with key $key")

inline fun Args.getStringOrEmpty(key: String): String = getString(key, "")

inline fun Args.getStringOrThrow(key: String): String =
    getString(key) ?: throw IllegalArgumentException("No String argument with key $key")

inline fun <reified T : Serializable> Args.getSerializableOrNull(key: String): T? =
    getSerializable(key) as? T

inline fun <reified T : Serializable> Args.getSerializableOrThrow(key: String): T =
    getSerializableOrNull(key)
        ?: throw IllegalArgumentException("No ${T::class.java.simpleName} argument with key $key")

inline fun <reified T : Parcelable> Args.getParcelableOrNull(key: String): T? =
    getParcelable(key) as? T

inline fun <reified T : Parcelable> Args.getParcelableOrThrow(key: String): T =
    getParcelableOrNull(key)
        ?: throw IllegalArgumentException("No ${T::class.java.simpleName} argument with key $key")

