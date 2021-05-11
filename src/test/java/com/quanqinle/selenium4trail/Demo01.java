package com.quanqinle.selenium4trail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Open new tab and window
 *
 * @author quanql
 * @version 2021/5/10
 */
public class Demo01 {
    private static final Logger logger = LoggerFactory.getLogger(Demo01.class);

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    }

    @Test
    public void test_OpenNew() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com/");

        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://www.bing.com");

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.navigate().to("https://www.bing.com");
    }

}
