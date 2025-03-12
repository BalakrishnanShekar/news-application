package com.project.thenewsapp.repository

import com.project.thenewsapp.api.RetroFitInstance
import com.project.thenewsapp.db.ArticleDatabase
import com.project.thenewsapp.models.Article

class NewsRepository(val db:ArticleDatabase) {


    suspend fun getHeadlines(countryCode: String, pageNumber: Int) =
        RetroFitInstance.api.getHeadlines(countryCode,pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetroFitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDAO().upsert(article)

    fun getFavouriteNews() = db.getArticleDAO().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDAO().deleteArticle(article)


}
