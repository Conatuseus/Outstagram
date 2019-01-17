package com.conatuseus.outstagram.model.lolModel

import com.google.gson.annotations.SerializedName

data class LolSummoner(@SerializedName("profileIconId") val profileIconId:Int,
                       @SerializedName("name") val name:String,
                       @SerializedName("puuid") val puuid:String,
                       @SerializedName("summonerLevel")val summonerLevel:Long,
                       @SerializedName("revisionDate") val revisionDate:Long,
                       @SerializedName("id") val id:String,
                       @SerializedName("accountId") val accountId:String
                       )
