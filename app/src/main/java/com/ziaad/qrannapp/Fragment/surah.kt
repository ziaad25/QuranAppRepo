package com.ziaad.qrannapp.Fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.ziaad.qrannapp.R
import com.ziaad.qrannapp.response.SuraResponse
import com.ziaad.qrannapp.ui.API.JsonPlaceHolderApi
import com.ziaad.qrannapp.ui.adapter.SuraRecyclerViewAdapter
import com.ziaad.qrannapp.ui.listen
import kotlinx.android.synthetic.main.fragment_surah.view.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [surah.newInstance] factory method to
 * create an instance of this fragment.
 */
class surah : Fragment() {
    var adapterQuran = SuraRecyclerViewAdapter()

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        var view = LayoutInflater.from(context).inflate(R.layout.fragment_surah, container, false)

// builder && convertor

        var retrofit = Retrofit.Builder()
            .baseUrl("https://api.alquran.cloud/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
//call
        var apiInterface =
            retrofit.create(JsonPlaceHolderApi::class.java) // لكي يخزن البنات عن طريق الretrofit فى ال apiInterface اللى عملناه حتى أستطيع ان احصل عليه عن طريق ال response
        var call = apiInterface.GetSura()
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
        var i =Intent(context,listen::class.java)
            i.putExtra("suraName", it.name)
            i.putExtra("Number",it.number)
            startActivity(i)

        }
        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment surah.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            surah().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}