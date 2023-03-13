package com.ziaad.qrannapp.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ziaad.qrannapp.R
import com.ziaad.qrannapp.model.SuraDetail

class ListenSuraRecyclerViewAdapter:RecyclerView.Adapter<ListenSuraRecyclerViewAdapter.listenViewHolder>() {

    var suraDetailList: ArrayList<SuraDetail> = ArrayList()

    @SuppressLint("NotifyDataSetChanged")
    fun setDetail(suraDetailList: ArrayList<SuraDetail>) {
        this.suraDetailList = suraDetailList
        notifyDataSetChanged()
    }

    class listenViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvAyaArabic: TextView = itemView.findViewById(R.id.tv_ayaArabic)
        var tvAyaEnglish: TextView = itemView.findViewById(R.id.tv_ayaEnglish)
        var tvAyaFootnets:TextView=itemView.findViewById(R.id.tv_ayafootnets)
        var tvNumberAyaArabic: TextView = itemView.findViewById(R.id.tv_numberAyaArabic)
        fun bind(suraDetailList: SuraDetail) {
            tvAyaArabic.text = suraDetailList.arabic_text
            tvAyaEnglish.text = suraDetailList.translation

            if(suraDetailList.footnotes!=""){
                tvAyaFootnets.text=suraDetailList.footnotes
            }
            else{
                tvAyaFootnets.textSize= 20F
                tvAyaFootnets.text="Not found"
            }



//            tvNumberAyaArabic.text=suraDetailList.aya

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): listenViewHolder {
        var view = LayoutInflater.from(parent.context)
            .inflate(R.layout.listitem_surah_listen, parent, false)
        return listenViewHolder(view)
    }

    override fun onBindViewHolder(holder: listenViewHolder, position: Int) {
        var suraDetailList = suraDetailList[position]
        holder.bind(suraDetailList)
    }

    override fun getItemCount(): Int {
        return suraDetailList.size
    }
}