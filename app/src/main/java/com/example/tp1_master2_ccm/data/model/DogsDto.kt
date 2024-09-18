package com.example.tp1_master2_ccm.data.model


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DogsDto(
    @Expose
    @SerializedName("message")
    val imageUrl: String,


    @Expose
    @SerializedName("status")
    val statusRequest: String
)

fun DogsDto.toRoom() : DogsEntity{
    return DogsEntity(
        imageUrl = imageUrl,
        statusRequest = statusRequest
    )
}

