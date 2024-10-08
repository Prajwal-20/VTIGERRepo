package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(linkText = "Organizations")
	private WebElement orgModule;
	
	@FindBy(linkText = "Contacts")
	private WebElement contModule;
	
	@FindBy(linkText = "More")
	private WebElement moreModule;
	
	@FindBy(linkText ="Campaigns")
	private WebElement campModule;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administrator;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signout;

	

	public WebElement getAdministrator() {
		return administrator;
	}

	public WebElement getSignout() {
		return signout;
	}

	public WebElement getOrgModule() {
		return orgModule;
	}

	public WebElement getContModule() {
		return contModule;
	}

	public WebElement getMoreModule() {
		return moreModule;
	}

	public WebElement getCampModule() {
		return campModule;
	}
	
	public void logout() {
		Actions act = new Actions(driver);
		act.moveToElement(administrator).click().perform();
		signout.click();
	}
	
	public void navigateToCampaign() {
		Actions action = new Actions(driver);
		action.moveToElement(moreModule).perform();
		campModule.click();
		
	}

	

	
	
}
