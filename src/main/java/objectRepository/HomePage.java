package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
//--PageFacory ==> use @FindBy for storing elements
	@FindBy (xpath="//*[@id=\"MenuContent\"]/a[2]")
	WebElement signin;
	
//---Creating a constructor
	public HomePage (WebDriver driver){
		this.driver=driver; // "this"--> when variable name & instance variable name are same we use this keyword
		PageFactory.initElements(driver, this); // initialized the elements using single initelement method
	}
	
//--writing a script	
	public void signin() {
		signin.click();
	}
}
