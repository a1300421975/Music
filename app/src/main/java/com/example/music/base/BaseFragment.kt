package com.example.music.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment:Fragment(){

    protected var view_:View? = null
    private var parent:ViewGroup? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (view_ != null){
            if (view_!!.parent != null){
                parent = view_!!.parent as ViewGroup
                parent!!.removeView(view_)
            }
            return view_
        }
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    protected fun <T:View> find(resId:Int):T{
        return view_!!.findViewById(resId)
    }
}