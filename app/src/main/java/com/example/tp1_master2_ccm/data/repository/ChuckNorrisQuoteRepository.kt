package com.example.tp1_master2_ccm.data.repository

import com.example.tp1_master2_ccm.architecture.CustomApplication
import com.example.tp1_master2_ccm.architecture.RetrofitBuilder
import com.example.tp1_master2_ccm.data.model.toRoom
import com.example.tp1_master2_ccm.ui.model.ChuckNorrisObject
import com.example.tp1_master2_ccm.ui.model.toUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class ChuckNorrisQuoteRepository {


    private val chuckNorrisDao = CustomApplication.instance.mApplicationDatabase.chuckNorrisDao()


    suspend fun fetchData() {
        chuckNorrisDao.insert(RetrofitBuilder.getChuckNorrisQuote().getRandomQuote().toRoom())
    }


    fun deleteAll() {
        chuckNorrisDao.deleteAll()
    }


    fun selectAll(): Flow<List<ChuckNorrisObject>> {
        return chuckNorrisDao.selectAll().map { list ->
            list.toUi()
        }
    }
}
