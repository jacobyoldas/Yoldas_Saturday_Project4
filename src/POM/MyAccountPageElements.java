package POM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccountPageElements {
  public MyAccountPageElements(WebDriver driver){

    PageFactory.initElements(driver,this);
  }

  @FindBy(css = "input[id='email']")
  public WebElement inputEmail;

  @FindBy(css = "input[id='passwd']")
  public WebElement inputPassword;

  @FindBy(css = "button[id='SubmitLogin']")
  public WebElement signInButton;
  @FindBy(css="h1[class='page-heading']")
  public WebElement mayAccountHeader;

  @FindBy(css="p[class='alert alert-success']")
  public WebElement successText;

  @FindBy(xpath = "(//a[@class='color-myaccount'])[1]")
  public List<WebElement> productList;



}
