package com.example.music.songListDetail


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.music.R
import com.example.music.data.QQSingleSongList
import com.example.music.data.WYYSingleSongList
import com.example.music.enumClass.SongListType
import com.example.music.songListDetail.base.BaseSingleSongList
import com.example.music.songListDetail.presenter.ISingleSongListPresenter
import com.example.music.songListDetail.presenter.SingleSongListPresenter
import com.example.music.songListDetail.singleSong.adapter.SingleSongAdapter
import com.example.music.songListDetail.view.ISingleSongListView
import com.example.music.utils.GlideUtil

class FragmentQQSingleSongList : BaseSingleSongList(), ISingleSongListView {

    private var iSingleSongListPresenter:ISingleSongListPresenter? = null

    private val handler =  Handler()
    private var author:String? = ""
    private lateinit var songAdapter: SingleSongAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        iSingleSongListPresenter = SingleSongListPresenter()
        (iSingleSongListPresenter as SingleSongListPresenter).attachView(this)
        val id = arguments!!.getString("id")
        author = arguments!!.getString("author")
        iSingleSongListPresenter!!.getData(id!!,SongListType.QQSongList)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_single_song_list, container, false)
        view_ = view
        initView()
        initData()
        return view
    }

    private fun initData(){
        songAdapter = SingleSongAdapter()
        songListRecycler.layoutManager = LinearLayoutManager(this.context)
        songListRecycler.adapter = songAdapter
    }

    override fun getQQSongListDate(qqSingleSongList: QQSingleSongList) {
        qqSingleSongList.data.apply {
            handler.post {
                songListAuthor.text = author
                songListDesc.text = desc
                songListName.text = title
                songNum.text = songnum
                GlideUtil.setImage(logo,songListImage,context!!)
                songAdapter.freshQQSong(songs)
                songAdapter.notifyDataSetChanged()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        iSingleSongListPresenter!!.detachView()
    }
}
