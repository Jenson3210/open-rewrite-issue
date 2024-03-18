plugins {
    `java-library`
    `maven-publish`
}

group="com.demo"
version="2.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
    }
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenV2") {
            groupId = "com.demo"
            artifactId = "demo"
            version = "2.0"

            from(components["java"])
        }
    }
}
