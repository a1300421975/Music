package com.example.music.showSongList.view


import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.music.R
import com.example.music.base.BaseFragment
import com.example.music.showSongList.adapter.SongListRecyclerAdapter
import com.example.music.utils.SongListUtil

class FragmentSongList : BaseFragment() {

    private lateinit var songListRecycler: RecyclerView
    private val songListRecyclerAdapter = SongListRecyclerAdapter()
    private val handler = Handler()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_song_list, container, false)
        view_ = view
        initView()
        initData()
        return view
    }

    private fun initView(){
        songListRecycler = find(R.id.song_list_recycler)
        songListRecycler.layoutManager = LinearLayoutManager(this.context)
        songListRecycler.adapter = songListRecyclerAdapter
    }

    private fun initData(){
        freshSongList()
    }

    private fun freshSongList(){
//        var count = 0
        SongListUtil.getSongList(SongListUtil.URL_QQ){
            handler.post {
                songListRecyclerAdapter.freshQQSongList(it)
                songListRecyclerAdapter.notifyDataSetChanged()
            }
//            count = it.size
        }

//        SongListUtil.getSongList(SongListUtil.URL_WYY){
//            handler.post {
//                songListRecyclerAdapter.freshWYYSongList(it)
//                songListRecyclerAdapter.notifyItemRangeChanged(count,it.size,it)
//            }
//        }
    }
}
