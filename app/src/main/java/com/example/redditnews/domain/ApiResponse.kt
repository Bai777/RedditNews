package com.example.redditnews.domain

import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("data")
    val data: ResponseData
)

data class ResponseData(
    @SerializedName("children")
    val children: List<Children> = listOf(),
    @SerializedName("after")
    val after: String,
    val before: String?
)

data class Children(
    @SerializedName("data")
    val data: Post?
)

data class Post(
    @SerializedName("title")
    val title: String?,
    @SerializedName("score")
    val score: Int?,
    @SerializedName("num_comments")
    val comments: String?,
)