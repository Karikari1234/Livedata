package com.example.livedata.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.util.*

class Repository {
    object FakeRepository{
        private val fruitNames: List<String> = listOf(
            "Apple","Banana","Kiwi","Grape","Papaya","Lichi","Mango",
            "Jackfruit","Olive","Grape","Blackberry"
        )
        private val privateCurrentFruitName = MutableLiveData<String>()
        val currentFruitName : LiveData<String>
            get() = privateCurrentFruitName
        init{
            privateCurrentFruitName.value = fruitNames.first()
        }

        fun getRandomFruitName(): String {
            val random = Random()
            return fruitNames[random.nextInt(fruitNames.size)]
        }

        fun changeRandomFruitName() {
            privateCurrentFruitName.value = getRandomFruitName()
        }
    }
}