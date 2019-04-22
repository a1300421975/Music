package com.example.music.main.view


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.music.FragmentMVList
import com.example.music.R
import com.example.music.base.BaseFragment
import com.example.music.main.adapter.MainFragmentPagerAdapter
import com.example.music.showSongList.view.FragmentSongList
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : BaseFragment() {

    private lateinit var mainFragmentViewPager:ViewPager
    private lateinit var mainToolbar: Toolbar
    private lateinit var musicText:TextView
    private lateinit var videoText:TextView
    private lateinit var mainFragmentPagerAdapter: MainFragmentPagerAdapter
    private val fragmentList = ArrayList<Fragment>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main,container,false)
        view_ = view
        initView(view)
        setFragment()
        onClickEvent()
        return view
    }

    private fun initView(view:View){
        mainFragmentViewPager = view.findViewById(R.id.fragment_main_viewPager)
        mainToolbar = view.findViewById(R.id.first_toolbar)
        musicText = view.findViewById(R.id.to_song_list_fragment)
        videoText = view.findViewById(R.id.to_mv_fragment)
    }

    private fun setFragment(){
        fragmentList.add(FragmentSongList())
        fragmentList.add(FragmentMVList())
        mainFragmentPagerAdapter = MainFragmentPagerAdapter(childFragmentManager)
        mainFragmentPagerAdapter.initFragmentList(fragmentList)
        mainFragmentViewPager.adapter = mainFragmentPagerAdapter
        mainFragmentViewPager.currentItem = 0
    }

    private fun onClickEvent(){
        musicText.setOnClickListener{
            mainFragmentViewPager.currentItem = 0
        }
        videoText.setOnClickListener {
            mainFragmentViewPager.currentItem = 1
        }
    }


}
