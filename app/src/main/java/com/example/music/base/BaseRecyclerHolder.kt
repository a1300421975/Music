package com.example.music.base

import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseRecyclerHolder(view:View):RecyclerView.ViewHolder(view){

    protected val context = view.context

    abstract fun bind(vararg any: Any)

}