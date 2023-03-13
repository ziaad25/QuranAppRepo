package com.ziaad.qrannapp.Fragment

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Display
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ziaad.qrannapp.R
import com.ziaad.qrannapp.response.SuraResponse
import com.ziaad.qrannapp.ui.retrofit.JsonPlaceHolderApi
import com.ziaad.qrannapp.ui.adapter.SuraRecyclerViewAdapter
import com.ziaad.qrannapp.ui.listen
import com.ziaad.qrannapp.ui.retrofit.RetrofitClient
import kotlinx.android.synthetic.main.fragment_surah.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.prefs.Preferences


class surah : Fragment() {
    var adapterQuran = SuraRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        var view = LayoutInflater.from(context).inflate(R.layout.fragment_surah, container, false)

// builder && convertor

//call
        // لكي يخزن البيانات عن طريق الretrofit فى ال apiInterface اللى عملناه حتى أستطيع ان احصل عليه عن طريق ال response
        var call = RetrofitClient.Api("https://api.alquran.cloud/v1/").GetSura()
        call.enqueue(object : Callback<SuraResponse> {
            override fun onResponse(call: Call<SuraResponse>, response: Response<SuraResponse>) {

                adapterQuran.setSuradata(response.body()!!.data)

            }

            override fun onFailure(call: Call<SuraResponse>, t: Throwable) {
                Toast.makeText(context, "fail", Toast.LENGTH_SHORT).show()
            }

        })

        view.Sura_RecyclerView.adapter = adapterQuran

        adapterQuran.onItemClick = {
            var i = Intent(context, listen::class.java)
            i.putExtra("suraName", it.name)
            i.putExtra("Number", it.number)

            var sh = context?.getSharedPreferences("myPreference", MODE_PRIVATE)

            var ed = sh?.edit()
            ed?.putString("suraNameAr", it.name)
            ed?.putString("suraNameEn", it.englishName)
            ed?.apply()

            startActivity(i)

        }
        return view
    }

}