package com.example.tp1_master2_ccm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tp1_master2_ccm.ui.model.ItemUi

@Entity(tableName = "my_pokemon_table")
data class MyPokemonEntity(

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "type")
    val type : String,

    @ColumnInfo(name = "gen")
    val gen: String,
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}

fun ItemUi.Item.toRoomObject(): MyPokemonEntity {
    return MyPokemonEntity(
        name = pokemonName,
        type = typeName,
        gen = generation,
    )
}


fun List<MyPokemonEntity>.toUi(): List<ItemUi.Item> {
    return map { eachItem ->
        ItemUi.Item(
            generation = eachItem.gen,
            typeName = eachItem.type,
            pokemonName = eachItem.name,
        )
    }
}

