package com.example.tp1_master2_ccm.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dogs_table")
data class DogsEntity(
    @ColumnInfo(name = "imageUrl")
    val imageUrl: String,


    @ColumnInfo(name = "status")
    val statusRequest: String
){
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
}
