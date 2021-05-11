package com.quanqinle.selenium4trail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * Screenshot the full page or a HTML element
 *
 * @author quanql
 * @version 2021/5/11
 */
public class Demo02 {
    private static final Logger logger = LoggerFactory.getLogger(Demo01.class);

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }

    @Test
    public void test_Screenshot() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.bing.com");

        WebElement logo = driver.findElement(By.id("bLogo"));

        try {
            byte[] logoBytes = logo.getScreenshotAs(OutputType.BYTES);
            Files.write(Paths.get("b-logo.png"), logoBytes);

            File pageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            Files.copy(pageFile.toPath(), Paths.get("full-page.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
