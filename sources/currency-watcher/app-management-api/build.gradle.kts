import deps.ExternalDeps.Spring.Bom.*
import deps.ExternalDeps.postgresql
import deps.ProjectDeps.cmnException
import deps.ProjectDeps.cmnPersistence

plugins {
    id("spring-app-conventions")
}

dependencies {

    implementation(project(cmnPersistence))
    implementation(project(cmnException))
    implementation(starterWeb)
    implementation(starterDataJpa)
    implementation(postgresql)
    implementation(flywayCore)
}