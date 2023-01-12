package com.paulo.starwars.di

import com.paulo.starwars.data.Api
import com.paulo.starwars.data.repository.RemoteRepositoryImpl
import com.paulo.starwars.domain.repository.IRemoteRepository
import com.paulo.starwars.domain.usecases.listItem.GetHomeUseCase
import com.paulo.starwars.domain.usecases.listItem.GetListUseCases
import com.paulo.starwars.utils.Constants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

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
    fun provideListUseCases(
        repository: IRemoteRepository
    ):GetListUseCases{
        return GetListUseCases(
            getHomeUSeCase = GetHomeUseCase( repository = repository)
        )
    }
    @Provides
    @Singleton
    fun provideRemoteRepository(api: Api): IRemoteRepository {
        return RemoteRepositoryImpl(api)
    }


}