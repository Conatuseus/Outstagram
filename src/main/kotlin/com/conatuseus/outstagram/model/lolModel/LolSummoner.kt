package com.conatuseus.outstagram.model.lolModel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class LolSummoner(@SerializedName("profileIconId") val profileIconId:Int,
                       @SerializedName("name") val name:String,
                       @SerializedName("puuid") val puuid:String,
                       @SerializedName("summonerLevel")val summonerLevel:Long,
                       @SerializedName("id") val id:String,
                       @SerializedName("accountId") val accountId:String
                       )
