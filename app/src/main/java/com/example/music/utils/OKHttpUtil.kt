package com.example.music.utils

import okhttp3.*
import java.io.IOException
import java.util.concurrent.TimeUnit

object OKHttpUtil{

    private val okHttpClient = OkHttpClient().newBuilder()
        .connectTimeout(10,TimeUnit.SECONDS)
        .readTimeout(20,TimeUnit.SECONDS)
        .build()

    fun sendRequestWithOKHttp(url_:String, callBack:(byteArray:ByteArray) -> Unit){
        try {
            val request = Request.Builder()
                .url(url_)
                .get()
                .build()
            //Log.d("aaa",request.toString())
            okHttpClient.newCall(request).enqueue(object:Callback{
                override fun onFailure(call: Call, e: IOException) {
                    //Log.d("aaa","aaa")
                    e.printStackTrace()
                }

                override fun onResponse(call: Call, response: Response) {
                    //Log.d("aaa","bbb")
                    callBack(response.body()!!.bytes())
                }
            })
        }catch (e:Exception){
            e.printStackTrace()
        }


    }
}