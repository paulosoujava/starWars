package com.paulo.starwars.data.framework.bd

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.paulo.starwars.domain.models.Favorite
import com.paulo.starwars.utils.Constants


@Dao
interface FavoriteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun addFavorite(favorite: Favorite)

    @Query("DELETE FROM ${Constants.FAVORITE_DB} WHERE id = :code")
    fun deleteFavorite(code: String)

    @Query("SELECT * FROM ${Constants.FAVORITE_DB} ORDER BY id ASC")
    fun getFavorite(): List<Favorite>

    @Query("SELECT * FROM ${Constants.FAVORITE_DB}  WHERE id = :code")
    fun getFavoriteByCode(code: String): Favorite
}