package com.example.music.showSongList.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music.R
import com.example.music.base.BaseRecyclerHolder
import com.example.music.data.SongListTransform
import com.example.music.showSongList.holder.SongListHolder

class SongListRecyclerAdapter:RecyclerView.Adapter<BaseRecyclerHolder>(){

    private val qqSongList = ArrayList<SongListTransform>()
    private val wyySongList = ArrayList<SongListTransform>()

    fun freshQQSongList(list:List<SongListTransform>){
        qqSongList.addAll(list)
    }

//    fun freshWYYSongList(list: List<SongListTransform>){
//        wyySongList.addAll(list)
//    }

    override fun onBindViewHolder(holder: BaseRecyclerHolder, position: Int) {
        when{
            position < qqSongList.size -> holder.bind(qqSongList[position])
//            position >= qqSongList.size -> holder.bind(wyySongList[position - qqSongList.size])
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseRecyclerHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_list_item,parent,false)
        return SongListHolder(view)
    }

    override fun getItemCount(): Int {
        return if (qqSongList.size == 0){
            0
        }else{
            qqSongList.size + wyySongList.size
        }
    }

}