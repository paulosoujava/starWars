package com.paulo.starwars.domain.usecases.profile

import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.repository.IRemoteRepository
import retrofit2.HttpException


class GetProfileUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(id: Long): Triple<People?, HttpException?, Throwable?> = try {
        Triple(repository.getProfileById(id), null, null)
    } catch (e: HttpException) {
        Triple(null, e, null)
    } catch (t: Throwable) {
        Triple(null, null, t)
    }

}

