package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolUserInfo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


//var lolAddress="https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/$lolUserId?api_key=$lolApiKey"
// https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/maldive?api_key=RGAPI-1600ca23-2159-4a26-a68d-28fb37028014
class LolUserDAO(val lolUserId:String, val lolApiKey:String){
    val baseURL="https://kr.api.riotgames.com/"


    fun testRetrofit(): LolUserInfo{
        val retrofit:Retrofit=Retrofit.Builder()
                .baseUrl(baseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val service= retrofit.create(LolApiService::class.java)
        val request=service.getUserInfo(lolUserId,lolApiKey)
        class CallBackKt<T>: Callback<T> {

            var onResponse: ((Response<T>) -> Unit)? = null
            var onFailure: ((t: Throwable?) -> Unit)? = null

            override fun onFailure(call: Call<T>, t: Throwable) {
                onFailure?.invoke(t)
            }

            override fun onResponse(call: Call<T>, response: Response<T>) {
                onResponse?.invoke(response)
            }

        }
        fun<T> Call<T>.enqueue(callback: CallBackKt<T>.() -> Unit) {
            val callBackKt = CallBackKt<T>()
            callback.invoke(callBackKt)
            this.enqueue(callBackKt)
        }
        request.enqueue {

            onResponse = {

            }

            onFailure = {
                // do
            }

        }
        //return LolUserInfo(1,"a","a",1,2,"a","a")
        //임시.
        return request.execute().body()!!
    }

}