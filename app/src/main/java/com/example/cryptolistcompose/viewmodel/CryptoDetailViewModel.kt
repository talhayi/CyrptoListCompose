package com.example.cryptolistcompose.viewmodel

import androidx.lifecycle.ViewModel
import com.example.cryptolistcompose.model.Crypto
import com.example.cryptolistcompose.repository.CryptoRepository
import com.example.cryptolistcompose.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CryptoDetailViewModel @Inject constructor(
    private val repository: CryptoRepository
):ViewModel(){

    suspend fun getCrypto(id: String) : Resource<Crypto>{
        return repository. getCrypto(id)
    }
}