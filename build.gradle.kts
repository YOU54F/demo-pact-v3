buildscript {
  repositories {
    mavenCentral()
    gradlePluginPortal()
  }
}

val javaVersion: JavaVersion = JavaVersion.VERSION_17

subprojects {
  project.apply(plugin = "groovy")
  project.apply(plugin = "maven-publish")

  fun findProperty(s: String) = project.findProperty(s) as String?

  repositories {
    mavenCentral()
  }

  configure<JavaPluginExtension> {
    sourceCompatibility = javaVersion
    targetCompatibility = javaVersion
  }
}
