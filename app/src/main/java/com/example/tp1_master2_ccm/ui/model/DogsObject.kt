package com.example.tp1_master2_ccm.ui.model

import com.example.tp1_master2_ccm.data.model.DogsEntity

data class DogsObject(
    val imageUrl: String,
    val statusRequest: String
)

fun List<DogsEntity>.toUi(): List<DogsObject> {
    return map { eachEntity ->
        DogsObject (
            imageUrl = eachEntity.imageUrl,
            statusRequest = eachEntity.statusRequest,
        )
    }
}