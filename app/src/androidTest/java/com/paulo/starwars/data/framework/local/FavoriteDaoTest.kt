package com.paulo.starwars.data.framework.local

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.paulo.starwars.data.framework.bd.FavoriteDB
import com.paulo.starwars.data.framework.bd.FavoriteDao
import com.paulo.starwars.domain.models.Favorite
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class FavoriteDaoTest {

    private lateinit var favoriteDatabase : FavoriteDB
    private lateinit var favoriteDao: FavoriteDao
    private val itemFavorite = Favorite(1, "testePhoto", "testName")


    @Before
    fun setUp(){
        favoriteDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FavoriteDB::class.java
        ).allowMainThreadQueries().build()

        favoriteDao = favoriteDatabase.bookDao()
    }

    @After
    fun tearDown(){
        favoriteDatabase.bookDao()
    }


    @Test
    fun insert_a_single_item_favorite_in_db() = runBlocking{

        favoriteDao.addFavorite(itemFavorite)
        val result = favoriteDao.getFavoriteByCode("1")
        assert(itemFavorite == result)
    }
    @Test
    fun delete_a_single_item_favorite_in_db() = runBlocking{
        favoriteDao.addFavorite(itemFavorite)
        favoriteDao.deleteFavorite("1")
        val result = favoriteDao.getFavoriteByCode("1")
        assert(result == null)
    }

    @Test
    fun get_a_item_by_code() = runBlocking {
        favoriteDao.addFavorite(itemFavorite)
        val result = favoriteDao.getFavoriteByCode("1")
        assert( result.id == itemFavorite.id)
    }

    @Test
    fun get_all_favorite_items() = runBlocking {
        val list = listOf(
            itemFavorite,
            Favorite(2,"url", "name"),
            Favorite(3,"url", "name"),
            Favorite(4,"url", "name"),
        )
        list.forEach {
            favoriteDao.addFavorite(it)
        }
        val result = favoriteDao.getFavorite()
        assert(list.size == result.size)
    }
}