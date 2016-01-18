import org.scalajs.sbtplugin.ScalaJSPlugin.autoImport._
import sbt._

object Dependencies {

  val scalajsdom = Def.setting("org.scala-js" %%% "scalajs-dom" % "0.8.2")

  object tests {
    val scalajsenvs = "org.scala-js" %% "scalajs-js-envs" % scalaJSVersion % "test"
  }

}
