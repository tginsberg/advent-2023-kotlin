/*
 * Copyright (c) 2023 by Todd Ginsberg
 */


plugins {
    kotlin("jvm") version "1.9.21"
}

repositories {
   mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    testImplementation("org.assertj:assertj-core:3.24.2") {
        because("I prefer AssertJ's fluid assertions over JUnit or Hamcrest")
    }
}

kotlin {
    jvmToolchain(17)
}

tasks.test {
    useJUnitPlatform()
}