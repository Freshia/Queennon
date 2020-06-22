package com.example.app

import com.example.app.model._
import org.scalatra._

import scalaj.http.Http
import scalaj.http._

class auth_playlist(keys: collection.mutable.Map[Integer, String],similar_tracks_ids: collection.mutable.Map[Integer, String]) extends ScalatraServlet {

   get("/") {
     val playlist_id = params.get("playlist_id").map(_.toString).getOrElse("");
     val access_token = keys.get(0).map(_.toString).getOrElse("");
    
    if(!playlist_id.isEmpty){
        var retriever = new playlist_retriever();
        val similar_tracks:collection.mutable.Map[Integer, String] = retriever.get_tracks(playlist_id, access_token);

        similar_tracks_ids ++= similar_tracks;
        
        if(similar_tracks.size!=0){
            views.html.playlist_name_form()
        }
        else{
            ///put separate error here
            views.html.auth_error()
        }

    }
    else{
        //error to enter id
    }
   }
   

}