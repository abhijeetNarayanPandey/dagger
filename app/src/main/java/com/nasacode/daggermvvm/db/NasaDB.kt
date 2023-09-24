package com.nasacode.daggermvvm.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nasacode.daggermvvm.models.Details

@Database(entities = [Details::class], version = 1)
abstract class NasaDB : RoomDatabase() {

    abstract fun getNasaDAO() : NasaDAO

}