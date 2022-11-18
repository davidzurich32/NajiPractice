import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.gradle.api.tasks.testing.logging.TestLogEvent
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.20"
    kotlin("plugin.serialization") version "1.6.20"
    java
}

group = "me.david.tabernero"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
    implementation("org.seleniumhq.selenium:selenium-java:4.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.6.20")
    testImplementation("org.hamcrest:hamcrest:2.2")
    testImplementation("io.rest-assured:kotlin-extensions:5.0.1")
}

tasks.test {
    useJUnitPlatform()
    testLogging {
        events(TestLogEvent.PASSED, TestLogEvent.SKIPPED, TestLogEvent.FAILED)
        exceptionFormat = TestExceptionFormat.SHORT
        showCauses = true
        showExceptions = true
        showStackTraces = true
    }
}

tasks.withType<KotlinCompile>().configureEach {
    kotlinOptions.jvmTarget = "17"
}