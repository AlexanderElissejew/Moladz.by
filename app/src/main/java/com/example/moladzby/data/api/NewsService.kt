package com.example.moladzby.data.api

import android.app.DownloadManager
import com.example.moladzby.model.NewsResponse
import com.example.moladzby.utils.Constants.Companion.API_KEY
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("https://api.rss2json.com/v1/api.json")
    suspend fun getEverything(
        @Query("rss_url") rssUrl: String = "https%3A%2F%2Fxn--d1acdremb9i.xn--90ais%2Fnews%2Frss%2F",
        @Query("apiKey") apiKey: String = API_KEY

    ) : Response<NewsResponse>
}