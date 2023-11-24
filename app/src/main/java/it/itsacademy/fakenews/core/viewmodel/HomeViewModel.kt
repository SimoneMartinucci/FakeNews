package it.itsacademy.fakenews.core.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.itsacademy.fakenews.core.remote.repository.NewsRepository
import it.itsacademy.fakenews.core.viewmodel.mapper.mapToUI
import it.itsacademy.fakenews.core.viewmodel.model.PostItemUI
import it.itsacademy.fakenews.core.viewmodel.model.RowPostItemUI
import it.itsacademy.fakenews.ui.home.adapter.PostItemType
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _postLiveData = MutableLiveData<List<RowPostItemUI>>()
    val postLiveData get() =  _postLiveData

    fun loadPost(){
        viewModelScope.launch(Dispatchers.IO) {
            val postList = newsRepository.getAllPost().map { it.mapToUI() }
            val landscapePost = postList.filter { it.type == PostItemType.LANDSCAPE  }
            val portraitPost = postList.filter { it.type == PostItemType.PORTRAIT }

            val rowList = mutableListOf<RowPostItemUI>()
            rowList.add(RowPostItemUI("Breaking News",landscapePost))
            rowList.add(RowPostItemUI("Latest News",portraitPost))
            _postLiveData.postValue(rowList)
        }
    }
}