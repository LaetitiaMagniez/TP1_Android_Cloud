package com.example.tp1_master2_ccm.data.remote

import com.example.tp1_master2_ccm.data.model.DogsDto
import retrofit2.http.GET

interface DogsImageEndpoint{

    @GET("random")
    suspend fun getRandomDog(): DogsDto
}