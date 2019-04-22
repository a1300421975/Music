package com.example.music.songListDetail.singleSong.holder

import android.view.View
import android.widget.Adapter
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.music.R
import com.example.music.base.BaseRecyclerHolder
import com.example.music.data.QQSingleSongListSong

class SingleSongHolder(view: View):BaseRecyclerHolder(view){

    val numPlay = view.findViewById<RelativeLayout>(R.id.num_play)
    val songNumber = view.findViewById<TextView>(R.id.song_number)
    val playIcon = view.findViewById<ImageView>(R.id.play_icon)
    private val songName = view.findViewById<TextView>(R.id.song_name)
    private val songAuthor = view.findViewById<TextView>(R.id.song_author)
    var point = -1

    override fun bind(vararg any: Any) {
        if (any.isEmpty())return
        val qqSong = any[0]
        if (qqSong is QQSingleSongListSong){
            qqSong.apply {
                songAuthor.text = singer
                songName.text = name
            }
            numPlay.setOnClickListener {

            }
        }
    }



}