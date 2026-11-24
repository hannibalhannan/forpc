import org.jetbrains.compose.desktop.application.dsl.TargetFormat

plugins {
    kotlin("jvm") version "2.1.0"
    id("org.jetbrains.kotlin.plugin.compose") version "2.1.0"
    id("org.jetbrains.compose") version "1.7.3"
}

repositories { google(); mavenCentral(); maven("https://maven.pkg.jetbrains.space/public/p/compose/dev") }

dependencies {
    implementation(compose.desktop.currentOs)
    implementation(compose.material3)
}

kotlin { jvmToolchain(17) }

compose.desktop {
    application {
        mainClass = "app.MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Msi, TargetFormat.Exe)
            packageName = "ArchiveTuneDesktop"
            packageVersion = "1.0.0"
            windows { menuGroup = "ArchiveTune"; upgradeUuid = "b1f2c3d4-0000-4000-8000-a1b2c3d4e5f6" }
        }
    }
}
