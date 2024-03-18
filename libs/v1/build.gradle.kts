plugins {
    `java-library`
    `maven-publish`
}

group="com.demo"
version="1.0"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(8)
    }
    withJavadocJar()
    withSourcesJar()
}

publishing {
    publications {
        create<MavenPublication>("mavenV1") {
            groupId = "com.demo"
            artifactId = "demo"
            version = "1.0"

            from(components["java"])
        }
    }
}
