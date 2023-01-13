package com.paulo.starwars.domain.usecases.list


import com.paulo.starwars.core.handlerNetwork
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.repository.IRemoteRepository
import retrofit2.HttpException


class GetPeopleUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(): Triple<List<People>?, HttpException?, Throwable?> = try {
        Triple(repository.getPeoples(), null, null)
    } catch (e: HttpException) {
        Triple(null, e, null)

    } catch (t: Throwable) {
        Triple(null, null, t)
    }

}

