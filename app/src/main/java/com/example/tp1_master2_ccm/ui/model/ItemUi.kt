package com.example.tp1_master2_ccm.ui.model

sealed interface ItemUi {

    data class MyPokemonObject(
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
