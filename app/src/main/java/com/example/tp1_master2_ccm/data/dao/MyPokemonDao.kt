package com.example.tp1_master2_ccm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp1_master2_ccm.data.model.MyPokemonEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MyPokemonDao {

    @Query("SELECT * FROM my_pokemon_table ORDER BY name ASC")
    fun selectAll(): Flow<List<MyPokemonEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(androidVersion: MyPokemonEntity)


    @Query("DELETE FROM my_pokemon_table")
    fun deleteAll()
}
