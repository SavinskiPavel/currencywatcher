group = "com.example.currencywatcher"
version = "0.0.1"

plugins {
    id("io.freefair.lombok") version "6.5.0.2"
    id("io.spring.dependency-management")
}

subprojects {

    group = rootProject.group
    version = rootProject.version

    apply {

        plugin("io.freefair.lombok")
        plugin("io.spring.dependency-management")
        plugin("project-conventions")

        repositories {
            mavenCentral()
        }
    }
}