package com.example.graphqlpractice

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainPage(viewModel: MainViewModel = hiltViewModel()) {
    Column {
        viewModel.streamData.collectAsState().value.let {
            Text(text = it)
        }
        Text(text = "Hello World!")
    }
}