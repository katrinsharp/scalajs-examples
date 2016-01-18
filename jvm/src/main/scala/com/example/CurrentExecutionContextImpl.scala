package com.example

object CurrentExecutionContextImpl extends CustomExecutionContext {

  override val runsAsync = scala.concurrent.ExecutionContext.Implicits.global

}
