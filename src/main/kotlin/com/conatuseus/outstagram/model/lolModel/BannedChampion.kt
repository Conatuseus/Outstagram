package com.conatuseus.outstagram.model.lolModel

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.google.gson.annotations.SerializedName

@JsonIgnoreProperties(ignoreUnknown = true)
data class BannedChampion(@SerializedName("teamId") val teamId:Long,
                          @SerializedName("championId") val championId:Long)