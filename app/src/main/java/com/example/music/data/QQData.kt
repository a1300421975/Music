package com.example.music.data

import java.io.Serializable

data class QQSingleSongList(
    val code: Int,
    val `data`: QQSingleSongListData,
    val result: String
)

data class QQSingleSongListData(
    //val author: String,
    val desc: String,
    val id: String,
    val logo: String,
    val songnum: String,
    val songs: List<QQSingleSongListSong>,
    val title: String
)


data class QQSingleSongListSong(
    var id: String,
    val lrc: String,
    val name: String,
    val pic: String,
    val singer: String,
    val time: Int,
    val url: String
)

data class QQSongList(
    val code: Int,
    val `data`: List<Data>,
    val result: String
)

data class Data(
    val creator: String,
    val id: String,
    val name: String,
    val pic: String,
    val playCount: String
)

data class SongListTransform(
    var creator1: String = "",
    var id1: String = "",
    var name1: String = "",
    var pic1: String = "",
    var playCount1: String = "",
    var creator2: String = "",
    var id2: String = "",
    var name2: String = "",
    var pic2: String = "",
    var playCount2: String = ""
) : Serializable
