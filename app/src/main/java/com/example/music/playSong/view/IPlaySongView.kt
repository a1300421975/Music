package com.example.music.playSong.view

import android.graphics.Bitmap

interface IPlaySongView {
    //设置音乐图片
    fun setSongImage(bitmap:Bitmap)
    //设置歌名
    fun setSongName(songName:String)
    //设置歌词
    fun setSongWord(songWord:String)
    //当不是没歌状态
    fun setViewVisible(isNoSong:Boolean)
}