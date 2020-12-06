package dk.web.driver.demo;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.Duration;
import java.util.List;

@SpringBootApplication
public class WebDriverApplication {

    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "src/main/resources/firefoxdriver/geckodriver.exe");


        WebDriver driver1 = new FirefoxDriver();
        driver1.get("https://sqengineer.com/practice-sites/practice-tables-selenium/");

        System.out.println("https://sqengineer.com/practice-sites/practice-tables-selenium/ Tasks:");
        task1(driver1);
        task2(driver1);
        driver1.quit();

        WebDriver driver2 = new FirefoxDriver();
        driver2.get("https://www.youtube.com");
        cat10(driver2);
        driver2.quit();
    }

    public static void cat10(WebDriver driver) throws InterruptedException {
        driver.manage().window().setSize(new Dimension(1900, 1009));
        driver.findElement(By.name("search_query")).sendKeys("cat");
        driver.findElement(By.name("search_query")).sendKeys(Keys.ENTER);
        wait(driver).until(ExpectedConditions.visibilityOfElementLocated(By.id("contents")));

        WebElement contenstContainer = driver.findElement(By.id("contents"));
        List<WebElement> catElements = contenstContainer.findElements(By.tagName("ytd-video-renderer"));
        catElements.stream().forEach(catElement -> {
            WebElement x = catElement.findElement(By.id("dismissable"));
            WebElement y = x.findElement(By.tagName("ytd-thumbnail"));
            WebElement aTag = y.findElement(By.tagName("a"));
            System.out.println(aTag.getAttribute("href").toString());
        });
    }

    private static WebDriverWait wait(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3).toSeconds());
        return wait;
    }

    private static void task2(WebDriver driver) {
        System.out.println("Second Table");
        WebElement table = driver.findElement(By.id("table2"));

        List<WebElement> rows = table.findElements(By.tagName("tr"));
        List<WebElement> rowA = rows.get(0).findElements(By.tagName("td"));
        List<WebElement> rowC = rows.get(2).findElements(By.tagName("td"));
        List<WebElement> rowE = rows.get(2).findElements(By.tagName("td"));

        System.out.println(rowA.get(0).getText());
        System.out.println(rowA.get(2).getText());
        System.out.println(rowC.get(0).getText());
        System.out.println(rowE.get(2).getText());

    }

    private static void task1(WebDriver driver) {
        System.out.println("First Table");
        WebElement table = driver.findElement(By.id("table1"));
        List<WebElement> links = table.findElements(By.tagName("a"));

        String openLinkNewTab = Keys.chord(Keys.CONTROL, Keys.RETURN);
        for (WebElement href : links) {
            href.sendKeys(openLinkNewTab);
        }
    }


}
