package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CrossBrowser {
	WebDriver driver;
	String filepath = "C:\\selenium_Demo\\Framework_PageFactory_Login\\config.properties";
	
	public WebDriver browser_initiate() throws IOException {
//------Step 1 read the file
		FileInputStream fis = new FileInputStream (filepath);
//------Step 2	create an OBJECT for the property class
		Properties p = new Properties();
//------Step 3 load the file	
		p.load(fis);
		
		String browsername = p.getProperty("browser");
		
		switch(browsername){
		case "chrome":
			driver = new ChromeDriver();
			driver.get(p.getProperty("url"));
			break;
			
		case "edge":
			driver = new EdgeDriver();
			driver.get(p.getProperty("url"));
			break;
		
		case "firefox":
			driver = new FirefoxDriver();
			driver.get(p.getProperty("url"));
			break;
		
		}
		return driver;
	}

}
