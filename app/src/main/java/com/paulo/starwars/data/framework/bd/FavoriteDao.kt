package com.paulo.starwars.data.framework.bd

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.utils.Constants
import kotlinx.coroutines.flow.Flow

@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFavorite(favorite: Favorite)

    @Delete
    fun deleteFavorite(favorite: Favorite)

    @Query("SELECT * FROM ${Constants.FAVORITE_DB} ORDER BY id ASC")
    fun getFavorite(): Flow<Favorite>
}