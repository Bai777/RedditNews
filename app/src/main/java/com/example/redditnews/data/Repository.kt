package com.example.redditnews.data

import com.example.redditnews.domain.RedditPost
import io.reactivex.rxjava3.core.Single

interface Repository {
    fun getPosts():Single<List<RedditPost>>
}