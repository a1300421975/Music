package com.example.music.songListDetail.presenter

import com.example.music.enumClass.SongListType
import com.example.music.songListDetail.model.ISingleSongListModel
import com.example.music.songListDetail.model.SingleSongListModel
import com.example.music.songListDetail.view.ISingleSongListView

class SingleSongListPresenter:ISingleSongListPresenter{

    private var iSingleSongListView:ISingleSongListView? = null
    private var iSingleSongListModel:ISingleSongListModel = SingleSongListModel()

    override fun getData(id: String, songListType: SongListType) {
        if (songListType == SongListType.QQSongList){
            iSingleSongListModel.requestQQData(id){
                iSingleSongListView!!.getQQSongListDate(it)
            }
        }
//        if (songListType == SongListType.WYYSongList){
//            iSingleSongListModel.requestWYYData(id){
//                iSingleSongListView!!.getWYYData(it)
//            }
//        }
    }

    override fun <V : ISingleSongListView> attachView(view: V) {
        iSingleSongListView = view
    }

    override fun detachView(){
        iSingleSongListView = null
    }

}