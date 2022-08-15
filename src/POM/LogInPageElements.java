package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogInPageElements {
  public LogInPageElements(WebDriver driver){
    PageFactory.initElements(driver,this);
  }


  @FindBy(id = "contact-link")
  public WebElement contactUsButton;
  @FindBy(xpath = "(//select[@class='form-control'])[1]")
  public WebElement subjectHeadingDropDown;

  @FindBy(xpath = "(//select[@class='form-control'])[2]")
  public WebElement orderReferenceDropDown;

  @FindBy(css = "textarea[name='message']")
  public WebElement message;
  @FindBy(id = "submitMessage")
  public WebElement sendButton;





}
