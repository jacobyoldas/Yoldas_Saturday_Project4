package UTILS;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseDriver {
  protected WebDriver driver;

   @BeforeMethod
   @Parameters({"browser"})
  public void setup(String browser) {
    if (browser.equals("chrome")) {
      System.setProperty("webdriver.chrome.driver","C:\\Users\\Yasin\\Downloads\\ChromeDriver\\chromedriver.exe");
      driver = new ChromeDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      ChromeOptions options = new ChromeOptions();
      options.addArguments("startmaximized");
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,200)");
      driver.manage().window().maximize();
      driver.get("http://automationpractice.com/index.php");
    } else if (browser.equals("firefox")) {
      System.setProperty("webdriver.gecko.driver","C:\\Users\\Yasin\\Downloads\\geckodriver-v0.31.0-win64\\geckodriver.exe");
      driver = new FirefoxDriver();
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      ChromeOptions options = new ChromeOptions();
      options.addArguments("startmaximized");
      JavascriptExecutor js = (JavascriptExecutor) driver;
      js.executeScript("window.scrollBy(0,200)");
      driver.manage().window().maximize();
      driver.get("http://automationpractice.com/index.php");
    }

  }
  @AfterMethod
  public void tearDown() {
    //driver.quit();
  }
}

