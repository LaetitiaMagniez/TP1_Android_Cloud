package com.example.tp1_master2_ccm.data.repository

import com.example.tp1_master2_ccm.architecture.CustomApplication
import com.example.tp1_master2_ccm.architecture.RetrofitBuilderDog
import com.example.tp1_master2_ccm.data.model.toRoom
import com.example.tp1_master2_ccm.ui.model.DogsObject
import com.example.tp1_master2_ccm.ui.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DogsImageRepository {

    private val dogsDao = CustomApplication.instance.mApplicationDatabase.dogsDao()

    suspend fun fetchData(){
        dogsDao.insert(RetrofitBuilderDog.getDogsImage().getRandomDog().toRoom())
    }

    fun deleteAll(){
        dogsDao.deleteAll()
    }

    fun selectAll(): Flow<List<DogsObject>> {
        return dogsDao.selectAll().map { list ->
            list.toUi()
        }
    }
}