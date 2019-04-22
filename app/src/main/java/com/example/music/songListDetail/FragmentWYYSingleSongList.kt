//package com.example.music.songListDetail
//
//import android.os.Bundle
//import android.os.Handler
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import com.example.music.R
//import com.example.music.data.QQSingleSongList
//import com.example.music.data.WYYSingleSongList
//import com.example.music.enumClass.SongListType
//import com.example.music.songListDetail.base.BaseSingleSongList
//import com.example.music.songListDetail.presenter.ISingleSongListPresenter
//import com.example.music.songListDetail.presenter.SingleSongListPresenter
//import com.example.music.songListDetail.view.ISingleSongListView
//import com.example.music.utils.GlideUtil
//
//class FragmentWYYSingleSongList:BaseSingleSongList(),ISingleSongListView{
//
//    private var iSingleSongListPresenter: ISingleSongListPresenter? = null
//
//    private val handler =  Handler()
//    private var id:String = ""
//    private var author:String = ""
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        iSingleSongListPresenter = SingleSongListPresenter()
//        (iSingleSongListPresenter as SingleSongListPresenter).attachView(this)
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
//        val view = inflater.inflate(R.layout.fragment_single_song_list, container, false)
//        view_ = view
//        initView()
//        iSingleSongListPresenter!!.getData(id, SongListType.QQSongList)
//        return view
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        iSingleSongListPresenter!!.detachView()
//    }
//
//    override fun getWYYData(wyySingleSongList: WYYSingleSongList) {
//        wyySingleSongList.data.apply {
//            songListAuthor.text = author
//            songListDesc.text = desc
//            songListName.text = title
//            songNum.text = songnum.toString()
//            GlideUtil.setImage(logo,songListImage,context!!)
//        }
//    }
//
//    override fun getQQSongListDate(qqSingelSongList: QQSingleSongList) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//}