package com.example.tp1_master2_ccm.data.repository

import com.example.tp1_master2_ccm.architecture.CustomApplication
import com.example.tp1_master2_ccm.data.model.MyPokemonEntity
import com.example.tp1_master2_ccm.data.model.toRoomObject
import com.example.tp1_master2_ccm.data.model.toUi
import com.example.tp1_master2_ccm.ui.model.ItemUi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MyPokemonRepository {
    private val myPokemonDao = CustomApplication.instance.mApplicationDatabase.myPokemonDao()

//    fun populateMyList(): List<MyPokemonEntity> {
//        return listOf(
//            MyPokemonEntity(name = "Salameche", type = "Feu", gen = "1"),
//            MyPokemonEntity(name = "Kyogre", type = "Eau", gen = "3"),
//            MyPokemonEntity(name = "Tortipouss", type = "Plante", gen = "4"),
//            MyPokemonEntity(name = "Poussifeu", type = "Feu", gen = "3"),
//            MyPokemonEntity(name = "Gobou", type = "Eau", gen = "3"),
//            MyPokemonEntity(name = "Arcko", type = "Plante", gen = "3"),
//            MyPokemonEntity(name = "Dracolosse", type = "Dragon", gen = "1"),
//            MyPokemonEntity(name = "Rayquaza", type = "Dragon", gen = "3"),
//            MyPokemonEntity(name = "Leviator", type = "Eau", gen = "1"),
//            MyPokemonEntity(name = "Milobellus", type = "Eau", gen = "3"),
//            MyPokemonEntity(name = "Tiplouf", type = "Eau", gen = "4"),
//            MyPokemonEntity(name = "Drattak", type = "Dragon", gen = "3"),
//            MyPokemonEntity(name = "Roserade", type = "Plante", gen = "4"),
//
//            )
//    }

    fun selectAllMyPokemon(): Flow<List<ItemUi.Item>> {
        return myPokemonDao.selectAll().map {
            it.toUi()
        }
    }


    fun insertAndroidVersion(androidObject: ItemUi.Item) {
        myPokemonDao.insert(androidObject.toRoomObject())
    }


    fun deleteAllAndroidVersion() {
        myPokemonDao.deleteAll()
    }



}