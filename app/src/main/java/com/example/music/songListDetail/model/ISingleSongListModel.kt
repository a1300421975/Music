package com.example.music.songListDetail.model

import com.example.music.data.QQSingleSongList
import com.example.music.data.WYYSingleSongList

interface ISingleSongListModel{
    fun requestQQData(id:String,callBack:(QQSingleSongList) -> Unit)
    fun requestWYYData(id:String,callBack:(WYYSingleSongList) -> Unit)
}