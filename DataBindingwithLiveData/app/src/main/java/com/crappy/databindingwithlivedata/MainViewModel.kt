package com.crappy.databindingwithlivedata

import androidx.databinding.Bindable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by crappy on 4/2/19.
 */
class MainViewModel:ViewModel() {
    val currentRandomFruitName :LiveData<String>
    get()=  FakeRepository.currentRandomFruitName

    fun onChangeRandomFruitClick()=FakeRepository.changeCurrentRandomFruitName()
    @Bindable
    val editTextContent=MutableLiveData<String>()

    private val _displayedEditTextContent=MutableLiveData<String>()
    val displayedEditTextContent: LiveData<String>
    get()=_displayedEditTextContent

    fun onDisplayEditTextContentClick(){
        _displayedEditTextContent.value=editTextContent.value
    }
    fun onSelectRandomEditTextFruit(){
        editTextContent.value=FakeRepository.getRandomFruitName()
    }
}