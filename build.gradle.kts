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
	implementation("org.springframework.cloud:spring-cloud-starter-zipkin")
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	implementation ("org.springframework.cloud:spring-cloud-starter-stream-kafka")
	implementation("org.springframework.cloud:spring-cloud-stream-schema:2.2.1.RELEASE")

	implementation("javax.transaction:javax.transaction-api")
	implementation("org.hibernate:hibernate-entitymanager")
	implementation("org.hibernate.validator:hibernate-validator")
	implementation("org.flywaydb:flyway-core:5.2.4")
	implementation("org.postgresql:postgresql")

	testImplementation("org.springframework.boot:spring-boot-starter-test") {
		exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
