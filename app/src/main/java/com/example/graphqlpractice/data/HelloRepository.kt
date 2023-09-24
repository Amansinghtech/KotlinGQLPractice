package com.example.graphqlpractice.data

interface HelloRepository {
    suspend fun getHello(): String
}