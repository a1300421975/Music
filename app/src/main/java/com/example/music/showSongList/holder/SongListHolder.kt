package com.example.music.showSongList.holder

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import com.example.music.R
import com.example.music.base.BaseRecyclerHolder
import com.example.music.data.SongListTransform
import com.example.music.utils.GlideUtil

class SongListHolder(view:View):BaseRecyclerHolder(view){

    val songListItem1: ConstraintLayout = view.findViewById(R.id.song_list_item1)
    val songListItem2: ConstraintLayout = view.findViewById(R.id.song_list_item2)
    val songListImage1: ImageView = view.findViewById(R.id.song_list_image1)
    val songListImage2: ImageView = view.findViewById(R.id.song_list_image2)
    val songListName1: TextView = view.findViewById(R.id.song_list_name1)
    val songListName2: TextView = view.findViewById(R.id.song_list_name2)
    val songListAuthor1: TextView = view.findViewById(R.id.song_list_author1)
    val songListAuthor2: TextView = view.findViewById(R.id.song_list_author2)

    override fun bind(vararg any: Any) {
        if (any.isEmpty())return
        val songListTransform = any[0]
        if(songListTransform is SongListTransform){
            songListName1.text = songListTransform.name1
            songListName2.text = songListTransform.name2
            songListAuthor1.text = songListTransform.creator1
            songListAuthor2.text = songListTransform.creator2
            Log.d("aaa",songListTransform.pic1)
            GlideUtil.setImage(songListTransform.pic1,songListImage1,context)
            GlideUtil.setImage(songListTransform.pic2,songListImage2,context)

            val bundle1 = Bundle()
            bundle1.putString("id",songListTransform.id1)
            bundle1.putString("author",songListTransform.creator1)
            songListItem1.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.fragmentQQSingleSongList,bundle1))

            val bundle2 = Bundle()
            bundle2.putString("id",songListTransform.id2)
            bundle2.putString("author",songListTransform.creator2)
            songListItem2.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.fragmentQQSingleSongList,bundle2))
        }
    }

}