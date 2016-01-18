package com.example

import com.example.tags.SuiteWithItTest
import org.scalatest.{Matchers, AsyncFreeSpec}

class CallExternalServerTest extends AsyncFreeSpec with Matchers with SuiteWithItTest {

  "Call external server" - {

    "should be true" in {
      println("Yay, we have IT testing!!")
      true shouldBe true
    }
  }

}
