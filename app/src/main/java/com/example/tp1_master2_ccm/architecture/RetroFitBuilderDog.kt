package com.example.tp1_master2_ccm.architecture

import com.example.tp1_master2_ccm.data.remote.DogsImageEndpoint
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilderDog {


    private val retrofit: Retrofit = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breeds/image/")
        .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
        .build()


    fun getDogsImage(): DogsImageEndpoint = retrofit.create(DogsImageEndpoint::class.java)
}