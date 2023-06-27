package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class StepDefinitions {
    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I am on the Amazon Australia website")
    public void iAmOnAmazonAustraliaWebsite() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Rajiv/Downloads/APIFramework/src/test/java/resources/chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(2));
        driver.get("https://www.amazon.com.au");
        //Maximize current window
        driver.manage().window().maximize();
        //Delay execution for 2 seconds to view the maximize operation
        Thread.sleep(2000);
    }

    @When("I search for {string}")
    public void searchForSonyTV(String productName) {
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("twotabsearchtextbox")));
        searchBox.sendKeys(productName);
        searchBox.submit();
    }

    @When("I set the brand to Sony")
    public void setBrandToSony() throws InterruptedException {
        WebElement brandFilter = driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'][normalize-space()='Sony'])[1]"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,200);", brandFilter);
        brandFilter.click();
        Thread.sleep(2000);
    }
    
    
    @When("I set the resolution filter to 4k")
    public void setResolutionFilterTo4K() throws InterruptedException {
    	WebElement resolutionFilter = driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'][normalize-space()='4K'])[1]"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);", resolutionFilter);
        resolutionFilter.click();
        Thread.sleep(2000);
    }

    @When("I set the model year to 2022")
    public void setModelYearTo2022() throws InterruptedException {
    	WebElement modelYearFilter = driver.findElement(By.xpath("(//span[@class='a-size-base a-color-base'][normalize-space()='2022'])[1]"));
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,400);", modelYearFilter);
        modelYearFilter.click();
        
        Thread.sleep(2000);
    }

    @When("I sort results by price high to low")
    public void sortResultsByPriceHighToLow() throws InterruptedException {
    	
    	String menuSelector = ".a-dropdown-prompt";
        String menuItemSelector = ".a-dropdown-common .a-dropdown-item";
        
        Thread.sleep(2000);

        WebElement menu = driver.findElement(By.cssSelector(menuSelector));
        menu.click();
        
        List<WebElement> menuItem = driver.findElements(By.cssSelector(menuItemSelector));
        menuItem.get(2).click();
    	
		Thread.sleep(1000);
	
    }

    @Then("I print the price of the lowest and highest ticketed items")
    public void printLowestAndHighestPrice() {
        List<WebElement> priceElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".a-price-whole")));

        if (priceElements.size() > 0) {
            WebElement lowestPriceElement = priceElements.get(priceElements.size() - 1);
            WebElement highestPriceElement = priceElements.get(0);

            String lowestPrice = lowestPriceElement.getText();
            String highestPrice = highestPriceElement.getText();

            System.out.println("Lowest ticketed item price: $" + lowestPrice);
            System.out.println("Highest ticketed item price: $" + highestPrice);
        } else {
            System.out.println("No TV prices found.");
        }
    }

    @Then("I close the browser")
    public void closeBrowser() {
        driver.quit();
    }
}
