package com.paulo.starwars.domain.usecases.list


import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.repository.IRemoteRepository


class GetPeopleUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(): List<People> {
        return repository.getPeoples()
    }

}
