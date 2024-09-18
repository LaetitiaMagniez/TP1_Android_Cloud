package com.example.tp1_master2_ccm.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tp1_master2_ccm.data.repository.DogsImageRepository
import com.example.tp1_master2_ccm.ui.model.DogsObject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class DogsViewModel : ViewModel() {

    private val dogsImageRepository: DogsImageRepository by lazy { DogsImageRepository()}

    private val _images: Flow<List<DogsObject>>
        get()= dogsImageRepository.selectAll()

    val image = _images

    fun insertNewImage(){
        viewModelScope.launch(Dispatchers.IO) {
            dogsImageRepository.fetchData()
        }
    }
    fun deleteAllImages() {
        viewModelScope.launch(Dispatchers.IO) {
            dogsImageRepository.deleteAll()
        }
    }

}