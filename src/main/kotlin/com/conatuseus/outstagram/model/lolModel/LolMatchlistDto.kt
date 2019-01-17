package com.conatuseus.outstagram.model.lolModel

import com.google.gson.annotations.SerializedName

data class LolMatchlistDto(@SerializedName("lane") val lane:String,
                    @SerializedName("gameId") val gameId:Long,
                    @SerializedName("champion") val champion:Int,
                    @SerializedName("platformId") val platformId:String,
                    @SerializedName("timestamp") val timestamp:Long,
                    @SerializedName("queue") val queue:Int,
                    @SerializedName("role") val role:String,
                    @SerializedName("season") val season:Int)