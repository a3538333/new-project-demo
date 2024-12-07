plugins {
    id("java")
    // https://plugins.gradle.org/plugin/org.jetbrains.kotlin.jvm
    id("org.jetbrains.kotlin.jvm") version "1.9.22"
    // https://plugins.gradle.org/plugin/org.jetbrains.intellij#groovy-usag
    id("org.jetbrains.intellij") version "1.17.3"
}

group = "com.lovecaa"
version = "2.0.0"

allprojects {
    repositories {
        mavenLocal()
        maven("https://maven.aliyun.com/repository/public/")
        maven("https://plugins.jetbrains.com/maven")
        mavenCentral()
    }
}


dependencies {
    implementation("cn.hutool:hutool-json:5.8.33")
    implementation("cn.hutool:hutool-crypto:5.8.33")
    implementation("org.apache.httpcomponents.client5:httpclient5:5.4")
    implementation("org.bouncycastle:bcprov-jdk15to18:1.79")
    implementation("org.java-websocket:Java-WebSocket:1.5.7") {
        exclude(group = "org.slf4j")
    }
}


// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    downloadSources.set(false)
//    version.set("2023.3")
//    version.set("2024.1")
    version.set("2024.3")
    // Target IDE Platform
    type.set("PC")
    plugins.set(listOf("PythonCore", "org.intellij.plugins.markdown"))
}


tasks {

    // Set the JVM compatibility versions
    withType<JavaCompile> {
        options.encoding = "UTF-8"
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }

    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        // 插件支持的最低版本
        sinceBuild.set("222")
        // 插件支持的最高版本，不写意味着可以支持之后的所有版本
        untilBuild.set("999")
    }

    signPlugin {
        certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
        privateKey.set(System.getenv("PRIVATE_KEY"))
        password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
    }

    publishPlugin {
        token.set(System.getenv("PUBLISH_TOKEN"))
    }
}

