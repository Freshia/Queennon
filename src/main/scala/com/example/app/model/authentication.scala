package com.example.app.model

import scalaj.http.Http
import scalaj.http._

import ujson._

class authentication{

    val myurl:String = "http://localhost:8080/callback";

    def get_access_token(code: String, client_id:String, client_secret:String): String = {
        val result= Http("https://accounts.spotify.com/api/token").postForm(Seq(
            "grant_type"->"authorization_code",
            "code"->   code,
            "redirect_uri"-> myurl,
            "client_secret"->client_secret,
            "client_id"->   client_id)).option(HttpOptions.readTimeout(10000)).asString.body

        val json = ujson.read(result)
        val access_token = json("access_token").str;
        print(result);
        return access_token;
    }
}