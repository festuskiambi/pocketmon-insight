pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PocketMon Insight"
include(":app")
include(":feature:pokemon:ui")

include(":feature:pokemon:domain")
include(":feature:pokemon_info:data")
include(":feature:pokemon_info:ui")
include(":feature:pokemon_info:domain")
include(":core:network")
include(":core:common")
include(":core:feature_api")
include(":feature:pokemon_list")
