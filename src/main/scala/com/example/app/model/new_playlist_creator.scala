package com.example.app.model

import scalaj.http.Http
import scalaj.http._

import ujson._

class new_playlist_creator{

    def get_user_id(access_token: String): String = {
        //
        val response = Http("https://api.spotify.com/v1/me").headers(Seq("Authorization" -> ("Bearer " + access_token))).asString.body
        print(response);
        val json = ujson.read(response)
        val user_id = json.obj("id").str;
        println("user_id");
        print(user_id);
        return user_id;
    }
    def new_playlist(user_id :String, playlist_name: String, access_token:String):String = {
        var playlist_id = "";
        if(user_id!=""){
            val response = Http("https://api.spotify.com/v1/users/"+user_id + "/playlists")
        .headers(Seq("Authorization" -> ("Bearer " + access_token),"content-Type" -> "application/json"))
        .postData("""{"name":""""+playlist_name+"""","public":"true"}""").option(HttpOptions.readTimeout(10000)).asString.body
       
        println(response);
        val json = ujson.read(response)
        playlist_id = json("id").str
        
        }
        else{
            //error stuff....
        }
        return playlist_id;

    }
    
}