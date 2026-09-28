import org.jetbrains.kotlin.gradle.dsl.*
import pl.mareklangiewicz.deps.*
import pl.mareklangiewicz.utils.*

plugins {
    id("org.jetbrains.intellij.platform") version "2.19.0" // https://plugins.gradle.org/plugin/org.jetbrains.intellij.platform
    plug(plugs.KotlinJvm)
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
    intellijPlatform {
        intellijIdea("2026.2.3") // https://www.jetbrains.com/idea/download/other.html
    }
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
}

kotlin {
  compilerOptions { jvmTarget = JvmTarget.JVM_23 }
}

