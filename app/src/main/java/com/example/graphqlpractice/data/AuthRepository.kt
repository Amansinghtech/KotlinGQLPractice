package com.example.graphqlpractice.data

interface AuthRepository {
    fun login(email: String, password: String): String
}