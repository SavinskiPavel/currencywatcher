import deps.ExternalDeps.Spring.Bom.*
import deps.ExternalDeps.postgresql
import deps.ProjectDeps.*

plugins {
    id("spring-app-conventions")
}

dependencies {

    implementation(project(cmnPersistence))
    implementation(project(httpClient))
    implementation(project(cmnException))
    implementation(starterWeb)
    implementation(starterDataJpa)
    implementation(postgresql)
}