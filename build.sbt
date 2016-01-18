import org.scalajs.sbtplugin.ScalaJSPluginInternal

name := "Example project"

lazy val root = project.in(file(".")).
  aggregate(crossJS, crossJVM).
  settings(
    publish := {},
    publishLocal := {}
  )

lazy val cross = crossProject.in(file(".")).
  settings(
    name := "example",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.11.7",
    libraryDependencies ++= Seq(
      "org.scalatest" %%% "scalatest" % "3.0.0-M15" % "test"
    )
  )
  .jvmSettings(
    // Add JVM-specific settings here
  )
  .jsSettings(
    libraryDependencies ++= Seq(
      Dependencies.scalajsdom.value,
      Dependencies.tests.scalajsenvs
    )
  )
  .configs(TestSettings.ItTest) // 1
  .settings(inConfig(Test)(TestSettings.testSettings):_*) // 2
  .settings(inConfig(TestSettings.ItTest)(Defaults.testTasks):_*) // 3
  .jsSettings(inConfig(TestSettings.ItTest)(ScalaJSPluginInternal.scalaJSTestSettings):_*) // 4
  .settings(inConfig(TestSettings.ItTest)(TestSettings.itTestSettings):_*) // 5
  .jsSettings(
    unmanagedSourceDirectories in TestSettings.ItTest ++=
      CrossType.Full.sharedSrcDir(baseDirectory.value, "test").toSeq :+
        CrossType.Full.jsDir(baseDirectory.value).getParentFile / "src" / "test" / "scala") // 6

lazy val crossJVM = cross.jvm
lazy val crossJS = cross.js