package com.example.app

import org.scalatra._

class home extends ScalatraServlet {

  get("/") {
    views.html.hello()
    
  }

}
