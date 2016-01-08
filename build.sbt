name := """ISIDRO"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

scalacOptions ++= Seq("-feature", "-deprecation", "-unchecked", "-language:reflectiveCalls", "-language:postfixOps", "-language:implicitConversions")

resolvers ++= Seq(
	"Scalaz Bintray Repo" at "https://dl.bintray.com/scalaz/releases",
	"Atlassian Releases" at "https://maven.atlassian.com/public/",
	Resolver.sonatypeRepo("snapshots")
)

routesGenerator := InjectedRoutesGenerator

includeFilter in (Assets, LessKeys.less) := "*.less"

excludeFilter in (Assets, LessKeys.less) := "_*.less"

pipelineStages := Seq(rjs, digest, gzip)

RjsKeys.mainModule := "main"

doc in Compile <<= target.map(_ / "none")


libraryDependencies ++= Seq(
  cache,
  ws,
  specs2 % Test,
  "org.webjars" %% "webjars-play" % "2.4.0",
  "com.typesafe.play" %% "play-slick" % "1.1.1",
  "com.typesafe.play" %% "play-slick-evolutions" % "1.1.1",
  "mysql" % "mysql-connector-java" % "5.1.34",
  "org.webjars" % "requirejs" % "2.1.19",
  "com.mohiva" %% "play-silhouette" % "3.0.0",
  "com.adrianhurt" %% "play-bootstrap3" % "0.4.4-P24",	// Add bootstrap3 helpers and field constructors (http://play-bootstrap3.herokuapp.com/)
  "com.typesafe.play" %% "play-mailer" % "3.0.1",
  "net.codingwell" %% "scala-guice" % "4.0.0",  // ??
  "net.ceedubs" %% "ficus" % "1.1.2",  // ??
  "com.mohiva" %% "play-silhouette-testkit" % "3.0.0" % "test", // ??
  filters
)

fork in run := true
