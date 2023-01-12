package com.paulo.starwars.domain.usecases.listItem

import com.paulo.starwars.domain.models.Home
import com.paulo.starwars.domain.repository.IRemoteRepository

class GetHomeUseCase(
    private val repository: IRemoteRepository
) {


    suspend operator fun invoke(): List<Home> {
        return repository.getHome()
    }
}
