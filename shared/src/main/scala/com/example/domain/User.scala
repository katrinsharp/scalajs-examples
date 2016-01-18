package com.example.domain

case class User(name: String, lastName: String) {

  require(!name.isEmpty, "Name can't be empty")
  require(!lastName.isEmpty, "Last name can't be empty")
}
