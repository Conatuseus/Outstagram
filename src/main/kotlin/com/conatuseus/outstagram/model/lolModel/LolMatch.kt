package com.conatuseus.outstagram.model.lolModel

import com.google.gson.annotations.SerializedName

data class LolMatch(@SerializedName("matches") val matches:List<LolMatchlistDto>,
                    @SerializedName("endIndex") val endIndex:Int,
                    @SerializedName("startIndex") val startIndex:Int,
                    @SerializedName("totalGames") val totalGames:Int)