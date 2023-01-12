package com.paulo.starwars.di

import com.paulo.starwars.data.usecases.listItem.GetAllPeopleUseCase
import com.paulo.starwars.data.usecases.listItem.GetListUseCases
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideListUseCases() = GetListUseCases(
        getAllPeopleUseCase = GetAllPeopleUseCase()
    )

}