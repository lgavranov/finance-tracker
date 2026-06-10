## Communication
Always respond in Croatian (Hrvatski).

## Code Style
- Always add Javadoc comments on public methods
- Use constructor injection, never field injection (@Autowired)
- Always write comments in code in Croatian

## Rules
- Never modify pom.xml without asking me first
- Always write tests for new services

# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Overview

`finance-tracker` is a Spring Boot 4.0.6 application on Java 21, built with Maven. It is currently a fresh scaffold: the persistence/web wiring is configured but no domain model (entities, repositories, controllers, services) exists yet. New feature work means adding those layers under `src/main/java/com/myapp/finance_tracker/`.

## Commands

```bash
./mvnw spring-boot:run        # run the app (embedded server on :8080)
./mvnw test                   # run all tests
./mvnw clean package          # build a jar into target/
./mvnw test -Dtest=ClassName              # run a single test class
./mvnw test -Dtest=ClassName#methodName   # run a single test method
```

The Maven wrapper (`./mvnw`) is checked in — no global Maven install needed.

## Architecture & configuration

- **Database (`src/main/resources/application.yaml`):** PostgreSQL, configured via `DB_URL` / `DB_USERNAME` / `DB_PASSWORD` env vars (defaulting to `localhost:5432/finance`, user `finance`). A running PostgreSQL instance is required to boot the app.
- **Profiles:** config is split into `application-{dev,test,prod}.yaml`; `dev` is the default profile (`spring.profiles.default`). The profile files are currently empty placeholders — common config lives in `application.yaml`.
- **Schema management:** Hibernate `ddl-auto: update` auto-creates/updates tables from `@Entity` classes — there are no migration files; the schema is derived from the JPA model. `show-sql: true` logs SQL to the console.
- **`open-in-view: false`:** lazy associations must be loaded inside the transactional/service layer, not in controllers or serialization.

## Gotcha

The package is `com.myapp.finance_tracker` (underscore), not `finance-tracker` — the original hyphenated name is an invalid Java identifier. Match this package when adding classes.
