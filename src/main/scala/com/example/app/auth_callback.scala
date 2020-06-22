package com.example.app
import com.example.app.model._

import org.scalatra._
import scalaj.http.Http
import scalaj.http._

import ujson._

class auth_callback(keys: collection.mutable.Map[Integer, String], client_id:String, client_secret: String) extends ScalatraServlet {

   get("/") {
     val code = params.get("code")
    
    if(!code.isEmpty){
        val code_string = code.map(_.toString).getOrElse("");
        print(code_string);
        var auth = new authentication();
        val access = auth.get_access_token(code_string, client_id, client_secret);
        if(!access.isEmpty){
            keys.put(0,access);
            views.html.playlist_id_form()
        }
        else{
            views.html.auth_error()
        }
        
    }
    else{
        views.html.auth_error()
    }
   }
  
}