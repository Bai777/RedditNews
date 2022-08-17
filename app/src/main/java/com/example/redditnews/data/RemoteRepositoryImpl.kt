package com.example.redditnews.data

import com.example.redditnews.data.network.ApiService
import com.example.redditnews.domain.RedditPost
import com.example.redditnews.domain.convertResponseToPosts
import io.reactivex.rxjava3.core.Single

class RemoteRepositoryImpl(private val repo: ApiService) : Repository {
    var after: String = ""

    override fun getPosts(): Single<List<RedditPost>> {
        return repo.getPosts(after).map {
            this.after = it.data.after
            convertResponseToPosts(it)
        }
    }
}