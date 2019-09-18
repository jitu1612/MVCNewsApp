package com.news.mvcnewsapp.models

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class Articles {

    @SerializedName("title")
    @Expose
    private var title: String? = null

    @SerializedName("urlToImage")
    @Expose
    private var urlToImage: String? = null

    @SerializedName("author")
    @Expose
    private var author: String? = null

    @SerializedName("content")
    @Expose
    private var content: String? = null

    @SerializedName("url")
    @Expose
    private var url: String? = null

    @SerializedName("publishedAt")
    @Expose
    private var publishedAt: String? = null

    fun Articles(title: String, urlToImage: String, author: String, url: String, publishedAt: String) {
        this.title = title
        this.urlToImage = urlToImage
        this.author = author
        this.url = url
        this.publishedAt = publishedAt
    }

    fun getTitle(): String? {
        return title
    }
    fun setTitle(title: String) {
        this.title = title
    }
    fun getUrlToImage(): String? {
        return urlToImage
    }
    fun setUrlToImage(urlToImage: String) {
        this.urlToImage = urlToImage
    }
    fun getAuthor(): String? {
        return author
    }
    fun setAuthor(author: String) {
        this.author = author
    }
    fun getContent(): String? {
        return content
    }
    fun setContent(content: String) {
        this.content = content
    }
    fun getUrl(): String? {
        return url
    }
    fun setUrl(url: String) {
        this.url = url
    }
    fun getPublishedAt(): String? {
        return publishedAt
    }
    fun setPublishedAt(publishedAt: String) {
        this.publishedAt = publishedAt
    }


}
