package com.example.redditnews.domain

fun convertResponseToPosts(response: ApiResponse): List<RedditPost> {
    return response.data.children.map {
        RedditPost(
            it.data?.title ?: "Title", it.data?.score ?: 0,
            (it.data?.comments?.toInt() ?: "0") as Int
        )
    }
}