package com.example.tp1_master2_ccm.data.remote

import com.example.tp1_master2_ccm.data.model.ChuckNorrisDto
import retrofit2.http.GET

interface ChuckNorrisQuoteEndpoint {


    @GET("random")
    suspend fun getRandomQuote() : ChuckNorrisDto
}
