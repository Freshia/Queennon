package com.example.app.model

import scalaj.http.Http
import scalaj.http._

import ujson._

class playlist_retriever{

    def get_tracks(playlist_id:String, access_token: String): collection.mutable.Map[Integer, String] = {
        
        println("Token")
        println(access_token)
        val response = Http("https://api.spotify.com/v1/playlists/"+playlist_id + "/tracks").headers(Seq("Authorization" -> ("Bearer " + access_token))).asString.body
        print(response);
        val json = ujson.read(response)
        val playlist_items = json("items").arr.toArray

        val track_keys: collection.mutable.Map[Integer, String] = extract_track_keys(playlist_items);
        
        var generator = new playlist_generator();
        val similar_tracks: collection.mutable.Map[Integer, String] = generator.get_similar_tracks(track_keys, access_token);
        return similar_tracks;

    }
    def extract_track_keys(items:Array[ujson.Value]): collection.mutable.Map[Integer, String] = {
        val track_ids = collection.mutable.Map[Integer, String]()
        for(i<-0 until items.length){
            var id = ujson.read(items(i))("track").obj("id").str;
            track_ids.put(i, id);
        }
        return track_ids;
    }
}