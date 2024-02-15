package webDriver_Framework.Selenium_Framework;

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import objectRepository.HomePage;
import objectRepository.Login;
import utilities.CrossBrowser;
import utilities.ExcelData;

public class AppTest {
	WebDriver driver;
	String data[] = new String[5];
	ExtentReports report = new ExtentReports();
	ExtentSparkReporter sparkreport = new ExtentSparkReporter("C:\\selenium_Demo\\Framework_PageFactory_Login\\target\\report.html");
	ExtentTest test = report.createTest("Login Application");
	
	@Test
	public void valid_application() throws IOException {
		
		report.attachReporter(sparkreport);
		
		//data = new String[5];
		CrossBrowser br = new CrossBrowser();
		driver = br.browser_initiate();
		
		HomePage h = new HomePage(driver);
		h.signin();
		
		test.log(Status.PASS, "Welcome to home page");
		
		ExcelData d = new ExcelData();
		data = d.readExcel();
		String user = data[0];
		String pass = data[1];
		
		Login l = new Login(driver);
		l.login_credential(user,pass);
		
		
		test.log(Status.PASS, "valid login");
		report.flush();
		
	}
	
}
