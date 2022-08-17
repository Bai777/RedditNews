package com.example.redditnews.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.redditnews.data.RemoteRepositoryImpl
import com.example.redditnews.data.Repository
import com.example.redditnews.data.network.Retrofit
import com.example.redditnews.domain.RedditPost
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class MainViewModel(private val repo: Repository = RemoteRepositoryImpl(Retrofit().getService())) :
    ViewModel() {

    private val liveDataToObserve: MutableLiveData<List<RedditPost>> = MutableLiveData(listOf())

    fun getData(): LiveData<List<RedditPost>> {
        return liveDataToObserve
    }

    fun requestPosts() = requestPostsFromApi()

    private fun requestPostsFromApi() {
        repo.getPosts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                liveDataToObserve.postValue(it)
            }, {

            })
    }
}