package com.example.cryptolistcompose.viewmodel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cryptolistcompose.model.CryptoListItem
import com.example.cryptolistcompose.repository.CryptoRepository
import com.example.cryptolistcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CryptoListViewModel @Inject constructor(
    private val repository: CryptoRepository
):ViewModel() {
    var cryptoList = mutableStateOf<List<CryptoListItem>>(listOf())
    var errorMessage = mutableStateOf("")
    var isLoading = mutableStateOf(false)


    fun downLoadCryptos(){
        viewModelScope.launch {
            isLoading.value = true

            val result = repository.getCryptoList()

            when(result){
                is Resource.Success->{
                    val cryptoItems = result.data!!.mapIndexed { index, item ->
                        CryptoListItem(item.currency,item.price)
                    }
                    errorMessage.value = ""
                    isLoading.value = false
                    cryptoList.value +=cryptoItems
                }
                is Resource.Error->{
                    errorMessage.value = result.message!!
                    isLoading.value = false

                }

            }

        }

    }

}