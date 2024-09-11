package com.example.tp1_master2_ccm.architecture

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tp1_master2_ccm.data.dao.MyPokemonDao
import com.example.tp1_master2_ccm.data.model.MyPokemonEntity

@Database(
    entities = [
    MyPokemonEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class CustomRoomDatabase : RoomDatabase() {

    abstract fun myPokemonDao(): MyPokemonDao
}
