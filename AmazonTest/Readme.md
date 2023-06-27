## Automated Testing for Amazon Australia Website

This project provides automated testing for the Amazon Australia website using Cucumber and Selenium WebDriver.

### Prerequisites

Before running the tests, ensure that you have the following installed:

- Java Development Kit (JDK) version 8 or higher
- Maven
- Chrome browser

### Getting Started

1. Clone this repository to your local machine.

```
git clone https://github.com/parajuli/DevOps1_AmazonTest.git
```

2. Install project dependencies using Maven.

```
cd DevOps1_AmazonTest
mvn install
```

### Running the Tests

#### From Command Line

1. Open a terminal and navigate to the project directory.

2. Execute the following command to run the tests:

```
mvn test
```

#### From IDE

1. Open your preferred IDE (e.g., IntelliJ IDEA, Eclipse).

2. Import the project as a Maven project.

3. Locate the `StepDefinitions.java` file in the `src/test/java` directory.

4. Right-click on the file and select "Run" or "Run As" > "JUnit Test" to execute the tests.

### Test Scenario

The test scenario implemented in this project includes the following steps:

1. Open the Amazon Australia website.
2. Search for a specified product.
3. Set the brand filter to Sony.
4. Set the resolution filter to 4K.
5. Set the model year filter to 2022.
6. Sort the results by price from high to low.
7. Print the price of the lowest and highest ticketed items.
8. Close the browser.

### Modifying Test Inputs

To modify the test inputs, such as the search keyword or filter values, you can update the relevant steps in the `StepDefinitions.java` file.

### Additional Information

- The Chrome WebDriver is used in this project. If you have a different browser installed, you will need to download and configure the appropriate WebDriver.
- The Chrome WebDriver executable path is set to `C:/Users/Rajiv/Downloads/APIFramework/src/test/java/resources/chromedriver.exe`. If your Chrome WebDriver executable is located elsewhere, update the path accordingly in the `StepDefinitions.java` file.

---
