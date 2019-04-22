package com.example.music.utils

import com.example.music.data.QQSongList
import com.example.music.data.SongListTransform
import com.example.music.data.WYYSongList

object SongListUtil{

    const val URL_QQ = "https://api.bzqll.com/music/tencent/hotSongList?key=579621905&categoryId=10000000&sortId=3&limit=60"
    const val URL_WYY = "https://api.itooi.cn/music/netease/hotSongList?key=579621905&cat=全部&limit=100&offset=0"

    fun getSongList(url:String,callBack:(List<SongListTransform>) -> Unit) {
            OKHttpUtil.sendRequestWithOKHttp(url) {
                //Log.d("aaa",it.toString())
                if (url == URL_QQ) {
                    GsonUtil.gsonUtil<QQSongList>(it) { qqSongList ->
                        songListTransform(qqSongList) { songList ->
                            callBack(songList)
                        }
                    }
                }
                if (url == URL_WYY) {
                    GsonUtil.gsonUtil<WYYSongList>(it) { wyySongList ->
                        songListTransform(wyySongList){ songList ->
                            callBack(songList)
                        }
                    }
                }
            }

    }

    private fun <T> songListTransform(songList:T,callBack:(songListTransform:List<SongListTransform>)->Unit){
        var i = 0
        val songListTransform = ArrayList<SongListTransform>()

        /**
         * 为qq音乐链接
         */
        if (songList is QQSongList){
            var temp: SongListTransform? = null
            while (i < songList.data.size){
                if(i % 2 == 0){
                    temp = SongListTransform()
                    songList.data[i].apply {
                        temp!!.apply {
                            creator1 = creator
                            id1 = id
                            name1 = name
                            pic1 = pic
                            playCount1 = playCount

                        }
                    }
                }else{
                    songList.data[i].apply {
                        temp!!.apply {
                            creator2 = creator
                            id2 = id
                            name2 = name
                            pic2 = pic
                            playCount2 = playCount
                        }
                    }
                    songListTransform.add(temp!!)
                }
                i++
            }
            callBack(songListTransform)
        }
        /**
         * 为网易云链接
         */
        if (songList is WYYSongList){
            var temp: SongListTransform? = null
            while (i < songList.data.size){
                if(i % 2 == 0){
                    temp = SongListTransform()
                    songList.data[i].apply {
                        temp.apply {
                            creator1 = creator
                            id1 = id.toString()
                            name1 = name
                            pic1 = pic
                            playCount1 = playCount.toString()

                        }
                    }
                }else{
                    songList.data[i].apply {
                        temp!!.apply {
                            creator2 = creator
                            id2 = id.toString()
                            name2 = name
                            pic2 = pic
                            playCount2 = playCount.toString()
                        }
                    }
                    songListTransform.add(temp!!)
                }
                i++
            }
            callBack(songListTransform)
        }
    }
}
