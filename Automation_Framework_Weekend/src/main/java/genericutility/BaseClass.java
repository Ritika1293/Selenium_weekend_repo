package genericutility;

import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectrepository.HomePage;
import objectrepository.LoginPage;
import objectrepository.WelcomePage;

public class BaseClass 
{
	public static WebDriver driver;
	public static ExtentReports eReport;
	public static ExtentTest test;
	public JavaUtility js= new JavaUtility();
	public WebDriverUtility wu= new WebDriverUtility();
	public FileUtility fu= new FileUtility();
	public ExcelUtility eu= new ExcelUtility();
	
	@BeforeSuite
	public void reportConfig()
	{
		ExtentSparkReporter spark= new ExtentSparkReporter("./HTML_reports/extentReport_"+js.getSystemTime()+".html");
		eReport = new ExtentReports();
		eReport.attachReporter(spark);
	}
	@BeforeClass
	public void openBrowser() throws IOException
	{
		driver= new ChromeDriver();
		wu.maximize(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(fu.getPropertyData("url"));
	}
	
	@AfterClass
	public void closeBrowser()
	{
		wu.minimize(driver);
		driver.quit();
	}
	
	@AfterSuite
	public void reportBackup()
	{
		eReport.flush();
	}
	
	@BeforeMethod
	public void login() throws IOException
	{
		WelcomePage wp= new WelcomePage(driver);
		wp.getLoginLink().click();
		
		LoginPage lp= new LoginPage(driver);
		lp.getEmailTextField().sendKeys(fu.getPropertyData("email"));//from commondata property file
		lp.getPasswordTextField().sendKeys(fu.getPropertyData("password"));
		lp.getLoginButton().click();
	}
	@AfterMethod
	public void logout()
	{
		HomePage home= new HomePage(driver);
		home.getLogoutLink().click();
	}
}
