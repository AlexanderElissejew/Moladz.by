package com.example.moladzby.data.api

import androidx.room.RawQuery
import retrofit2.http.Url
import javax.inject.Inject

class NewsRepository @Inject constructor(private val newsService: NewsService) {
    suspend fun getNews(countryCode: String, page: Int, category: String) =
        newsService.getHeadlines(countryCode = countryCode, page = page, category = category)

    suspend fun getSearchNews(query: String, pageNumber: Int) =
    newsService.getEverything(query = query, page = pageNumber)

}