package com.example

import com.example.domain.UserRepo
import org.scalatest.{AsyncFreeSpec, Matchers}
import scala.concurrent.Future

class UserRepoTest extends AsyncFreeSpec with Matchers {

  "UserRepo" - {
    "given user details should return the correct user" in {

      val name = "Dean"
      val lastName = "Winchester"

      TestUserRepoImpl.user(name, lastName).map(user => {
        user.name shouldEqual name
        user.lastName shouldEqual lastName
      })

    }
    "given empty user name should fail the future" in {

      TestUserRepoImpl.user("", "").failed.map(e => e shouldBe a [Exception])
    }
  }
}

object TestUserRepoImpl extends UserRepo {

  override def fetchUser(name: String, lastName: String): Future[RawUser] = {

    name match {
      case "" =>
        Future.failed {
          new Exception("Invalid username")
        }
      case name =>
        Future.successful {
          RawUser("id", name, lastName)
        }
    }
  }
}
