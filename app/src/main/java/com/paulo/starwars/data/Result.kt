package com.paulo.starwars.data

data class Result<T>(
    val count: Int,
    val next: String,
    val previous: Int,
    val list: List<T>
)