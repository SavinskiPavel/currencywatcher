plugins {
    id("spring-lib-conventions")
}

dependencies {
    implementation(deps.ExternalDeps.Spring.Bom.springBoot)
    implementation(deps.ExternalDeps.sl4jApi)
}
