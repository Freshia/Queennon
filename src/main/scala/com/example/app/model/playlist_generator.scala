package com.example.app.model

import scalaj.http.Http
import scalaj.http._

import ujson._

class playlist_generator{

    def get_similar_tracks(items :collection.mutable.Map[Integer, String], access_token: String): collection.mutable.Map[Integer, String] = {
        val track_ids = collection.mutable.Map[Integer, String]()
        for(i<-0 until items.size){
        //request for similar
            val response = Http("https://api.spotify.com/v1/recommendations?limit=1&seed_tracks="+items(i)).headers(Seq("Authorization" -> ("Bearer " + access_token))).asString.body
            val json = ujson.read(response)
            val recommended_items = json("tracks").arr
            val id = ujson.read(recommended_items(0)).obj("id").str
            println(id)
            track_ids.put(i, id);
        }
        return track_ids;
    }

}