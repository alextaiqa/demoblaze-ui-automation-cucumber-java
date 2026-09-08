# Demoblaze UI Automation Framework

UI test automation framework built from scratch for the Demoblaze web application using Java, Selenium WebDriver, Cucumber, and TestNG.

The framework uses the Page Object Model, dependency injection, external test data, reusable utilities, cross-browser execution, reporting, and CI integration.

## Tech Stack

- Java
- Selenium WebDriver
- Cucumber / Gherkin
- TestNG
- AssertJ
- PicoContainer
- Maven
- Allure
- Jenkins
- YAML
- Git / GitHub

## Key Features

- Page Object Model architecture
- BDD scenarios with reusable step definitions
- PicoContainer dependency injection
- YAML-based test data and configuration
- Reusable WebDriver and explicit wait utilities
- Chrome and Firefox execution with headless support
- Screenshots and logging for test failures
- Allure test reporting
- Maven and Jenkins integration

## Project Structure

The framework separates feature files, step definitions, page objects, test data, configuration, and reusable utilities to keep tests maintainable and easy to extend.

## Running the Tests

### Prerequisites

- Java
- Maven
- Chrome or Firefox

Clone the repository:

```bash
git clone https://github.com/alextaiqa/demoblaze-ui-automation-cucumber-java.git
cd demoblaze-ui-automation-cucumber-java
```

Run the tests:

```bash
mvn test
```

## Project Status

The framework is actively being developed. Additional test scenarios and improvements are planned as development continues.

## License & Usage

This project is part of my personal QA Automation portfolio and is provided for demonstration purposes.
