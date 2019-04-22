package com.example.music.songListDetail.presenter

import com.example.music.enumClass.SongListType
import com.example.music.songListDetail.view.ISingleSongListView

interface ISingleSongListPresenter{

    fun getData(id:String,songListType: SongListType)

    fun <V: ISingleSongListView> attachView(view: V)

    fun detachView()

}