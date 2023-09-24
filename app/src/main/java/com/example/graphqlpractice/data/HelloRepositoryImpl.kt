package com.example.graphqlpractice.data

import android.util.Log
import com.apollographql.apollo3.ApolloClient
import com.example.newklio_api.HelloServerQuery

class HelloRepositoryImpl(private val apiService: ApolloClient) : HelloRepository {

    override suspend fun getHello(): String {
        val response = apiService.query(HelloServerQuery()).execute()

        response.data?.hello?.onError?.let {
                Log.d("HelloRepositoryImpl", "Error: ${it.message}")
        }

        val data = response.data?.hello?.onSuccess?.payload
        return  data ?: throw Exception("No data")
    }
}