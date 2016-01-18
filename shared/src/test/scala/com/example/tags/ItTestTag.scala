package com.example.tags

import org.scalatest.{Suite, Tag}

class ItTestTag

object ItTestTag extends Tag("com.example.tags.ItTestTag")

trait SuiteWithItTest extends Suite {

  // must be lazy otherwise the map will be empty
  override lazy val tags: Map[String, Set[String]] = {
    super.tags ++ testNames.map { testName =>
        testName -> super.tags.get(testName).fold(Set(ItTestTag.name))(_ + ItTestTag.name)
    }
  }

}
