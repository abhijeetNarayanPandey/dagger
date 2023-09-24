package com.nasacode.daggermvvm.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nasacode.daggermvvm.models.Details

@Dao
interface NasaDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addProducts(products : Details)

    @Query("SELECT * FROM Details")
    suspend fun getProducts() : Details

}