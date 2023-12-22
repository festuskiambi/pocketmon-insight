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

include(":core:network")
include(":core:common")
include(":core:feature_api")
include(":feature:pokemon_list")
include(":feature:pokemon_info")
