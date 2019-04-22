package com.example.music.songListDetail.singleSong.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.music.R
import com.example.music.base.BaseRecyclerHolder
import com.example.music.data.QQSingleSongListSong
import com.example.music.songListDetail.singleSong.holder.SingleSongHolder

class SingleSongAdapter:RecyclerView.Adapter<SingleSongHolder>(){

    private val QQSongList = ArrayList<QQSingleSongListSong>()

    fun freshQQSong(songList:List<QQSingleSongListSong>){
        QQSongList.addAll(songList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SingleSongHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.song_item,parent,false)
        return SingleSongHolder(view)
    }

    override fun getItemCount(): Int {
        return if(QQSongList.isEmpty()){
            0
        }else{
            QQSongList.size
        }



    }

    override fun onBindViewHolder(holder: SingleSongHolder, position: Int) {
        holder.bind(QQSongList[position])
        holder.songNumber.text = (position + 1).toString()
    }

}