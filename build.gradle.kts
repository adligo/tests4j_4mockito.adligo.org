import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

plugins {
  `maven-publish`
  eclipse
  java
  signing
}

dependencies {
  implementation("javax.xml.bind:jaxb-api:2.4.0-b180830.0359")  
  //an old version of Mockito that uses jdk 1.5 byte code for Apache Beam
  implementation("org.mockito:mockito-all:1.10.19")
  implementation("org.adligo:tests4j:v0_4")
}

java {
  toolchain {
    languageVersion.set(JavaLanguageVersion.of(8))
  }
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