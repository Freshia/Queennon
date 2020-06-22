package com.example.app

import org.scalatra.test.scalatest._

class queen_servletTests extends ScalatraFunSuite {

  addServlet(classOf[queen_servlet], "/*")

  test("GET / on queen_servlet should return status 200") {
    get("/") {
      status should equal (200)
    }
  }

}
