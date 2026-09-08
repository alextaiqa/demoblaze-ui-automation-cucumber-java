A UI test automation framework built from scratch for the Demoblaze web application. The project uses Java, Selenium WebDriver, Cucumber, TestNG, and the Page Object Model to automate major user flows and demonstrate a maintainable, reusable approach to web UI testing.

The framework also includes dependency injection with PicoContainer, external test data using YAML, cross-browser execution, logging, screenshots, Allure reporting, and CI integration with Jenkins.

# Demoblaze UI Automation Framework

A UI test automation framework built from scratch for the Demoblaze web application.

The project uses Java, Selenium WebDriver, Cucumber, and TestNG to automate major user flows and demonstrate a maintainable and reusable approach to web UI testing. It includes Page Object Model architecture, dependency injection, external test data, cross-browser execution, reporting, logging, and CI integration.

## Tech Stack

- **Java** — Core programming language
- **Selenium WebDriver** — Browser automation
- **Cucumber BDD** — Gherkin scenarios and step definitions
- **TestNG** — Test execution and configuration
- **AssertJ** — Assertions and test validation
- **PicoContainer** — Dependency injection
- **Page Object Model** — Framework design pattern
- **Maven** — Dependency management and test execution
- **Allure** — Test reporting
- **Jenkins** — Continuous integration
- **YAML** — External test data and configuration
- **Git / GitHub** — Version control and source code management

## Features

- BDD test scenarios written in Gherkin
- Reusable Cucumber step definitions
- Page Object Model architecture
- PicoContainer dependency injection
- External test data stored in YAML files
- Reusable WebDriver interaction utilities
- Explicit wait utilities
- Screenshot capture
- Test execution logging
- Chrome and Firefox support
- Headless browser execution
- Parallel test execution
- Test validation using AssertJ and TestNG assertions
- Maven-based test execution
- Allure test reporting
- Jenkins CI integration

## Project Structure

The framework separates test scenarios, step definitions, page objects, utilities, configuration, and test data to make the project easier to maintain and extend.

```text
src
├── main
│   └── java
│       └── ...
│
└── test
    ├── java
    │   └── ...
    │
    └── resources
        ├── features
        └── ...
```

> The structure above is simplified. See the repository for the complete project structure.

## Architecture

The framework follows the **Page Object Model (POM)** to separate page-specific behavior from test scenarios and step definitions.

Cucumber feature files describe application behavior using Gherkin scenarios. Step definitions connect those scenarios to the automation code, while page objects contain page-specific elements and interactions.

**PicoContainer** is used for dependency injection to share required objects between Cucumber step definitions without relying on unnecessary global state.

Reusable utilities handle common framework functionality such as WebDriver interactions, explicit waits, screenshots, and other repeated operations.

Test data and configuration are kept outside the test code using **YAML**, making it easier to change test inputs without modifying the test implementation.

The framework also supports cross-browser execution in Chrome and Firefox, including headless execution.

## How to Run Tests

### Prerequisites

Make sure the following are installed:

- Java
- Maven
- Chrome and/or Firefox
- Git

### Clone the Repository

```bash
git clone https://github.com/alextaiqa/demoblaze-ui-automation-cucumber-java.git
cd demoblaze-ui-automation-cucumber-java
```

### Run Tests

```bash
mvn test
```

Additional browser and execution options depend on the framework configuration.

## Test Reporting

The framework integrates with **Allure** to provide test execution reports.

After running the tests, an Allure report can be generated from the test results.

```bash
allure serve
```

The report provides information about executed scenarios, results, failures, and supporting test information.

## Example Test Scenario

Tests are written using Cucumber/Gherkin to keep expected application behavior readable.

```gherkin
Feature: User Login

  Scenario: User logs in with valid credentials
    Given the user is on the Demoblaze home page
    When the user opens the login form
    And the user enters valid credentials
    And the user submits the login form
    Then the user should be logged in successfully
```

> Replace this example with an actual scenario from the project so the README represents the implementation exactly.

## Future Improvements

The framework is still being developed. Planned improvements include:

- Complete remaining test scenarios
- Expand test coverage
- Continue improving test-data management
- Refactor and simplify framework components where appropriate
- Improve documentation
- Expand CI execution and reporting

## About the Author

**Alex Tai**

Software QA Engineer with professional experience in manual and automated testing and a focus on QA Automation.

This project was created as a personal automation project to practice, demonstrate, and continue developing web test automation skills.

## License & Usage Restrictions

This framework is part of my personal portfolio and is provided for demonstration purposes only.

Unauthorized use, modification, or distribution is prohibited without written permission.
