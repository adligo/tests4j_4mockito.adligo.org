import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
  `maven-publish`
  eclipse
  java
  signing
}

sourceSets {
  main {
    java {
      srcDirs("src")
    }
  }
}

fun getProp(key: String, default: String): String {
  var r : String = default
  if (project.hasProperty(key)) {
    r = project.getProperties().get(key) as String
  }
  return r
}

fun getTag(): String {
  val current = LocalDateTime.now()
  val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss")
  val snapshot = "SNAPSHOT_" + current.format(formatter)
  //println(snapshot)
  return getProp("tag", snapshot)
}

// gradle publishToMavenLocal 
// or with the git tag
//  gradle publishToMavenLocal -Ptag=vg0_1 
publishing {
  publications {
    create<MavenPublication>("maven") {
      groupId = "org.adligo"
      artifactId = "tests4j_4mockito"
      version = getTag()
      from(components["java"])
    }
  }
}


repositories {
  mavenLocal()
  mavenCentral()
}

/**
I have found that the JAVA_HOME environment variable that is set when your run this task ;
    gradle cleanEclipse eclipse
is the one that is included in the Eclipse BuildPath
*/
tasks.register<GradleBuild>("ecp") {
    tasks = listOf("cleanEclipseClasspath", "eclipseClasspath")
}