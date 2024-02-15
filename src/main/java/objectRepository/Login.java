package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	WebDriver driver;

//--PageFacory ==> use @FindBy for storing elements
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="signon")
	WebElement signon;
	

//---constructor
	public Login (WebDriver driver){
		this.driver=driver; // when variable name & instance variable name are same we use this keyword
		PageFactory.initElements(driver, this); 
	}
	
	public void login_credential(String u1, String p1) {
		username.sendKeys(u1);
		password.clear();
		password.sendKeys(p1);
		signon.click();
	}
}
