package com.example.music.main.adapter

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager.widget.PagerAdapter

class MainFragmentPagerAdapter(fragmentManager: FragmentManager):FragmentStatePagerAdapter(fragmentManager){

    private lateinit var fragmentList:List<Fragment>

    fun initFragmentList(list: List<Fragment>){
        fragmentList = list
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return fragmentList.size
    }

    override fun getItemPosition(`object`: Any): Int {
        return PagerAdapter.POSITION_NONE
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

    }

}