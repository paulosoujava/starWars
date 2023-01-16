package com.paulo.starwars.data.framework.bd

import androidx.room.Database
import androidx.room.RoomDatabase
import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.domain.models.People


@Database(entities = [Favorite::class], version = 1, exportSchema = false)
    abstract class FavoriteDB : RoomDatabase() {
        abstract fun bookDao(): FavoriteDao
    }