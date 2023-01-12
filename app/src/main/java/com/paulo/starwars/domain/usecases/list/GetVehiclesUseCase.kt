package com.paulo.starwars.domain.usecases.list


import com.paulo.starwars.domain.models.Species
import com.paulo.starwars.domain.models.Vehicles
import com.paulo.starwars.domain.repository.IRemoteRepository


class GetVehiclesUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(): List<Vehicles> {
        return repository.getVehicles()
    }

}
