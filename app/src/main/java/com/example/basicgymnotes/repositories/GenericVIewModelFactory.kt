package com.example.basicgymnotes.repositories

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GenericViewModelFactory<T : ViewModel>(
    private val modelClass: Class<T>,
    private val creator: () -> T
) : ViewModelProvider.Factory {

    override fun <VM : ViewModel> create(
        modelClass: Class<VM>
    ): VM {

        require(modelClass.isAssignableFrom(this.modelClass))

        @Suppress("UNCHECKED_CAST")
        return creator() as VM
    }
}