package com.example.music.utils

import android.content.Context
import android.util.Log
import android.widget.ImageView
import com.bumptech.glide.Glide

object GlideUtil{

    fun setImage(url:String,imageView: ImageView,context:Context){
        Glide.with(context)
            .load(url.trim())
            .into(imageView)
        Log.d("aaa","glide运行")
    }

}