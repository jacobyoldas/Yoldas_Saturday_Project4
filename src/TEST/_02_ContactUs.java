package TEST;

import static java.util.concurrent.TimeUnit.SECONDS;

import POM.HomePageElements;
import POM.LogInPageElements;
import POM.MyAccountPageElements;
import UTILS.BaseDriver;
import java.time.Duration;
import java.util.Locale;
import java.util.NoSuchElementException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_ContactUs extends BaseDriver {

  HomePageElements homePageElements;
  LogInPageElements logInPageElements;
  MyAccountPageElements myAccountPageElements;


  @Test(groups = "Regression")
  @Parameters({"message"})
  public void contactUs(String message) {
    homePageElements = new HomePageElements(driver);
    logInPageElements = new LogInPageElements(driver);
    myAccountPageElements = new MyAccountPageElements(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

    wait.until(ExpectedConditions.elementToBeClickable(homePageElements.signIn));
    homePageElements.signIn.click();
    myAccountPageElements.inputEmail.sendKeys("yasinyoldas666@outlook.com");
    myAccountPageElements.inputPassword.sendKeys("Yozgat-66666");
    wait.until(ExpectedConditions.elementToBeClickable(myAccountPageElements.signInButton));
    myAccountPageElements.signInButton.click();

    String actualText = myAccountPageElements.mayAccountHeader.getText();
    String expectedText= "MY ACCOUNT";

    Assert.assertEquals(actualText,expectedText );

    logInPageElements.contactUsButton.click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,350)");
    Select selectSubjectHeading = new Select(logInPageElements.subjectHeadingDropDown);
    selectSubjectHeading.selectByVisibleText("Customer service");
    Select selectOrderReferenceDropDown = new Select(logInPageElements.orderReferenceDropDown);
    selectOrderReferenceDropDown.selectByVisibleText("-- Choose --");
    logInPageElements.message.sendKeys(message);
    logInPageElements.sendButton.click();

    String actualSuccessMessage = myAccountPageElements.successText.getText();
    String expectedSuccessMessage = "Your message has been successfully sent to our team.";

    Assert.assertEquals(actualSuccessMessage,expectedSuccessMessage);


  }
}
