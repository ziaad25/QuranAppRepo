package com.ziaad.qrannapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ziaad.qrannapp.Fragment.surah
import com.ziaad.qrannapp.R
import com.ziaad.qrannapp.response.DetailSuraResponse
import com.ziaad.qrannapp.ui.retrofit.JsonPlaceHolderApi
import com.ziaad.qrannapp.ui.adapter.ListenSuraRecyclerViewAdapter
import com.ziaad.qrannapp.ui.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.activity_listen.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class listen : AppCompatActivity() {
    // tv_sura_listenName -tv_ayaArabic - tv_numberAya - tv_ayaEnglish - tv_numberAya2- tv_ayaIndia
    var listenSuraRecyclerViewAdapter = ListenSuraRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)

        btn_back.setOnClickListener {
            var i = Intent(this, surah::class.java)
            startActivity(i)
        }

// data from surah(fragment)
        var data = intent
        var suraName = data.extras!!.getString("suraName")
        var suranNumber = data.extras!!.getInt("Number")

        tv_sura_listenName.text = suraName
// retrofit
        var call =
            RetrofitClient.Api("https://quranenc.com/api/translation/").GetSuraDetaiil(suranNumber)
        call.enqueue(object : Callback<DetailSuraResponse> {
            override fun onResponse(
                call: Call<DetailSuraResponse>,
                response: Response<DetailSuraResponse>,
            ) {

                listenSuraRecyclerViewAdapter.setDetail(response.body()!!.result)
            }

            override fun onFailure(call: Call<DetailSuraResponse>, t: Throwable) {
                Toast.makeText(applicationContext, "erreor", Toast.LENGTH_SHORT).show()
            }

        })
// recyclerView
        suraListen_recycler.setHasFixedSize(true)
        suraListen_recycler.adapter = listenSuraRecyclerViewAdapter


    }
}