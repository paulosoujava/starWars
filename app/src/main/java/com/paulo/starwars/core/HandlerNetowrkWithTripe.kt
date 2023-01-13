package com.paulo.starwars.core


import retrofit2.HttpException

fun<T> handlerNetwork(result: List<T>) = try {
    Triple(result, null, null)
} catch (e: HttpException) {
    Triple(null, e, null)

} catch (t: Throwable) {
    Triple(null, null, t)
}

fun<T> triple(list: List<T>) = try {
    Triple(list, null, null)
} catch (e: HttpException) {
    Triple(null, e, null)

} catch (t: Throwable) {
    Triple(null, null, t)
}