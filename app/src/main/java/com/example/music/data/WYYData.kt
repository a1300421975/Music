package com.example.music.data

import com.google.gson.annotations.SerializedName

/**
 * 单个歌单信息获取
 * https://api.itooi.cn/music/netease/songList?key=579621905&id=3778678&limit=10&offset=0
 */

data class WYYSingleSongList(
    val code: Int,
    val `data`: WYYSingleSongListData,
    val result: String
)

data class WYYSingleSongListData(
    @SerializedName("songListCount")
    val songnum: Int,
    @SerializedName("songListDescription")
    val desc: String,
    @SerializedName("songListId")
    val id: String,
    @SerializedName("songListName")
    val title: String,
    @SerializedName("songListPic")
    val logo: String,
    val songs: List<WYYSingleSongListSong>
)

data class WYYSingleSongListSong(
    val id: String,
    val lrc: String,
    val name: String,
    val pic: String,
    val singer: String,
    val time: Int,
    val url: String
)

/**
 * 热门歌单获取
 * https://api.itooi.cn/music/netease/hotSongList?key=579621905&cat=%E5%85%A8%E9%83%A8&limit=100&offset=0
 */
data class WYYSongList(
    val code: Int,
    val `data`: List<WYYSongListData>,
    val result: String
)


data class WYYSongListData(
    var creator: String,
    val id: Long,
    @SerializedName("title")
    val name: String,
    @SerializedName("coverImgUrl")
    val pic: String,
    val playCount: Int
)