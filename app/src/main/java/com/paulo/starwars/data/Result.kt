package com.paulo.starwars.data

data class Result<T>(
    val count: String,
    val next: String? = null,
    val previous: String? = null,
    val results: List<T>
)
