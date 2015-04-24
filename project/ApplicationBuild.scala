import sbt._

object ApplicationBuild extends Build {

  val appName = "fileUpload"
  val appVersion = "1.0-SNAPSHOT"

  val appDependencies = Seq()

  val main = Project(appName, file(".")).enablePlugins(play.PlayScala).settings(
    // Add your own project settings here
  )

}
