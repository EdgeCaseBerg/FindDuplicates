import scalariform.formatter.preferences._

organization := "com.github.edgecaseberg"

name := "duplicate-finder"

version := "0.0.0" 

scalaVersion := "2.11.7"

resolvers ++= Seq(
	"Sonatype Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots/")

libraryDependencies ++= { 
	Seq(
		"org.scalatest" % "scalatest_2.11" % "2.2.4" % "test"
	)
}

scalariformPreferences := scalariformPreferences.value
  .setPreference(DoubleIndentClassDeclaration, true)
  .setPreference(PreserveDanglingCloseParenthesis, true)
  .setPreference(AlignParameters, false)
  .setPreference(IndentWithTabs, true)
  .setPreference(MultilineScaladocCommentsStartOnFirstLine, true)
