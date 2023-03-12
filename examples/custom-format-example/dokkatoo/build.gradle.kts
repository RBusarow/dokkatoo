plugins {
  kotlin("jvm") version "1.7.20"
  id("dev.adamko.dokkatoo") version "0.0.4-SNAPSHOT"
}

dokkatoo {
  moduleName.set("customFormat-example")
  dokkatooPublications.named("html") {
//  dokkatooPublications.configureEach {
    pluginsConfiguration.create("org.jetbrains.dokka.base.DokkaBase") {
      serializationFormat.set(org.jetbrains.dokka.DokkaConfiguration.SerializationFormat.JSON)
      /** Custom format adds a custom logo */
      values.set(
        """
          {
            "customStyleSheets": [
              "${file("logo-styles.css").invariantSeparatorsPath}"
            ],
            "customAssets": [
              "${file("ktor-logo.png").invariantSeparatorsPath}"
            ],
            "footerMessage": "(c) Custom Format Dokka example"
          }
        """.trimIndent()
      )
    }
  }
}
