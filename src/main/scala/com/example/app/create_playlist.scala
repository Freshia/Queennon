package com.example.app

import com.example.app.model._
import org.scalatra._

import scalaj.http.Http
import scalaj.http._

class create_playlist(keys: collection.mutable.Map[Integer, String],similar_tracks_ids: collection.mutable.Map[Integer, String]) extends ScalatraServlet {

   get("/") {
     val playlist_name = params.get("playlist_name").map(_.toString).getOrElse("");
     val access_token = keys.get(0).map(_.toString).getOrElse("");
    
    if(!playlist_name.isEmpty){
        var creator = new new_playlist_creator();
        //check for user_id error here
        val user_id = creator.get_user_id(access_token);
        //check for response here as well
        val playlist_id = creator.new_playlist(user_id, playlist_name, access_token);
        //check response code!!! then....
        val populator =  new populate_playlist();
        //check for error here as well
        populator.populate(playlist_id,access_token,similar_tracks_ids);

    }
    else{
        //error to enter id
    }
   }
   

}