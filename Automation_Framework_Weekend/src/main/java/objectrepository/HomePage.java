package objectrepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
  @FindBy(linkText = "Log out")
  private WebElement logoutLink;
  
  @FindBy(linkText = "BOOKS")
  private WebElement bookLink;
  
  @FindBy(linkText = "COMPUTERS")
  private WebElement computerLink;
  
  public HomePage(WebDriver driver)
  {
  PageFactory.initElements(driver, this);
  }

public WebElement getLogoutLink() {
	return logoutLink;
}

public WebElement getBookLink() {
	return bookLink;
}

public WebElement getComputerLink() {
	return computerLink;
}
  

}
