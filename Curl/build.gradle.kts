plugins {
    kotlin("multiplatform")
}

repositories {
    google()
    mavenCentral()
}


kotlin {
    linuxX64 {
        compilations["main"].cinterops {
            val curl by creating {
                defFile(project.file("curl.def"))
            }
        }

        binaries {
            staticLib { }
        }
    }

    sourceSets {
        val nativeMain by creating
        val linuxX64Main by getting
        linuxX64Main.dependsOn(nativeMain)
    }
}
