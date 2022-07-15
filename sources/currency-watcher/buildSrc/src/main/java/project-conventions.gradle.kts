import deps.ExternalDeps.findBugs

plugins {
    `java-library`
}

dependencies {

    implementation(findBugs)
}