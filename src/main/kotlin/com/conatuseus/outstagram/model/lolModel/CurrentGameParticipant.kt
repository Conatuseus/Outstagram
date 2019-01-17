package com.conatuseus.outstagram.model.lolModel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName


@JsonIgnoreProperties(ignoreUnknown = true)
data class CurrentGameParticipant(@SerializedName("profileIconId") val profileIconId:Long,
                                  @SerializedName("championId") val championId:Long,
                                  @SerializedName("summonerName") val summonerName:String,
                                  @SerializedName("spell1Id") val spell1Id:Long,
                                  @SerializedName("spell2Id") val spell2Id:Long,
                                  @SerializedName("summonerId") val summonerId:String
                                  )