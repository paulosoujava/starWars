package com.paulo.starwars.data.framework.remote



object Helper {
    fun readFileResource(filename: String): String {
        return Helper::class.java.getResource(filename)?.readText() ?: ""
    }
}