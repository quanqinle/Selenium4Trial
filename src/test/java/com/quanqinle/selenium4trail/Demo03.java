package com.quanqinle.selenium4trail;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

/**
 * How to use RelativeLocator, i.e. above, below, toRightOf, etc.
 *
 * @author quanql
 * @version 2021/5/11
 */
public class Demo03 {
  private static final Logger logger = LoggerFactory.getLogger(Demo03.class);

  @BeforeAll
  public static void setup() {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
  }

  @Test
  public void test_RelativeLocator() {
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.get("https://www.bing.com");

    WebElement btnSwitchLang = driver.findElement(By.id("est_switch"));

    WebElement inputSearch = driver.findElement(with(By.tagName("input")).below(btnSwitchLang));
    inputSearch.sendKeys("Google");

    WebElement btnSearch = driver.findElement(with(By.id("sb_form_go")).toRightOf(btnSwitchLang));
    btnSearch.click();
  }
}
