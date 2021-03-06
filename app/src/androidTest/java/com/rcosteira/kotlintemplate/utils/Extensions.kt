package com.rcosteira.kotlintemplate.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

// TODO turn this into an extension when the testCoverageEnabled bug gets fixed
@Suppress("UNCHECKED_CAST")
fun <T : ViewModel> createViewModelFactoryFor(model: T): ViewModelProvider.Factory =
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(model.javaClass)) {
                    return model as T
                }
                throw IllegalArgumentException("unexpected model class " + modelClass)
            }
        }