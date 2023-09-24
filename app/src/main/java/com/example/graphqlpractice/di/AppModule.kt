package com.example.graphqlpractice.di

import com.apollographql.apollo3.ApolloClient
import com.example.graphqlpractice.data.AuthRepository
import com.example.graphqlpractice.data.AuthRepositoryImpl
import com.example.graphqlpractice.data.HelloRepository
import com.example.graphqlpractice.data.HelloRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun getAuthRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }

    @Singleton
    @Provides
    fun getHelloRepository(apiService: ApolloClient): HelloRepository {
        return HelloRepositoryImpl(apiService)
    }

    @Singleton
    @Provides
    fun getApolloClient() : ApolloClient {
        return ApolloClient.Builder()
            .serverUrl("http://172.16.1.21:4001/graphql")
            .build()
    }
}