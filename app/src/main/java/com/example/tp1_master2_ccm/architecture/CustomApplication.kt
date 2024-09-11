package com.example.tp1_master2_ccm.architecture

import android.app.Application
import androidx.room.Room

class CustomApplication : Application() {


    companion object {
        lateinit var instance: CustomApplication
    }


    val mApplicationDatabase: CustomRoomDatabase by lazy {
        Room.databaseBuilder(
            applicationContext,
            CustomRoomDatabase::class.java,
            "MyDatabase"
        ).fallbackToDestructiveMigration().build()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
