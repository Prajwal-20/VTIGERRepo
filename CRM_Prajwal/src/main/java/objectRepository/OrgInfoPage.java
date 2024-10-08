package objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgInfoPage {
	WebDriver driver;

	public OrgInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	 @FindBy(xpath = "//span[@class='dvHeaderText']")
	 private WebElement headerText;
	 
	 @FindBy(id = "dtlview_Industry")
	 private WebElement headerIndustry;
	 
	 @FindBy(id = "dtlview_Type")
	 private WebElement headerType;

	public WebElement getHeaderText() {
		return headerText;
	}

	public WebElement getHeaderIndustry() {
		return headerIndustry;
	}

	public WebElement getHeaderType() {
		return headerType;
	}
	
	
	 
	 
}
