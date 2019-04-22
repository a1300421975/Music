package com.example.music

import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.music.playSong.view.IPlaySongView

class MainActivity : AppCompatActivity(),IPlaySongView {

    private lateinit var songPlayRelative:RelativeLayout
    private lateinit var songImage:ImageView
    private lateinit var songNameText:TextView
    private lateinit var songWordText:TextView
    private lateinit var noSongText:TextView
    private lateinit var playStateImage:ImageView

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navController = Navigation.findNavController(this,R.id.fragment)
        initView()
        onClickEvent()
    }

    private fun initView(){
        songPlayRelative = findViewById(R.id.music_play)
        songImage = findViewById(R.id.song_image)
        songNameText = findViewById(R.id.song_name)
        songWordText = findViewById(R.id.song_word)
        noSongText = findViewById(R.id.no_song_text)
        playStateImage = findViewById(R.id.song_state)
    }

    private fun onClickEvent(){
        songPlayRelative.setOnClickListener {

        }
        playStateImage.setOnClickListener {

        }
    }

    override fun onNavigateUp(): Boolean {
        return navController.navigateUp()
    }

    override fun setSongImage(bitmap: Bitmap) {
        songImage.setImageBitmap(bitmap)
    }

    override fun setSongName(songName: String) {
        songNameText.text = songName
    }

    override fun setSongWord(songWord: String) {
        songWordText.text = songWord
    }

    override fun setViewVisible(isNoSong: Boolean) {
        if (!isNoSong){
            noSongText.visibility = View.GONE
            songImage.visibility = View.VISIBLE
            songNameText.visibility = View.VISIBLE
            songWordText.visibility = View.VISIBLE
        }
    }

}
