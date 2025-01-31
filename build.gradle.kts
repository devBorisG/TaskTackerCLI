plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "boris.enterprice"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    //Testing
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core:5.0.0")
    testImplementation("org.mockito:mockito-junit-jupiter:5.0.0")
    testImplementation("org.assertj:assertj-core:3.24.2")

    //Application
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.15.2")
    implementation("com.fasterxml.jackson.core:jackson-core:2.15.2")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar> {
    archiveClassifier.set("")
    manifest {
        attributes["Main-Class"] = "boris.enterprice.infrastructure.Main"
    }
}