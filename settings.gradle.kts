rootProject.name = "huehnerlady-pact-demo"
include(
  "consumer-working-pact-contracttests",
    // "provider"
)

fun Settings.property(key: String): String =
  javaClass.getMethod("getProperty", String::class.java).invoke(this, key) as String

fun Settings.hasProperty(key: String): Boolean =
  javaClass.getMethod("hasProperty", String::class.java).invoke(this, key) as Boolean

operator fun Settings.get(key: String) = if (hasProperty(key)) property(key) else null

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

// buildCache {

//   val buildCacheUsername = System.getenv()["GRADLE_BUILD_CACHE_USERNAME"] ?: settings["gradle.build.cache.username"] ?: ""
//   val buildCachePassword = System.getenv()["GRADLE_BUILD_CACHE_PASSWORD"] ?: settings["gradle.build.cache.password"] ?: ""

//   val isCiServer = System.getenv().containsKey("CI")
//   val buildCacheEnabled = System.getenv().getOrDefault("GRADLE_BUILD_CACHE_ENABLED", "false")!!.toBoolean()
//   val buildCacheUri = System.getenv().getOrDefault("GRADLE_BUILD_CACHE_URI", "https://gradle-cache.pku-tools.aws.europace.de")
//   local {
//     isEnabled = !isCiServer
//   }
//   remote<HttpBuildCache> {
//     url = uri("${buildCacheUri}/cache/")
//     isEnabled = true
//     isPush = isCiServer && buildCacheEnabled

//     // see in AWS Devops Account
//     // https://eu-central-1.console.aws.amazon.com/systems-manager/parameters/?region=eu-central-1&tab=Table#list_parameter_filters=Path:Recursive:%2Fmisc%2Fgradle-build-cache%2Fcredentials
//     if (buildCacheUsername.isNotBlank()) {
//       credentials {
//         username = buildCacheUsername
//         password = buildCachePassword
//       }
//     }
//   }
// }
