plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25"
	id("org.springframework.boot") version "3.3.5-SNAPSHOT"
	id("io.spring.dependency-management") version "1.1.6"

	id("org.springdoc.openapi-gradle-plugin") version "1.8.0"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

repositories {
	mavenCentral()
	maven { url = uri("https://repo.spring.io/snapshot") }
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	developmentOnly("org.springframework.boot:spring-boot-devtools")
	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")

	implementation("io.arrow-kt:arrow-core:1.2.1")
	/**
	 * AssertJ
	 *
	 * URL
	 * - https://assertj.github.io/doc/
	 * MavenCentral
	 * - https://mvnrepository.com/artifact/org.assertj/assertj-core
	 * Main用途
	 * - JUnitでassertThat(xxx).isEqualTo(yyy)みたいな感じで比較時に使う
	 * Sub用途
	 * - 特になし
	 * 概要
	 * - JUnit等を直感的に利用するためのライブラリ
	 */
	testImplementation("org.assertj:assertj-core:3.25.2")

	/**
	 * jqwik
	 *
	 * URL
	 * - https://jqwik.net/
	 * MavenCentral
	 * - https://mvnrepository.com/artifact/net.jqwik/jqwik
	 * - https://mvnrepository.com/artifact/net.jqwik/jqwik-kotlin
	 * Main用途
	 * - Property Based Testing(pbt)
	 * 概要
	 * - Property Based Testingをするのに便利なライブラリ
	 * 参考
	 * - https://medium.com/criteo-engineering/introduction-to-property-based-testing-f5236229d237
	 * - https://johanneslink.net/property-based-testing-in-kotlin/#jqwiks-kotlin-support
	 */
	testImplementation("net.jqwik:jqwik:1.8.2")
	testImplementation("net.jqwik:jqwik-kotlin:1.8.2")

	/**
	 * Spring Boot Starter Validation
	 *
	 * MavenCentral
	 * - https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation
	 * Main用途
	 * - コントローラーのバリデーションのために利用する
	 * Sub用途
	 * - 無し
	 * 概要
	 * - Validation を実装した際に、本ライブラリがなければ、バリデーションが動作しない
	 */
	implementation("org.springframework.boot:spring-boot-starter-validation")

	/**
	 * springdoc の gradle 拡張
	 *
	 * 概要
	 * - CLI から springdoc を利用して OpenAPI を 生成する
	 */
	implementation("org.springdoc:springdoc-openapi-starter-webmvc-ui:2.3.0")

	/**
	 * Spring JDBC
	 *
	 * URL
	 * - https://spring.pleiades.io/spring-framework/docs/current/javadoc-api/org/springframework/jdbc/core/package-summary.html
	 * MavenCentral
	 * - https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-jdbc
	 * Main用途
	 * - DBへ保存
	 * 概要
	 * - 特になし
	 *
	 * これを入れるだけで、application.properties/yamlや@ConfigurationによるDB接続設定が必要になる
	 */
	implementation("org.springframework.boot:spring-boot-starter-jdbc")

	/**
	 * postgresql
	 *
	 * URL
	 * - https://jdbc.postgresql.org/
	 * MavenCentral
	 * - https://mvnrepository.com/artifact/org.postgresql/postgresql
	 * Main用途
	 * - DBつなぐ時のドライバ
	 * 概要
	 * - 特になし
	 */
	implementation("org.postgresql:postgresql")

	/**
	 * Database Rider
	 *
	 * - Rider Core
	 * - Rider Spring
	 * - Rider JUnit 5
	 *
	 * URL
	 * - https://database-rider.github.io/database-rider/
	 * MavenCentral
	 * - https://mvnrepository.com/artifact/com.github.database-rider/rider-core
	 * - https://mvnrepository.com/artifact/com.github.database-rider/rider-spring
	 * - https://mvnrepository.com/artifact/com.github.database-rider/rider-junit5
	 * Main用途
	 * - JUnitでDB周りのテスト時のヘルパー
	 * 概要
	 * - テーブルの事前条件、事後条件を簡潔に設定できる
	 */
	implementation("com.github.database-rider:rider-core:1.41.0")
	implementation("com.github.database-rider:rider-spring:1.41.0")
	testImplementation("com.github.database-rider:rider-junit5:1.41.0")

}

kotlin {
	compilerOptions {
		freeCompilerArgs.addAll("-Xjsr305=strict")
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
