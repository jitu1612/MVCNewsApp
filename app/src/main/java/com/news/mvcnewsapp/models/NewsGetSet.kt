package com.news.mvcnewsapp.models

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Expose



class NewsGetSet {

    @SerializedName("articles")
    @Expose
    private var articles: List<Articles>? = null

    fun getArticles(): List<Articles>? {
        return articles
    }

    fun setArticles(userArray: List<Articles>) {
        this.articles = articles
    }



}
