package com.example

import com.example.domain.User
import org.scalatest.{FreeSpec, Matchers}

class UserTest extends FreeSpec with Matchers {

  "User" - {
    "should have the original name" in {
      User("Joe", "Smith").name shouldEqual "Joe"
    }

    "should throw exception if last name is empty" in {
      intercept[IllegalArgumentException] {
        User("Hmm", "")
      }
    }
  }
}