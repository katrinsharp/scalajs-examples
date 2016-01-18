package com.example

object CurrentExecutionContext {

  private val ctx: CustomExecutionContext = CurrentExecutionContextImpl

  val runsAsync: scala.concurrent.ExecutionContext = ctx.runsAsync

  object Implicits {

    implicit val runsAsync: scala.concurrent.ExecutionContext = ctx.runsAsync
  }
}

trait CustomExecutionContext {

  val runsAsync: scala.concurrent.ExecutionContext
}
