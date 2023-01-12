package com.paulo.starwars.data.dto.remote

import com.paulo.starwars.domain.models.Home

data class HomeDto(
    val url: String,
    val title: String
) {
    fun toDomain() = Home(
        url = this.url,
        title = this.title
    )
}
