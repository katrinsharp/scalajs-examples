import org.scalajs.core.tools.io.{MemVirtualJSFile, VirtualJSFile}
import org.scalajs.jsenv.phantomjs.PhantomJSEnv

case class CustomPhantomJSEnv(
  args: Seq[String] = Seq.empty,
  env: Map[String, String] = Map.empty,
  classLoader: ClassLoader)
  extends PhantomJSEnv(
    addArgs = args,
    addEnv = env,
    jettyClassLoader = classLoader) {

  require(env.forall { case (key, value) =>
    !key.contains("'") && !value.contains("'")
  }, "env keys or values should not contain ' - single quotes")

  override protected def customInitFiles(): Seq[VirtualJSFile] = {

    val envString = env.toSeq.map { case (key, value) =>
      s"$key:'$value'"
    }.mkString(",\n")

    new MemVirtualJSFile("init.js").withContent(s"""
      var system = {
        env: {
          $envString
        }
      }
    """) +: super.customInitFiles()
  }

}