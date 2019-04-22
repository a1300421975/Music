package com.example.music.utils

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

object GsonUtil{

    inline fun <reified T:Any> gsonUtil(byteArray:ByteArray, callBack:(t:T) ->Unit){
        val types = object : TypeToken<T>(){}.type
        callBack(Gson().fromJson<T>(String(byteArray),types))
    }
}