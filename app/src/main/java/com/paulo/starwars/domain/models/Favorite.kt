package com.paulo.starwars.domain.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.paulo.starwars.utils.Constants

@Entity(tableName = Constants.FAVORITE_DB)
data class Favorite(

    @PrimaryKey(autoGenerate = false)
    var id: Int,

    @ColumnInfo(name = "url_photo")
    var urlPhoto: String,

    var name: String,
)