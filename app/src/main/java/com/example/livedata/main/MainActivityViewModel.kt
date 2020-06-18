package com.example.livedata.main

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.livedata.repository.Repository

class MainActivityViewModel: ViewModel() {
    val currentRandomFruitname:LiveData<String>
        get() = Repository.FakeRepository.currentFruitName

    fun onChangeRandomFruitClick() = Repository.FakeRepository.changeRandomFruitName()

    val editTextContent = MutableLiveData<String>()

    private val privateDisplayedEditTextContent =  MutableLiveData<String>()

    val displayedEditTextContent : LiveData<String>
        get() = privateDisplayedEditTextContent

    fun onDisplayEditTextContentClick(){
        privateDisplayedEditTextContent.value = editTextContent.value
    }

    fun onSelectRandomFruitName(){
        editTextContent.value = Repository.FakeRepository.getRandomFruitName()
    }
}