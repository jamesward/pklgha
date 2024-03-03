plugins {
  id("org.pkl-lang") version "0.25.2"
}

val maybeVersion = System.getenv("VERSION")

pkl {
  project {
    packagers {
      register("makePackages") {
        if (maybeVersion != null) {
          environmentVariables.put("VERSION", maybeVersion)
        }
        projectDirectories.from(file("src/"))
      }
    }
  }
  // ./gradlew pkldoc
  if (maybeVersion != null) {
    pkldocGenerators {
      register("pkldoc") {
        sourceModules =
          listOf(uri("package://pkg.pkl-lang.org/github.com/jamesward/pklgha/$maybeVersion"))
      }
    }
  }
}
