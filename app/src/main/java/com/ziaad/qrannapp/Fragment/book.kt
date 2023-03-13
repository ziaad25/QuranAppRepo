package com.ziaad.qrannapp.Fragment

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.media.MediaCodec.MetricsConstants.MODE
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ziaad.qrannapp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_book.*
import kotlinx.android.synthetic.main.fragment_book.view.*


class book : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        var view = inflater.inflate(R.layout.fragment_book, container, false)

        default(view)


        view.btn_surah.setOnClickListener {

            btn_part.isSelected = false
            btn_prayer.isSelected = false
            btn_surah.isSelected = true
            setfram(surah())
        }
        view.btn_prayer.setOnClickListener {

            btn_part.isSelected = false
            btn_prayer.isSelected = true
            btn_surah.isSelected = false

        }
        view.btn_part.setOnClickListener {

            btn_part.isSelected = true
            btn_prayer.isSelected = false
            btn_surah.isSelected = false


        }

        return view
    }

    fun default(view: View) {
        view.btn_part.isSelected = false
        view.btn_prayer.isSelected = false
        view.btn_surah.isSelected = true

        setfram(surah())
        dataLastVisit(view)
    }

    fun setfram(fragment: Fragment) {
        var transaction = requireFragmentManager().beginTransaction()
        transaction.replace(R.id.fram_btn, fragment)
            .commit()
    }

    private fun dataLastVisit(view: View) {

        var sh = context?.getSharedPreferences("myPreference", MODE_PRIVATE)
        var name = sh!!.getString("suraNameAr", "")
        var name2 = sh.getString("suraNameEn", "")
        if (name!!.isNotEmpty()){
            view.img_book.visibility = View.VISIBLE
        }

        view.tv_arabicNameUp.text = name
        view.tv_englishNameUp.text = name2
    }


}