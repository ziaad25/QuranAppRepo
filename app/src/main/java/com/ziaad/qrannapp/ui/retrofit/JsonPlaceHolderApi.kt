package com.ziaad.qrannapp.ui.retrofit

import com.ziaad.qrannapp.response.DetailSuraResponse
import com.ziaad.qrannapp.response.SuraResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface JsonPlaceHolderApi {
    @GET("surah")
    fun GetSura(): Call<SuraResponse>

    @GET("sura/english_saheeh/{id}")
    fun GetSuraDetaiil(@Path("id") SurahId: Int): Call<DetailSuraResponse>

}
