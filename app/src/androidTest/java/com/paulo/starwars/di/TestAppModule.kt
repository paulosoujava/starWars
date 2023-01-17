package com.paulo.starwars.di

import android.content.Context
import androidx.room.Room
import com.paulo.starwars.data.framework.bd.FavoriteDB
import com.paulo.starwars.data.framework.network.Api
import com.paulo.starwars.data.framework.bd.FavoriteDao
import com.paulo.starwars.data.framework.bd.LocalRepositoryImpl
import com.paulo.starwars.data.framework.network.RemoteRepositoryImpl
import com.paulo.starwars.domain.repository.ILocalRepository
import com.paulo.starwars.domain.repository.IRemoteRepository
import com.paulo.starwars.domain.usecases.list.GetHomeUseCase
import com.paulo.starwars.domain.usecases.listItem.GetListItemDetailUseCase
import com.paulo.starwars.domain.usecases.favorite.AddFavoriteUseCase
import com.paulo.starwars.domain.usecases.favorite.DeleteFavoriteUseCase
import com.paulo.starwars.domain.usecases.favorite.GetFavoriteByCodeUseCase
import com.paulo.starwars.domain.usecases.profile.GetProfileUseCase
import com.paulo.starwars.domain.usecases.favorite.GetFavoriteUseCase
import com.paulo.starwars.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object TestAppModule {


    //********************************************************
    // USE CASES
    //********************************************************


    @Provides
    @Singleton
    fun provideFavoriteUseCases(
        local: ILocalRepository
    ) = com.paulo.starwars.domain.usecases.favorite.UseCases(
        getFavoriteUseCase = GetFavoriteUseCase(local),
        deleteFavoriteUseCase = DeleteFavoriteUseCase(local),
        addFavoriteUseCase = AddFavoriteUseCase(local)
    )

    //********************************************************
    // ROOM:: inMemoryDatabaseBuilder
    //********************************************************

    @Provides
    fun provideFavoriteDb(
        @ApplicationContext
        context: Context
    ) = Room.inMemoryDatabaseBuilder(
        context,
        FavoriteDB::class.java
    ).build()

    @Provides
    fun provideBookDao(
        db: FavoriteDB
    ) = db.bookDao()

    @Provides
    fun provideBookRepository(
        dao: FavoriteDao
    ): ILocalRepository = LocalRepositoryImpl(
        dao = dao
    )

}