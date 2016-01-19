package com.example

import org.scalatest.{Matchers, FreeSpec}


class JsSystemTest extends FreeSpec with Matchers {

  "JsSystem" - {

    "should have var1 and var2" in {

      JsSystem.env.keys.toSeq shouldEqual Seq("var1", "var2")
    }
  }
}
