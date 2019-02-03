package com.crappy.databindingwithlivedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

/**
 * Created by crappy on 4/2/19.
 */
object FakeRepository {
    private val fruitNames = listOf(
            "Apple","Banana","Orange","Kiwi","Grapes","Fig","Pear","Strawberry","Gooseberry","Raspberry"
    )
    private val _currentRandomFruitName= MutableLiveData<String>()
    val currentRandomFruitName:LiveData<String>
    get()= _currentRandomFruitName

    init{
        _currentRandomFruitName.value= fruitNames.first()
    }
    fun getRandomFruitName()= fruitNames[Random().nextInt(fruitNames.size)]
    fun changeCurrentRandomFruitName(){
        _currentRandomFruitName.value= getRandomFruitName()
    }
}