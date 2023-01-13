package com.paulo.starwars.domain.usecases.list


import android.util.Log
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.repository.IRemoteRepository
import retrofit2.HttpException


class GetPeopleUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(): List<People> {
        val response = repository.getPeoples()
        Log.d("TAG", response.toString())
        return response
    }

}
