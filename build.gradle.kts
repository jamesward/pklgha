plugins {
    id("org.pkl-lang") version "0.29.0"
//  id("com.jamesward.github-api-gradle-plugin") version "0.0.2"
}


/*
github {
  owner = "jamesward"
  repo = "pklgha"
}
 */

pkl {
    project {
        packagers {
            register("makePackages") {
                if (version != "unspecified") {
                    environmentVariables.put("VERSION", version.toString())
                }
                projectDirectories.from(file("src/"))
            }
        }
    }
    // todo: generate pkldoc from all releases
    /*
    pkldocGenerators {
      register("pkldoc") {
        noSymlinks = true
        sourceModules = github.releases.get().map { uri("package://pkg.pkl-lang.org/github.com/jamesward/pklgha/${it.tagName}") }
      }
    }
     */

    if (version != "unspecified") {
        pkldocGenerators {
            register("pkldoc") {
                noSymlinks = true
                sourceModules = listOf(uri("package://pkg.pkl-lang.org/github.com/jamesward/pklgha/$version"))
            }
        }
    }

}
