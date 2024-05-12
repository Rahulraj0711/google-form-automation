package demo;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WrapperMethods {
    public static WebElement wrap_findElement(WebDriver driver, By by) {
        return driver.findElement(by);
    }

    public static List<WebElement> wrap_findElements(WebDriver driver, By by) {
        return driver.findElements(by);
    }

    public static void wrap_sendKeys(WebElement element, String text) {
        element.sendKeys(text);
    }

    public static void wrap_click(WebElement element) {
        element.click();
    }

    public static String wrap_getFormattedDate(int daysToMinus) {
        LocalDateTime date = LocalDateTime.now().minusDays(daysToMinus);
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String formattedDate = dateFormatter.format(date);
        return formattedDate;
    }

    public static String wrap_getFormattedTime() {
        LocalDateTime time = LocalDateTime.now();
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:a");
        String formattedTime = time.format(timeFormatter);
        return formattedTime;
    }
}
