plugins {
    id("org.openrewrite.build.recipe-library") version ("latest.release")
}

group = "com.demo"
version = "0.0.1-SNAPSHOT"

tasks.named<JavaCompile>("compileJava") {
    options.release.set(8)
}

val latest = "latest.integration"
dependencies {
    implementation(platform("org.openrewrite.recipe:rewrite-recipe-bom:$latest"))
    implementation("org.openrewrite:rewrite-java")

    runtimeOnly("org.openrewrite:rewrite-java-17")
    runtimeOnly("ch.qos.logback:logback-classic:1.2.+")

    // Refaster style recipes need the rewrite-templating annotation processor and dependency for generated recipes
    // https://github.com/openrewrite/rewrite-templating/releases
    annotationProcessor("org.openrewrite:rewrite-templating:$latest")
    implementation("org.openrewrite:rewrite-templating")
    // The `@BeforeTemplate` and `@AfterTemplate` annotations are needed for refaster style recipes
    compileOnly("com.google.errorprone:error_prone_core:2.19.1") {
        exclude("com.google.auto.service", "auto-service-annotations")
    }
    implementation(fileTree(mapOf("dir" to "src/main/resources/META-INF/rewrite/classpath", "include" to listOf("*.jar"))))

    testImplementation("org.openrewrite.gradle.tooling:model:$latest")
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.openrewrite:rewrite-test")
    testRuntimeOnly(gradleApi())
}

recipeDependencies {
    parserClasspath("com.demo:demo:1.0")
    parserClasspath("com.demo:demo:2.0")
}

tasks.test {
    useJUnitPlatform()
}

license {
    ignoreFailures = true
}

signing {
    isRequired = false
}
