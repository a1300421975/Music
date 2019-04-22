package com.example.music.songListDetail.model

import com.example.music.data.QQSingleSongList
import com.example.music.data.WYYSingleSongList
import com.example.music.enumClass.SongListType
import com.example.music.songListDetail.presenter.ISingleSongListPresenter
import com.example.music.utils.GsonUtil
import com.example.music.utils.OKHttpUtil

class SingleSongListModel:ISingleSongListModel{

    companion object{
        const val QQ_URL = "https://api.itooi.cn/music/tencent/songList?key=579621905&id="
        const val WYY_URL = "https://api.itooi.cn/music/netease/songList?key=579621905&id="
    }

    override fun requestWYYData(id: String, callBack: (WYYSingleSongList) -> Unit) {
        OKHttpUtil.sendRequestWithOKHttp(WYY_URL +id){
            GsonUtil.gsonUtil<WYYSingleSongList>(it){wyySongList ->
                callBack(wyySongList)
            }
        }
    }

    override fun requestQQData(id: String, callBack: (QQSingleSongList) -> Unit) {
        OKHttpUtil.sendRequestWithOKHttp(QQ_URL +id){
            GsonUtil.gsonUtil<QQSingleSongList>(it){qqSongList ->
                callBack(qqSongList)
            }
        }
    }
}