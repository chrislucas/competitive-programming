plugins {
    id("java")
    kotlin("jvm") version "1.8.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {

    implementation ("org.jetbrains.kotlinx:kotlin-deeplearning-tensorflow:0.5.2")


    // Running KotlinDL on GPU
    implementation ("org.tensorflow:libtensorflow:1.15.0")
    implementation ("org.tensorflow:libtensorflow_jni_gpu:1.15.0")

    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation(kotlin("stdlib-jdk8"))
}

tasks.test {
    useJUnitPlatform()
}

sourceSets.main {
    java.srcDirs("src/main/java", "src/main/kotlin")
}
kotlin {
    jvmToolchain(11)
}