package com.example

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSName, ScalaJSDefined}

@js.native
object GlobalScope extends js.GlobalScope {

  def system: SystemJSNative = js.native

}

@ScalaJSDefined
@JSName("system")
trait SystemJSNative extends js.Object {

  val env: js.Dictionary[String]
}

object JsSystem {
  val env: Map[String, String] =
    GlobalScope.system.env.toMap
}
