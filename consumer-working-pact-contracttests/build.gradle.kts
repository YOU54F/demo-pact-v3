dependencies {
  implementation(libs.bundles.groovy)

  implementation(libs.bundles.springBoot)
  implementation(libs.springBootValidation)
  implementation(libs.bundles.spring)
  testImplementation(libs.bundles.springTest)
  testRuntimeOnly(libs.byteBuddy)
  testRuntimeOnly(libs.objenesis)

  testImplementation(libs.groovyCore)

  testImplementation(libs.springSecurityCore)
  testImplementation(libs.commonsLang)

  // testImplementation("au.com.dius.pact.consumer:junit5:4.1.34")
  testImplementation("au.com.dius.pact.consumer:junit5:4.6.3")
  testImplementation(libs.bundles.junitJupiter)
  testImplementation(libs.bundles.mockito)
  testImplementation(libs.assertj)


  implementation(libs.slf4jApi)
  runtimeOnly(libs.bundles.logging)
}

tasks {
  withType<Test> {
    useJUnitPlatform()
    systemProperty("pact_do_not_track", true)
    systemProperty("pact.rootDir", "$rootDir/pacts/")
  }
}
