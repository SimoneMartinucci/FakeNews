package it.itsacademy.fakenews.core.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import it.itsacademy.fakenews.core.remote.repository.NewsRepository
import it.itsacademy.fakenews.core.viewmodel.mapper.mapToUI
import it.itsacademy.fakenews.core.viewmodel.model.PostItemUI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel(private val newsRepository: NewsRepository) : ViewModel() {

    private val _postLiveData = MutableLiveData<List<PostItemUI>>()
    val postLiveData = _postLiveData

    fun loadPost(){
        viewModelScope.launch(Dispatchers.IO) {
            val postList = newsRepository.getAllPost().map { it.mapToUI() }
            _postLiveData.postValue(postList)
        }
    }
}