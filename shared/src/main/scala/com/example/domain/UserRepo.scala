package com.example.domain

import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global

trait UserRepo {

  case class RawUser(id: String, name: String, lastName: String)

  private[example] def fetchUser(name: String, lastName: String): Future[RawUser]

  def user(name: String, lastName: String): Future[User] = {

    fetchUser(name, lastName).map(ru => User(name = ru.name, lastName = ru.lastName))
  }
}
