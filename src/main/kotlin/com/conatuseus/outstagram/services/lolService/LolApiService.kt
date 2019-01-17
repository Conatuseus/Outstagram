package com.conatuseus.outstagram.services.lolService

import com.conatuseus.outstagram.model.lolModel.LolMatch
import com.conatuseus.outstagram.model.lolModel.LolSummoner
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface LolApiService{

    @GET("lol/summoner/v4/summoners/by-name/{lolUserName}")
    fun getUserInfo(@Path("lolUserName") lolUserName:String,
                    @Query("api_key") lolApiKey:String):Call<LolSummoner>


    @GET("lol/match/v4/matchlists/by-account/{encryptedAccountId}")
    fun getUserMatches(@Path("encryptedAccountId") lolUserAccountId:String,
                       @Query("api_key") lolApiKey: String):Call<LolMatch>

}