package com.conatuseus.outstagram.model.lolModel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class LolSpectator(@SerializedName("gameId") val gameId:Long,
                        @SerializedName("gameStartTime") val gameStart:Long,
                        @SerializedName("platformId") val platformId:String,
                        @SerializedName("gameMode") val gameMode:String,
                        @SerializedName("mapId") val mapId:Long,
                        @SerializedName("gameType") val gameType:String,
                        @SerializedName("bannedChampions") val bannedChampions:List<BannedChampion>,
                        @SerializedName("participants") val participants:List<CurrentGameParticipant>,
                        @SerializedName("gameLength") val gameLength:Long
                        )