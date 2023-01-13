package com.paulo.starwars.domain.usecases.listItem


import android.util.Log
import com.paulo.starwars.data.Result
import com.paulo.starwars.domain.models.People
import com.paulo.starwars.domain.repository.IRemoteRepository
import retrofit2.HttpException


class GetListItemDetailUseCase(
    private val repository: IRemoteRepository
) {
    suspend operator fun invoke(page: Long): Triple<Result<People>?, HttpException?, Throwable?> = try {
        Triple(repository.getPeoples(page), null, null)
    } catch (e: HttpException) {
        Triple(null, e, null)
    } catch (t: Throwable) {
        Triple(null, null, t)
    }

}

