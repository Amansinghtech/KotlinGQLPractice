package com.example.graphqlpractice

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.graphqlpractice.data.HelloRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel
@Inject
constructor(helloRepository: HelloRepository) : ViewModel() {

    val streamData = MutableStateFlow("No Data")

    init {
        viewModelScope.launch {
            val data = helloRepository.getHello()
            streamData.value = data
            Log.d("MAIN_VIEW", "data: $data")
        }
    }

}