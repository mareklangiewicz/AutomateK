plugins {
    id("org.jetbrains.intellij.platform") version "2.16.0"
    kotlin("jvm") version "2.4.0"
}

// FIXME: I just bumped some versions, etc. drive-by style,
// but this project/experiment is really old and broken.
// needs proper update/refactor/redesign/or sth.

group = "pl.mareklangiewicz"
version = "1.2-SNAPSHOT"

repositories {
    mavenCentral()
    intellijPlatform {
        defaultRepositories()
    }
}

dependencies {
    implementation(kotlin("stdlib-jdk8"))
}

// https://plugins.jetbrains.com/docs/intellij/creating-plugin-project.html
intellijPlatform {
  pluginConfiguration {
    ideaVersion {
      sinceBuild = "252"
    }

    changeNotes = """
      Initial version
    """.trimIndent()
  }
}


tasks {
  // Set the JVM compatibility versions
  withType<JavaCompile> {
    sourceCompatibility = "23"
    targetCompatibility = "23"
  }
  withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
    kotlinOptions.jvmTarget = "23"
  }
}

