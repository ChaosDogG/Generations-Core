architectury {
    common("forge", "fabric")
    platformSetupLoomIde()
}

loom {
    silentMojangMappingsLicense()
    accessWidenerPath.set(file("src/main/resources/generationscore.accesswidener"))
}

val minecraftVersion = project.properties["minecraft_version"] as String

sourceSets.main.get().resources.srcDir("src/main/generated/resources")

repositories {
    mavenCentral()
    maven("https://nexus.resourcefulbees.com/repository/maven-public/")
    maven("https://jitpack.io") // BinarySMD
    maven {
        name = "generationsMavenSnapshots"
        url = uri("https://maven.generations.gg/snapshots")
    }
    maven("https://maven.bai.lol")
}

dependencies {
    minecraft("com.mojang:minecraft:${minecraftVersion}")
    mappings(loom.officialMojangMappings())
    // We depend on fabric loader here to use the fabric @Environment annotations and get the mixin dependencies
    // Do NOT use other classes from fabric loader
    modImplementation("net.fabricmc:fabric-loader:${rootProject.properties["fabric_loader_version"]}")
    // Remove the next line if you don't want to depend on the API
    modApi("dev.architectury:architectury:${rootProject.properties["architectury_version"]}")
    modImplementation("earth.terrarium:botarium-common-${minecraftVersion}:${rootProject.properties["botarium_version"]}")

    implementation("gg.generations:RareCandy:${project.properties["rareCandy"]}"){isTransitive = false}
    implementation("org.tukaani:xz:${project.properties["rareCandyXZ"]}")
    implementation("org.apache.commons:commons-compress:${project.properties["rareCandyCommonCompress"]}")
    implementation("de.javagl:jgltf-model:${project.properties["rareCandyJgltfModel"]}")
    implementation("com.github.thecodewarrior:BinarySMD:${project.properties["rareCandyBinarySMD"]}"){isTransitive = false}
    implementation("org.msgpack:msgpack-core:${project.properties["rareCandyMsgPackCore"]}")
    implementation("com.google.flatbuffers:flatbuffers-java:23.3.3")
    modCompileOnly("mcp.mobius.waila:wthit-api:fabric-${project.properties["WTHIT"]}")
}

publishing {
    publications {
        create<MavenPublication>("mavenCommon") {
            artifactId = "${project.properties["archives_base_name"]}" + "-" + rootProject.version
            from(components["java"])
        }
    }

    repositories {
        mavenLocal()
        maven {
            val releasesRepoUrl = "https://maven.generations.gg/releases"
            val snapshotsRepoUrl = "https://maven.generations.gg/snapshots"
            url = uri(if (rootProject.version.toString().endsWith("SNAPSHOT") || rootProject.version.toString().startsWith("0")) snapshotsRepoUrl else releasesRepoUrl)
            name = "Generations-Repo"
            credentials {
                username = project.properties["repoLogin"]?.toString()
                password = project.properties["repoPassword"]?.toString()
            }
        }
    }
}
