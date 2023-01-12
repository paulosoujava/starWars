package com.paulo.starwars.core

sealed interface Events{
    object Loading: Events
    object Regular: Events
    data class Error(val message: String): Events
}