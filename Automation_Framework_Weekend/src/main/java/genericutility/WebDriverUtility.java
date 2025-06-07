package genericutility;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
/**
 * It is used to perform action of all the methods from selenium webdriver action
 */
public class WebDriverUtility 
{
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
		
	}
	public void minimize(WebDriver driver)
	{
		driver.manage().window().minimize();
		
	}
	public Dimension capturesize(WebDriver driver)
	{
		return driver.manage().window().getSize();
	}
	public void mouseHover(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.moveToElement(element).perform();
		
	}
	public void clickAndHold(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.clickAndHold(element).perform();
	
	}
	public void doubleClick(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.doubleClick(element).perform();
	
	}
	public void selectByValue(WebElement element, int index)
	{
		Select sel= new Select(element);
		sel.deselectByIndex(index);
		
	}
	public void selectByValue(WebElement element,String value)
	{
		Select sel= new Select(element);
		sel.selectByValue(value);
		
	}
	public void selectByVisibleText(WebElement element, String Text)
	{
		Select sel= new Select(element);
		sel.deselectByVisibleText(Text);
		
	}
	public void switchToFrame(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(WebDriver driver,String nameOrId)
	{
		driver.switchTo().frame(nameOrId);
	}
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	
	public void switchToHomeFrame(WebDriver driver)
	{
		driver.switchTo().defaultContent();
	}
	public Alert switchToAlert(WebDriver driver)
	{
		return driver.switchTo().alert();
	}
	public void getScreenshots(WebDriver driver) throws IOException
	{
		JavaUtility js= new JavaUtility();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshorts/"+js.getSystemTime()+".png");
		FileHandler.copy(temp, dest);
	}
}