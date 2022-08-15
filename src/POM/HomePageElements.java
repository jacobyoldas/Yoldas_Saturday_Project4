package POM;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageElements {
  public HomePageElements(WebDriver driver){
    PageFactory.initElements(driver,this);
  }

  @FindBy(css="a[title='Log in to your customer account']")
  public WebElement signIn;

  @FindBy(css="a[title='Return to Home']")
  public WebElement returnHome;

  @FindBy(xpath = "(//img[@class='replace-2x img-responsive'])[2]")
  public WebElement productClick;

  @FindBy(css = "iframe[class='fancybox-iframe']")
  public WebElement iframe;

  @FindBy(xpath = "//span[text()='Add to cart']")
  public WebElement addToCard;

  @FindBy(css = "a[class='btn btn-default button button-medium']")
  public WebElement proceedButton1;

  @FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
  public WebElement proceedButton2;

  @FindBy(css = "button[name='processAddress']")
  public WebElement proceedButton3;

  @FindBy(css = "button[name='processCarrier']")
  public WebElement proceedButton4;

  @FindBy(css = "input[id='cgv']")
  public WebElement checkBox;

  @FindBy(css = "a[class='bankwire']")
  public WebElement bankWire;

  @FindBy(css = "button[class='button btn btn-default button-medium']")
  public WebElement confirmMyOrder;

  @FindBy(xpath = "//strong[text()='Your order on My Store is complete.']")
  public WebElement successMessageOrder;

  @FindBy(xpath = "//a[text()='My orders']")
  public WebElement myOrder;

  @FindBy(css = "a[class='color-myaccount']")
  public WebElement orderVerifyList;









}
