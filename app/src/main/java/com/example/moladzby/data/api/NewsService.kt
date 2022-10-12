package com.example.moladzby.data.api

import com.example.moladzby.model.NewsResponse
import com.example.moladzby.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("https://api.rss2json.com/v1/api.json")
    suspend fun getEverything2(
        @Query("rss_url") rssUrl: String = "https://rss.nytimes.com/services/xml/rss/nyt/Sports.xml",
        @Query("api_key") apiKey: String = API_KEY,
        @Query("count") count: Int
    ) : Response<NewsResponse>

    @GET("/v2/top-headlines")
    suspend fun getHeadlines(
        @Query("country") countryCode : String,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY,
        @Query("category") category: String

    ): Response<NewsResponse>

    @GET("/v2/everything")
    suspend fun getEverything(
        @Query("q") query: String,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY

    ): Response<NewsResponse>

}