Pkl GitHub Actions
------------------

[Check out the PklDoc](https://jamesward.github.io/pklgha/)

### GitHub Action in Pkl

`.github/workflows/hello.pkl`
```
amends "package://pkg.pkl-lang.org/github.com/jamesward/pklgha/pklgha@0.0.13#/GitHubAction.pkl"

on {
  push {

  }
}

jobs {
  ["hello"] = new {
    `runs-on` = "ubuntu-latest"

    steps {
      new {
        name = "checkout"
        uses = "actions/checkout@v4"
      }
    }
  }
}
```

Generate the Yaml:
```
pkl eval -f yaml -o .github/workflows/hello.yaml .github/workflows/hello.pkl
```


### Release a Pkl Package

1. Enable publishing GitHub Pages from GitHub Actions via `https://github.com/<your org>/<your repo>/settings/pages`
2. Create `.github/workflows/release.pkl`
    ```
    amends "package://pkg.pkl-lang.org/github.com/jamesward/pklgha/pklgha@0.0.9#/GitHubActionPkl.pkl"

    action = "release"
    ```
3. Create the GitHub Action Yaml:
    ```
    pkl eval -f yaml -o .github/workflows/release.yaml .github/workflows/release.pkl
    ```


## Developer Info

Update
```
pkl eval -f yaml -o .github/workflows/release.yaml .github/workflows/release.pkl
```

Release
1. Update the version above
1. Tag and push
   ```
   git tag pklgha@0.0.x
   git push --atomic origin main pklgha@0.0.x
   ```
