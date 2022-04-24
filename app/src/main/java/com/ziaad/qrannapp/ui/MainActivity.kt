package com.ziaad.qrannapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.ziaad.qrannapp.Fragment.surah
import com.ziaad.qrannapp.R
import com.ziaad.qrannapp.ui.adapter.SuraRecyclerViewAdapter
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
//    lateinit var binding: ActivityMainBinding

    // var quran = ArrayList<Quran>()
    lateinit var showrecycler: RecyclerView
    var adapterQuran = SuraRecyclerViewAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        default()
        btn_book.setOnClickListener {
            btn_book.isSelected = true
        }
        btn_surah.setOnClickListener {

            btn_part.isSelected = false
            btn_prayer.isSelected = false
            btn_surah.isSelected = true
            setfram(surah())
        }
        btn_prayer.setOnClickListener {

            btn_part.isSelected = false
            btn_prayer.isSelected = true
            btn_surah.isSelected = false

        }
        btn_part.setOnClickListener {

            btn_part.isSelected = true
            btn_prayer.isSelected = false
            btn_surah.isSelected = false


        }

// builder && convertor

        /*      var retrofit = Retrofit.Builder()
                  .baseUrl("https://quranenc.com/api/v1/translation/")
                  .addConverterFactory(GsonConverterFactory.create())
                  .build()
      //call
              var apiInterface =
                  retrofit.create(apiInterface::class.java) // لكي يخزن البنات عن طريق الretrofit فى ال apiInterface اللى عملناه حتى أستطيع ان احصل عليه عن طريق ال response
              var call = apiInterface.getPost()
              call.enqueue(object : Callback<ArrayList<postdata>> {
                  override fun onResponse(
                      call: Call<ArrayList<postdata>>,
                      response: Response<ArrayList<postdata>>
                  ) {
                      Toast.makeText(applicationContext, "done server", Toast.LENGTH_SHORT).show()

                      adapterQuran.setList(response.body()!!) // ال body() هو ملف ال json الذي يحوى كل البيانات

                  }

                  override fun onFailure(call: Call<ArrayList<postdata>>, t: Throwable) {
                      Toast.makeText(applicationContext, "fail in connect", Toast.LENGTH_SHORT).show()
                  }

              })*/
// data class(Quran)

        /*  quran.add(Quran(2, "d", "a", "a"))
          quran.add(Quran(3, "d", "a", "a"))*/


        // adapter.setList(quran)


    }

    /*    override fun onClick(view: View?) {
            when (view!!.id) {
                R.id.btn_surah -> {
    //                adapter.setList(quran)
                    Toast.makeText(this, "btn surah", Toast.LENGTH_SHORT).show()
                }
            }
        }*/
    fun setfram(fragment: Fragment) {
        var fragment = fragment
        var transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fram_btn, fragment)
            .commit()
    }

    fun default() {
        btn_part.isSelected = false
        btn_prayer.isSelected = false
        btn_surah.isSelected = true
        setfram(surah())
// btnBook
        btn_book.isSelected = true

    }

}