package com.example.tp1_master2_ccm.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.tp1_master2_ccm.data.model.DogsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface DogsDao {
    @Query("SELECT * FROM dogs_table ORDER BY imageUrl ASC")
    fun selectAll(): Flow<List<DogsEntity>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(dogsEntity: DogsEntity)


    @Query("DELETE FROM dogs_table")
    fun deleteAll()
}