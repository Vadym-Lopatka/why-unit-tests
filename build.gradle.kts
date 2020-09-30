import io.spring.gradle.dependencymanagement.dsl.DependencyManagementExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.3.4.RELEASE"
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("jvm") version "1.4.10"
	kotlin("plugin.spring") version "1.4.10"
}

group = "com.vlopatka"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.springframework.boot:spring-boot-starter-actuator")
	implementation("org.springframework.boot:spring-boot-starter-jetty")
	implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
//	implementation("org.springframework.cloud:spring-cloud-starter-zipkin")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation ("org.springframework.cloud:spring-cloud-starter-stream-kafka")
	implementation("org.springframework.cloud:spring-cloud-stream-schema:2.2.1.RELEASE")

	implementation("javax.transaction:javax.transaction-api")
	implementation("org.hibernate:hibernate-entitymanager")
	implementation("org.hibernate.validator:hibernate-validator")
	implementation("org.flywaydb:flyway-core:5.2.4")
	implementation("org.postgresql:postgresql")

	implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.9.9")
//	implementation ("io.springfox:springfox-bean-validators:2.9.2")
//	implementation("io.confluent:kafka-avro-serializer:3.3.0")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(module = "junit")
		exclude(module = "org.mockito") // use mockk
	}
	testImplementation ("org.springframework.cloud:spring-cloud-stream-test-support")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
	testRuntimeOnly("org.junit.vintage:junit-vintage-engine:5.3.1")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-params:5.3.1")
	testImplementation("com.ninja-squad:springmockk:1.1.2")
	testImplementation("org.testcontainers:postgresql:1.10.5")
	testImplementation ("io.mockk:mockk:1.10.0")
	testImplementation ("org.mockito:mockito-inline:3.5.0")
	testImplementation ("org.jetbrains.kotlinx:kotlinx-coroutines-test:1.3.2")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

configure<DependencyManagementExtension> {
	val springCloudVersion = "Hoxton.SR4"
	imports {
		mavenBom("org.springframework.cloud:spring-cloud-dependencies:${springCloudVersion}")
	}
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
