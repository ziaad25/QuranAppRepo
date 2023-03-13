package com.ziaad.qrannapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.recyclerview.widget.RecyclerView
import com.ziaad.qrannapp.Fragment.CompassF
import com.ziaad.qrannapp.Fragment.book
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)

        setholefram(this, book())
        bottomNavigationView.setOnNavigationItemSelectedListener { item ->

            when (item.itemId) {
                R.id.btn_book -> setholefram(this, book())
                R.id.btn_compass ->setholefram(this,CompassF())

            }
            true

        }

    }

    fun setholefram(activty: FragmentActivity, fragment: Fragment) {
        activty.supportFragmentManager.beginTransaction()
            .replace(R.id.holefram, fragment)
            .commit()
    }


// btnBook

}

