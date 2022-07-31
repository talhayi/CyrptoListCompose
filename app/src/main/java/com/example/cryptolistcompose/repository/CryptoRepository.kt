package com.example.cryptolistcompose.repository

import com.example.cryptolistcompose.model.Crypto
import com.example.cryptolistcompose.model.CryptoList
import com.example.cryptolistcompose.service.CryptoAPI
import com.example.cryptolistcompose.util.Constants.API_KEY
import com.example.cryptolistcompose.util.Constants.CALL_ATTRIBUTES
//import com.example.cryptolistcompose.util.Constants.API_KEY
import com.example.cryptolistcompose.util.Resource
import dagger.hilt.android.scopes.ActivityScoped
import javax.inject.Inject

@ActivityScoped
class CryptoRepository @Inject constructor(
    private val api : CryptoAPI
) {

    /*
    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList()
        } catch(e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

     */



    suspend fun getCryptoList(): Resource<CryptoList> {
        val response = try {
            api.getCryptoList(API_KEY)
        } catch(e: Exception) {
            return Resource.Error("Error.")
        }
        return Resource.Success(response)
    }

    suspend fun getCrypto(id: String): Resource<Crypto> {
        val response = try {
            api.getCrypto(API_KEY,id,CALL_ATTRIBUTES)
        } catch(e: Exception) {
            return Resource.Error("Error")
        }
        return Resource.Success(response)
    }


}