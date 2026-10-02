# pklgha

Pkl package (`package://pkg.pkl-lang.org/github.com/jamesward/pklgha/pklgha@<version>`) for writing GitHub Actions workflows in Pkl (`src/GitHubAction*.pkl`). Built with the `org.pkl-lang` Gradle plugin; released by pushing a version tag.

Follow the `zen-of-projects` Skill (extract it with `./gradlew extractSkillsJars`); this file records
only project-specific facts and exceptions.

## Skills

`zen-of-projects`, `zen-of-james` (from `com.jamesward:skills`, extracted to the gitignored `.kiro/skills/`).

## MCP

`javadocs` (https://www.javadocs.dev/mcp), configured in `.mcp.json` / `.kiro/settings/mcp.json` and
approved in `.claude/settings.json`. Use its `get_latest_version` for version lookups and its
source/doc tools for API questions. In Claude Code its tools are deferred: load them with ToolSearch
(search `javadocs`).

## Build & test

- Full validation: `./gradlew makePackages`.

## Maintenance routine

`.factory/MAINTENANCE.md` (weekly), following the `zen-of-projects` Skill.

## Exceptions to zen-of-projects

- **Workflows are generated from Pkl:** edit `.github/workflows/*.pkl`, then regenerate the YAML with `pkl eval -f yaml -o <name>.yaml <name>.pkl` (in `.github/workflows/`). Never edit the generated YAML by hand.
- **Public API:** the modules in `src/` are a published package used by other repos (for example cfn-pkl-extras and easyracer). Changing a default they emit (action versions, Java version) changes every dependent's workflows on its next upgrade: make such changes in their own PR labeled `needs-human`, not with dependency bumps.
- **Releases:** never tag or release in the maintenance routine.
