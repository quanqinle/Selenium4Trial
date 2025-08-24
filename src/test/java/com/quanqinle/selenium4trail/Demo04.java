package com.quanqinle.selenium4trail;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 * A demo for slider bar... not worked out yet
 *
 * @author quanqinle
 */
public class Demo04 {

  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
    // Selenium ver4自带的driver下载管理功能不好用，在大陆网络下。继续自行下载吧
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();

    driver.get(
        "https://cmis.cicpa.org.cn/#/login?response_type=code&client_id=9dd1118f-48ec-f2c0-281c-8f45d68266e9&state=extend&redirect_uri=https%3A%2F%2Fzsk-cmis.cicpa.org.cn%2Fwhole_cloud%2FV1%2Flogin");

    try {
      Thread.sleep(10_000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    WebElement sliderHandle = driver.findElement(By.cssSelector(".yidun_slider"));
    WebElement sliderTrack = driver.findElement(By.cssSelector(".yidun_control"));
    Actions actions = new Actions(driver);
    actions.dragAndDrop(sliderHandle, sliderTrack).build().perform();
    // Option 2: Drag 100 pixels to the right
    //      actions.dragAndDropBy(sliderHandle, 100, 0).build().perform();

    File pageFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    try {
      Files.copy(pageFile.toPath(), Paths.get("full-page.png"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    driver.quit();
  }
}
