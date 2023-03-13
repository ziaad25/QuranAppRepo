package com.ziaad.qrannapp.ui.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    fun Api(baseurl: String): JsonPlaceHolderApi {
        val retrofit: Retrofit =Retrofit.Builder()
                .baseUrl(baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit.create(JsonPlaceHolderApi::class.java)
    }
}



