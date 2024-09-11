package com.example.tp1_master2_ccm.ui.model

import com.example.tp1_master2_ccm.data.model.MyPokemonEntity

sealed interface ItemUi {

    data class Item(
        val pokemonName: String,
        val typeName : String,
        val generation: String,
    ) : ItemUi


    data class Header(
        val title: String,
    ) : ItemUi

    data class Footer(
        val total : Int
    ) : ItemUi

}

fun List<MyPokemonEntity>.toUi(): List<ItemUi.Item> {
    return map { currentAndroidObject ->
        ItemUi.Item(
            pokemonName = currentAndroidObject.name,
            typeName = currentAndroidObject.type,
            generation = currentAndroidObject.gen
        )
    }
}
