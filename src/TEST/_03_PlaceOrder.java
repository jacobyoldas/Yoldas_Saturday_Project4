package TEST;

import POM.HomePageElements;
import POM.LogInPageElements;
import POM.MyAccountPageElements;
import UTILS.BaseDriver;
import java.time.Duration;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _03_PlaceOrder extends BaseDriver {

  HomePageElements homePageElements;
  LogInPageElements logInPageElements;
  MyAccountPageElements myAccountPageElements;

  @Test(groups = "Regression")
  public void placeOrder() {
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

    Assert.assertEquals(actualText, expectedText);

    homePageElements.returnHome.click();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("window.scrollBy(0,750)");
    wait.until(ExpectedConditions.elementToBeClickable(homePageElements.productClick));
    homePageElements.productClick.click();
    driver.switchTo().frame(homePageElements.iframe);
    wait.until(ExpectedConditions.elementToBeClickable(homePageElements.addToCard));
    homePageElements.addToCard.click();
    driver.switchTo().parentFrame();
    wait.until(ExpectedConditions.elementToBeClickable(homePageElements.proceedButton1));
    homePageElements.proceedButton1.click();
    js.executeScript("window.scrollBy(0,350)");
    homePageElements.proceedButton2.click();
    js.executeScript("window.scrollBy(0,350)");
    homePageElements.proceedButton3.click();
    js.executeScript("window.scrollBy(0,350)");
    homePageElements.checkBox.click();
    homePageElements.proceedButton4.click();
    js.executeScript("window.scrollBy(0,550)");
    homePageElements.bankWire.click();
    homePageElements.confirmMyOrder.click();

    String actualSuccessText = homePageElements.successMessageOrder.getText();
    String expectedSuccessText = "Your order on My Store is complete.";
    Assert.assertEquals(actualSuccessText, expectedSuccessText);

    homePageElements.myOrder.click();
    js.executeScript("window.scrollBy(0,350)");

    String actualOrderNumber = homePageElements.orderVerifyList.getText().toLowerCase();
    String expectedOrderNumber = homePageElements.orderVerifyList.getText().toLowerCase();

    Assert.assertEquals(actualOrderNumber, expectedOrderNumber);
    Assert.assertTrue(homePageElements.orderVerifyList.isDisplayed());

    for (WebElement element : myAccountPageElements.productList) {
      String textOfElement = element.getText().toLowerCase();
      System.out.println(textOfElement);
      Assert.assertTrue(textOfElement.contains(expectedOrderNumber));
    }
  }
}
