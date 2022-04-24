package com.ziaad.qrannapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ziaad.qrannapp.R
import com.ziaad.qrannapp.model.Surah
import kotlinx.android.synthetic.main.listitem_surah.view.*

class SuraRecyclerViewAdapter : RecyclerView.Adapter<SuraRecyclerViewAdapter.SuraViewHolder>() {
    var onItemClick:((Surah)->Unit)?=null

    var Surahlis : ArrayList<Surah> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setSuradata(surahList: ArrayList<Surah>) {
        this.Surahlis = surahList
        notifyDataSetChanged()
    }

    class SuraViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tv_counter: TextView = itemView.findViewById(R.id.tv_counter)
        var tv_englishName: TextView = itemView.findViewById(R.id.tv_englishName)
        var tv_ProdigyNumber: TextView = itemView.findViewById(R.id.tv_ProdigyNumber)
        var tv_ArabicName: TextView = itemView.findViewById(R.id.tv_ArabicName)
        fun bind(surahList: Surah) {
            tv_counter.text = surahList.number.toString()
            tv_englishName.text = surahList.englishName
            tv_ProdigyNumber.text = surahList.numberOfAyahs.toString()
            tv_ArabicName.text = surahList.name


        }


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuraViewHolder {
        return SuraViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.listitem_surah, parent, false)
        )
    }

    override fun onBindViewHolder(holder: SuraViewHolder, position: Int) {
        val surah=Surahlis[position]
        holder.bind(surah)
        holder.itemView.setOnClickListener {
            onItemClick?.invoke(surah)
        }
    }

    override fun getItemCount(): Int {
        return Surahlis.size
    }
}