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
object AppModule {


    //********************************************************
    // USE CASES
    //********************************************************


    @Provides
    @Singleton
    fun provideListUseCases() = GetHomeUseCase()

    @Provides
    @Singleton
    fun provideFavoriteUseCases(
        local: ILocalRepository
    ) = com.paulo.starwars.domain.usecases.favorite.UseCases(
        getFavoriteUseCase = GetFavoriteUseCase(local),
        deleteFavoriteUseCase = DeleteFavoriteUseCase(local),
        addFavoriteUseCase = AddFavoriteUseCase(local)
    )

    @Provides
    @Singleton
    fun provideProfileUseCases(
        repository: IRemoteRepository,
        local: ILocalRepository,
    ) = com.paulo.starwars.domain.usecases.profile.UseCases(
        addFavoriteUseCase = AddFavoriteUseCase(local),
        deleteFavoriteUseCase = DeleteFavoriteUseCase(local),
        getFavoriteByCodeUseCase = GetFavoriteByCodeUseCase(local),
        getProfileUseCase = GetProfileUseCase(repository),
    )


    @Provides
    @Singleton
    fun provideListItemUseCases(
        repository: IRemoteRepository
    ) = GetListItemDetailUseCase(repository = repository)


    //********************************************************
    // RETROFIT
    //********************************************************

    @Provides
    @Singleton
    fun provideApi(): Api {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(Api::class.java)
    }

    @Provides
    @Singleton
    fun provideRemoteRepository(api: Api): IRemoteRepository {
        return RemoteRepositoryImpl(api)
    }


    //********************************************************
    // ROOM
    //********************************************************

    @Provides
    fun provideFavoriteDb(
        @ApplicationContext
        context: Context
    ) = Room.databaseBuilder(
        context,
        FavoriteDB::class.java,
        Constants.PEOPLE
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