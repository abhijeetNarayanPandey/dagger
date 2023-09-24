package com.nasacode.daggermvvm.di

import android.content.Context
import androidx.room.Room
import com.nasacode.daggermvvm.db.NasaDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {
    @Singleton
    @Provides
    fun provideFakerDB(@ApplicationContext context : Context) : NasaDB {
        return Room.databaseBuilder(context, NasaDB::class.java, "NasaDB").build()
    }
}
