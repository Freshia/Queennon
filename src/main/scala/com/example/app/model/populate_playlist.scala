package com.example.app.model

import scalaj.http.Http
import scalaj.http._

import scala.util.parsing.json._

import ujson._

class populate_playlist{
    def populate(playlist_id: String, access_token: String, similar_tracks_ids: collection.mutable.Map[Integer, String]){
           
           var track_array:String="["
            for(i<-0 until similar_tracks_ids.size){
                if(i!=similar_tracks_ids.size-1){
                    track_array = track_array + """"spotify:track:""" + similar_tracks_ids.get(i).map(_.toString).getOrElse("")+"""",""";
                }
                else{
                    track_array = track_array + """"spotify:track:""" + similar_tracks_ids.get(i).map(_.toString).getOrElse("")+""""""";

                }
            }
            track_array = track_array + "]"
          println("""{"uris":""""+track_array+""""}""");
        val response = Http("https://api.spotify.com/v1/playlists/"+playlist_id + "/tracks")
                        .postData("""{"uris":"""+track_array+"""}""")
                        .header("content-type", "application/json").headers(Seq("Authorization" -> ("Bearer " + access_token)))
                        .option(HttpOptions.readTimeout(10000)).asString.body
        println(response)
    }
}