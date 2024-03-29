package com.ericho.srm.common.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.Observer

/** @author Aidan Follestad (@afollestad) */
class DistinctLiveData<T>(source1: LiveData<T>) : MediatorLiveData<T>() {

    private var isInitialized = false
    private var lastValue: T? = null

    init {
        super.addSource(source1) {
            if (!isInitialized) {
                value = it
                isInitialized = true
                lastValue = it
            } else if (lastValue != it) {
                value = it
                lastValue = it
            }
        }
    }

    override fun <S : Any?> addSource(
        source: LiveData<S>,
        onChanged: Observer<in S>
    ) {
        throw UnsupportedOperationException()
    }

    override fun <T : Any?> removeSource(toRemote: LiveData<T>) {
        throw UnsupportedOperationException()
    }
}

/**
 * Wraps the receiving LiveData instance with a [DistinctLiveData], filtering out duplicates.
 */
fun <T> LiveData<T>.distinct(): MediatorLiveData<T> = DistinctLiveData(this)
