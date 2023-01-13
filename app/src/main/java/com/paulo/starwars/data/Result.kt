package com.paulo.starwars.data

data class Result<T>(
    val count: Long,
    val next: String,
    val previous: Int? = null,
    val results: List<T>
)
