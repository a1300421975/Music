package com.example.music.songListDetail.base

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.music.R
import com.example.music.base.BaseFragment

abstract class BaseSingleSongList: BaseFragment(){

    protected lateinit var songListImage: ImageView
    protected lateinit var songListName: TextView
    protected lateinit var songListAuthor: TextView
    protected lateinit var songListDesc: TextView
    protected lateinit var songListToolBar: Toolbar
    protected lateinit var songListPlayAll: ConstraintLayout
    protected lateinit var songNum: TextView
    protected lateinit var songListRecycler: RecyclerView

    protected fun initView(){
        songListImage = find(R.id.song_list_image)
        songListName = find(R.id.song_list_name)
        songListAuthor = find(R.id.song_list_author)
        songListDesc = find(R.id.song_list_desc)
        songListToolBar = find(R.id.song_list_toolbar)
        songListPlayAll = find(R.id.play_all)
        songNum = find(R.id.song_num)
        songListRecycler = find(R.id.song_recycler)
    }

}