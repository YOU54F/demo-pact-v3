plugins {
  id("org.springframework.boot") version "2.7.17"
  id("io.spring.dependency-management") version "1.1.0"
}


dependencies {
  implementation("org.springframework.boot:spring-boot-starter-web")
  implementation("org.springframework.boot:spring-boot-starter-actuator")
  implementation("org.springframework.boot:spring-boot-starter-validation")

  implementation("org.springframework:spring-beans")
  implementation("org.springframework:spring-context")
  implementation("org.springframework:spring-web")
  implementation("org.springframework:spring-webmvc")

  // testImplementation("au.com.dius.pact.provider:junit5spring:4.2.6")
  testImplementation("au.com.dius.pact.provider:junit5spring:4.6.3")
  testImplementation("org.springframework:spring-test")

  testImplementation("org.junit.jupiter:junit-jupiter-api")
  testImplementation("org.junit.jupiter:junit-jupiter-engine")

  testImplementation("org.mockito:mockito-junit-jupiter")
  testImplementation("org.mockito:mockito-core")
}

tasks {
  withType<Test> {
    // dependsOn(":consumer-working-pact-contracttests:test")
    useJUnitPlatform()
  }
}
