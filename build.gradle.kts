buildscript {
    repositories {
        mavenCentral()
        maven { setUrl("https://packages.confluent.io/maven/") }

    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.0")
        classpath("com.github.jengelman.gradle.plugins:shadow:6.1.0")
    }

}
plugins {
    java
    application
}

apply {
    plugin("java")
    plugin("kotlin")
    plugin("application")
    plugin("com.github.johnrengelman.shadow")
}

application {
    project.setProperty("mainClassName", "uk.tojourn.MainKt")
}

repositories {
    mavenCentral()
    maven { setUrl("https://packages.confluent.io/maven/") }

}

object Versions {
    const val kotlinTest = "4.6.0"
}

dependencies {
    // Kotlin
    implementation("org.jetbrains.kotlin:kotlin-stdlib:1.5.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.5.0")

    // logging
    implementation("io.github.microutils:kotlin-logging-jvm:2.0.6")
    implementation( "org.slf4j:slf4j-simple:1.7.29")

    // JSON serialization
    implementation("com.fasterxml.jackson.core:jackson-databind:2.12.3")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.12.3")

    //DI
    implementation("io.insert-koin:koin-core:2.2.2")

    // Testing
    testImplementation("io.kotest:kotest-runner-junit5:${Versions.kotlinTest}")
    testImplementation("io.kotest:kotest-assertions-core:${Versions.kotlinTest}")
    testImplementation("io.kotest:kotest-property:${Versions.kotlinTest}")
}

