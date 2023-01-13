package com.paulo.starwars.di

import com.paulo.starwars.data.Api
import com.paulo.starwars.data.repository.RemoteRepositoryImpl
import com.paulo.starwars.domain.repository.IRemoteRepository
import com.paulo.starwars.domain.usecases.list.GetFilmsUseCase
import com.paulo.starwars.domain.usecases.list.GetHomeUseCase
import com.paulo.starwars.domain.usecases.list.GetListUseCases
import com.paulo.starwars.domain.usecases.list.GetPeopleUseCase
import com.paulo.starwars.domain.usecases.list.GetPlanetsUseCase
import com.paulo.starwars.domain.usecases.list.GetSpeciesUseCase
import com.paulo.starwars.domain.usecases.list.GetStarshipsUseCase
import com.paulo.starwars.domain.usecases.list.GetVehiclesUseCase
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
    ): GetListUseCases {
        return GetListUseCases(
            getHomeUSeCase = GetHomeUseCase(repository = repository),
            getFilmsUseCase = GetFilmsUseCase(repository = repository),
            getPeopleUseCase = GetPeopleUseCase(repository = repository),
            getPlanetsUseCase = GetPlanetsUseCase(repository = repository),
            getSpeciesUseCase = GetSpeciesUseCase(repository = repository),
            getStarshipsUseCase = GetStarshipsUseCase(repository = repository),
            getVehiclesUseCase = GetVehiclesUseCase(repository = repository),
        )
    }

    @Provides
    @Singleton
    fun providePeopleUseCases(
        repository: IRemoteRepository
    )= GetPeopleUseCase (repository = repository)

    @Provides
    @Singleton
    fun provideRemoteRepository(api: Api): IRemoteRepository {
        return RemoteRepositoryImpl(api)
    }


}