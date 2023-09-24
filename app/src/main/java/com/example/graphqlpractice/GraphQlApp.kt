package com.example.graphqlpractice

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GraphQlApp : Application() {
    override fun onCreate() {
        super.onCreate()
    }
}