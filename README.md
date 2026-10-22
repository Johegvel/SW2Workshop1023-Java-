# Coding Standards – Java

## Software Engineering II

**Project:** Student Grade Management System  
**Language:** Java  
**Static Analysis Tool:** Checkstyle  
**Repository:** [SW2Workshop1023-Java-](https://github.com/Johegvel/SW2Workshop1023-Java-)

## 1. Overview

This repository contains the implementation and code quality analysis for the *Coding Standards* laboratory in Software Engineering II.

The main objective is to identify and correct coding standard violations in a Java application using Checkstyle. The laboratory focuses on improving code readability, consistency, maintainability, and adherence to established Java coding conventions.

## 2. Project Objectives

- Analyze Java source code using Checkstyle.
- Identify coding standard violations before making corrections.
- Apply consistent naming conventions and indentation.
- Improve code documentation using Javadoc.
- Remove trailing whitespace and formatting inconsistencies.
- Compare static analysis results before and after corrections.

## 3. Technologies and Tools

- **Java:** Programming language used to implement the application.
- **Visual Studio Code:** Source code editor.
- **Checkstyle:** Static analysis tool for checking Java coding conventions.
- **Git and GitHub:** Version control and source code hosting.
- **GitHub Actions:** Automated workflow for code quality checks, if configured and enabled.

## 4. Project Structure

```text
SW2Workshop1023-Java-/
├── .github/
│   └── workflows/
│       └── checkstyles.yml
├── src/
│   └── main/
│       └── java/
│           └── com/
│               └── workshop/
│                   ├── Main.java
│                   └── Student.java
├── checkstyle-14.3.0-all.jar
└── README.md
```

## 5. Checkstyle Configuration and Execution

Checkstyle is executed using its standalone JAR file, without requiring Homebrew.

### Prerequisites

- Java Development Kit (JDK) installed.
- Checkstyle standalone JAR downloaded.
- Terminal opened at the project root directory.

Check the Java installation:

```bash
java -version
```

### Run the analysis

Execute the following command from the project root:

```bash
java -jar checkstyle-14.3.0-all.jar \
  -c /google_checks.xml \
  src/main/java/com/workshop/*.java
```

The analysis checks the Java source files against the selected Google Java style rules and displays detected violations in the terminal.

### Save analysis results

To save the output to a text file:

```bash
java -jar checkstyle-14.3.0-all.jar \
  -c /google_checks.xml \
  -o checkstyle-results.txt \
  src/main/java/com/workshop/*.java
```

> Note: This command generates a text report, not an HTML report. HTML reporting requires additional configuration.

## 6. Coding Standards Applied

The code review focuses on the following areas:

- **Naming conventions:** Classes use UpperCamelCase, and methods use lowerCamelCase.
- **Indentation:** Consistent indentation according to the selected Checkstyle configuration.
- **Documentation:** Javadoc comments for classes and methods where required.
- **Whitespace:** Removal of trailing spaces and proper separation of declarations.
- **Class organization:** Each top-level class resides in its own source file.

## 7. Before-and-After Analysis

The laboratory compares Checkstyle results before and after applying code corrections.

### Initial Analysis

The initial analysis identified violations related to indentation, naming conventions, missing Javadoc comments, and trailing whitespace.

**Screenshot – Initial Checkstyle Results**

_Add your screenshot here._

### Final Analysis

After applying the corrections, Checkstyle is executed again to evaluate the updated source code.

**Screenshot – Final Checkstyle Results**

_Add your screenshot here._

**Analysis summary:**

- Initial violations: _[Insert the verified count]_
- Final violations: _[Insert the verified count]_
- Improvements made: _[Summarize the corrections actually completed]_

## 8. Automated Quality Checks

The repository contains a GitHub Actions workflow at `.github/workflows/checkstyles.yml`.

When configured, the workflow can automate code quality checks whenever changes are pushed or a pull request is opened against the `main` branch.

Workflow status and execution results can be reviewed in the repository's **Actions** tab.

## 9. Conclusion

This laboratory demonstrates the importance of static analysis in improving Java code quality. Checkstyle helps identify deviations from coding conventions and supports a more consistent, readable, and maintainable codebase.

Comparing the initial and final analysis results provides evidence of the corrections performed and reinforces the value of applying coding standards throughout software development.

## 10. References

- [Checkstyle Official Website](https://checkstyle.org/)
- [Google Java Style Guide](https://google.github.io/styleguide/javaguide.html)
- [GitHub Actions Documentation](https://docs.github.com/en/actions)

---

**Course:** Software Engineering II  
**Laboratory:** Coding Standards – Java  
