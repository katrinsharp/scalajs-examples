package com.example

import scala.scalajs.concurrent.JSExecutionContext

object CurrentExecutionContextImpl extends CustomExecutionContext {

  override implicit val runsAsync = JSExecutionContext.Implicits.queue

}