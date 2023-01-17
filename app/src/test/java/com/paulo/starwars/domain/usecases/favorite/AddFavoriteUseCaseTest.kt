package com.paulo.starwars.domain.usecases.favorite

import com.paulo.starwars.data.framework.local.FakeRemoteRepositoryImplTest
import com.paulo.starwars.domain.models.Favorite
import kotlinx.coroutines.runBlocking
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class AddFavoriteUseCaseTest {
    private lateinit var addFavoriteUseCase: AddFavoriteUseCase
    private lateinit var fakeRepository: FakeRemoteRepositoryImplTest

    companion object {
        const val SIZE = 20
    }


    @Before
    fun setUp() {
        fakeRepository = FakeRemoteRepositoryImplTest()
        addFavoriteUseCase = AddFavoriteUseCase(fakeRepository)

        val favorites = mutableListOf<Favorite>()
        (1..20).forEachIndexed { index, num ->
            favorites.add(Favorite(id = index, name = "name $num", urlPhoto = "photo/$num"))
        }
        favorites.shuffle()
        runBlocking {
            favorites.forEach { fakeRepository.addFavorite(it) }
        }
    }

    @Test
    fun `get all 20 favorites`() = runBlocking {
        val favorite = fakeRepository.getFavorite()
        assertTrue(favorite.size == SIZE)
    }

    @Test
    fun `remove an favorite item`() = runBlocking {
        fakeRepository.deleteFavorite("1")
        val favorite = fakeRepository.getFavorite()
        assertTrue(favorite.size == SIZE - 1)
    }

    @Test
    fun `get a favorite item by code`() = runBlocking {
        val favorite = fakeRepository.getFavoriteByCode("1")
        assertTrue(favorite.urlPhoto.isNotEmpty())
    }

}