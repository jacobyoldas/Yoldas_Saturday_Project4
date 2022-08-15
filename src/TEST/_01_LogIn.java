package TEST;

import POM.HomePageElements;
import POM.LogInPageElements;
import POM.MyAccountPageElements;
import UTILS.BaseDriver;
import java.time.Duration;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _01_LogIn extends BaseDriver {

  HomePageElements homePageElements;
  LogInPageElements logInPageElements;
  MyAccountPageElements myAccountPageElements;

  @Test
  public void loginPositiveTest() {
    homePageElements = new HomePageElements(driver);
    logInPageElements = new LogInPageElements(driver);
    myAccountPageElements = new MyAccountPageElements(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    wait.until(ExpectedConditions.elementToBeClickable(homePageElements.signIn));
    homePageElements.signIn.click();
    myAccountPageElements.inputEmail.sendKeys("yasinyoldas666@outlook.com");
    myAccountPageElements.inputPassword.sendKeys("Yozgat-66666");
    wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.signInButton));
    myAccountPageElements.signInButton.click();

    String actualText = myAccountPageElements.mayAccountHeader.getText();
    String expectedText= "MY ACCOUNT";

    Assert.assertEquals(actualText,expectedText );
  }

  @Test
  public void loginNegativeTest() {
    homePageElements = new HomePageElements(driver);
    logInPageElements = new LogInPageElements(driver);
    myAccountPageElements = new MyAccountPageElements(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    homePageElements.signIn.click();
    myAccountPageElements.inputEmail.sendKeys("yasinyoldas66@outlook.com");
    myAccountPageElements.inputPassword.sendKeys("Yozgat-6666");
    wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.signInButton));
    myAccountPageElements.signInButton.click();

    String actualText = myAccountPageElements.mayAccountHeader.getText();
    String expectedText= "AUTHENTICATION";

    Assert.assertEquals(actualText,expectedText );

  }
}
