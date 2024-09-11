package com.example.tp1_master2_ccm.ui.model

import com.example.tp1_master2_ccm.data.model.ChuckNorrisEntity

data class ChuckNorrisObject(
    val quote: String,
    val iconUrl: String,
)


fun List<ChuckNorrisEntity>.toUi(): List<ChuckNorrisObject> {
    return map { eachEntity ->
        ChuckNorrisObject(
            quote = eachEntity.quote,
            iconUrl = eachEntity.iconUrl,
        )
    }
}
