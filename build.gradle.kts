plugins {
    java
}

group = "co.com.sofka"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.9.1"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("io.cucumber:cucumber-junit:7.17.0")
    implementation("io.cucumber:cucumber-java:7.17.0")
    implementation("org.seleniumhq.selenium:selenium-java:4.20.0")
    implementation("com.github.javafaker:javafaker:1.0.2")

}

tasks.test {
    useJUnitPlatform()
}
