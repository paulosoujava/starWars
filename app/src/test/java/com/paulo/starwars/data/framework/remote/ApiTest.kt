package com.paulo.starwars.data.framework.remote

import com.paulo.starwars.data.framework.network.Api
import kotlinx.coroutines.runBlocking
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.MockWebServer
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiTest {

    lateinit var mockServer:  MockWebServer
    lateinit var api: Api

    @Before
    fun setUp() {
        mockServer = MockWebServer()
        api = Retrofit
            .Builder()
            .baseUrl(mockServer.url("/"))
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(Api::class.java)
    }

    @After
    fun tearDown() {
        mockServer.shutdown()
    }

    @Test
    fun test_get_empty_response() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setBody("{}")
        mockServer.enqueue(mockResponse)

        val response = api.getPeople(1)
        Assert.assertTrue(response.results == null)
    }

    @Test
    fun test_get_a_profile_by_code_response() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setBody(Helper.readFileResource("/peopleByCode.json"))
        mockServer.enqueue(mockResponse)

        val response = api.getProfileById(1)
        Assert.assertTrue(response.name == "Luke Skywalker")
    }

    @Test
    fun test_get_a_profile_response() = runBlocking {
        val mockResponse = MockResponse()
        mockResponse.setBody(Helper.readFileResource("/people.json"))
        mockServer.enqueue(mockResponse)

        val response = api.getPeople(1)
        Assert.assertTrue(response.results.size == 10)
    }

}