package com.androiddevs.mvvmnewsapp.repository

import com.androiddevs.mvvmnewsapp.api.RetrofitInstance
import com.androiddevs.mvvmnewsapp.db.ArticleDatabase
import com.androiddevs.mvvmnewsapp.model.Article

class NewsRepository(
    val db : ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode:String, pageNo : Int) =
        RetrofitInstance.api.getBreakingNews(countryCode,pageNo)

    suspend fun searchNews(searchQuery:String, pageNo : Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNo)

    suspend fun upsert(article:Article) = db.getArticleDao().upsert(article)

    fun getSavedNews()  = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article:Article) = db.getArticleDao().deleteArticle(article)
}