plugins {
    kotlin("multiplatform")
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    commonMainImplementation(project(":Curl"))
}

kotlin {

    linuxX64 {
        binaries {
            executable {
                baseName = "curluser.exe"
                entryPoint = "curluser.main"
            }
        }
    }

    sourceSets {
        val linuxX64Main by getting
    }
}
