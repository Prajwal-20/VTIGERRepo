package objectRepository;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.PropertyFileUtilities;



public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver) {
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	PropertyFileUtilities putil = new PropertyFileUtilities();

	@FindBy(name="user_name")
	private WebElement usernameTF;
	
	@FindBy(name="user_password")
	private WebElement passwordTF;
	
	@FindBy(id = "submitButton")
	private WebElement loginBtn;

	public WebElement getUsernameTF() {
		return usernameTF;
	}

	public WebElement getPasswordTF() {
		return passwordTF;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
	
	public void login() throws IOException {
		String UN = putil.readDataFromProperties("Username");
		String pwd = putil.readDataFromProperties("Password");
		usernameTF.sendKeys(UN);
		passwordTF.sendKeys(pwd);
		loginBtn.click();
	}
		
		public void login(String UN, String PWD) {
			usernameTF.sendKeys(UN);
			passwordTF.sendKeys(PWD);
			loginBtn.click();
			
		}
		
	}

