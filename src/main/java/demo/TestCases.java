package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get(
                "https://docs.google.com/forms/d/e/1FAIpQLSep9LTMntH5YqIXa5nkiPKSs283kdwitBBhXWyZdAS-e4CxBQ/viewform");
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    public void testCase01() throws InterruptedException {
        WebElement nameField = WrapperMethods.wrap_findElement(driver, By.xpath("//div[@class='Qr7Oae'][1]//input"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nameField);
        Thread.sleep(500);
        WrapperMethods.wrap_sendKeys(nameField, "Rahul Raj");
    }

    public void testCase02() throws InterruptedException {
        WebElement whyPracticeField = WrapperMethods.wrap_findElement(driver,
                By.xpath("//div[@class='Qr7Oae'][2]//textarea"));
        WrapperMethods.wrap_sendKeys(whyPracticeField,
                "I want to be the best QA Engineer! " + System.currentTimeMillis());
    }

    public void testCase03() throws InterruptedException {
        List<WebElement> experienceField = WrapperMethods.wrap_findElements(driver, By.xpath("//div[@role='radio']"));
        WrapperMethods.wrap_click(experienceField.get(0));
    }

    public void testCase04() throws InterruptedException {
        List<WebElement> learnedField = WrapperMethods.wrap_findElements(driver, By.xpath("//div[@role='checkbox']"));
        WrapperMethods.wrap_click(learnedField.get(0));
        WrapperMethods.wrap_click(learnedField.get(1));
        WrapperMethods.wrap_click(learnedField.get(3));
    }

    public void testCase05() throws InterruptedException {
        WebElement salutationDropdown = WrapperMethods.wrap_findElement(driver,
                By.xpath("//div[@class='Qr7Oae'][5]//div[@role='listbox']"));
        WrapperMethods.wrap_click(salutationDropdown);
        Thread.sleep(2000);
        List<WebElement> options = WrapperMethods.wrap_findElements(driver, By
                .xpath("//div[@class='Qr7Oae'][5]//div[@role='listbox']//div[@role='option'][@aria-selected='false']"));
        WrapperMethods.wrap_click(options.get(0));
    }

    public void testCase06() throws InterruptedException {
        String date = WrapperMethods.wrap_getFormattedDate(7);
        WebElement dateField = WrapperMethods.wrap_findElement(driver, By.xpath("//div[@class='Qr7Oae'][6]//input"));
        WrapperMethods.wrap_sendKeys(dateField, date);
    }

    public void testCase07() throws InterruptedException {
        String time = WrapperMethods.wrap_getFormattedTime();
        String timeArr[] = time.split(":");
        WebElement timeField = WrapperMethods.wrap_findElement(driver, By.xpath("//div[@class='Qr7Oae'][7]"));
        WebElement hourField = WrapperMethods.wrap_findElement(driver, By.xpath("//input[@aria-label='Hour']"));
        WrapperMethods.wrap_sendKeys(hourField, timeArr[0]);
        WebElement minuteField = WrapperMethods.wrap_findElement(driver, By.xpath("//input[@aria-label='Minute']"));
        WrapperMethods.wrap_sendKeys(minuteField, timeArr[1]);
        // WebElement amorpmDropdown =
        // timeField.findElement(By.xpath("//div[@aria-label='AM or PM']"));
        // amorpmDropdown.click();
        // Thread.sleep(2000);
        // WebElement amOption = driver
        // .findElement(By.xpath("//div[@class='OA0qNb ncFHed
        // QXL7Te']//div[@data-value='AM']"));
        // WebElement pmOption = driver
        // .findElement(By.xpath("//div[@class='OA0qNb ncFHed
        // QXL7Te']//div[@data-value='PM']"));
        // if (timeArr[2].equals("AM")) {
        // amOption.click();
        // } else {
        // pmOption.click();
        // }
    }

    // driver.navigate().to("https://www.amazon.in/");

    public void testCase08() throws InterruptedException {
        WebElement submitButton = WrapperMethods.wrap_findElement(driver, By.xpath("//div[@class='lRwqcd']/div/span"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", submitButton);
        Thread.sleep(500);
        WrapperMethods.wrap_click(submitButton);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(
                15));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Submit another response']")));
        String successMessage = WrapperMethods.wrap_findElement(driver, By.cssSelector("div.vHW8K")).getText();
        System.out.println(successMessage);
    }

}
