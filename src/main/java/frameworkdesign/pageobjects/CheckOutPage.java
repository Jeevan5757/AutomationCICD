package frameworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworkdesign.AbstractComponents.ReusableMethod;

public class CheckOutPage extends ReusableMethod {
	WebDriver driver;
	Actions actions;
	
	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		this.actions = new Actions(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//input[@placeholder = 'Select Country']")
	private WebElement country;
	By countryBy = By.cssSelector(".ta-results");
	
	@FindBy(css=".list-group-item .ng-star-inserted")
	private List<WebElement> countries;
	
	@FindBy(css=".action__submit")
	private WebElement submit;
	
	@FindBy(css=".hero-primary")
	private WebElement validation;
	
	public void selectCountry(String countryName) {		
		actions.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(countryBy);
		countries.stream().filter(count->count.getText().equalsIgnoreCase(countryName)).findFirst()
		.ifPresentOrElse(WebElement::click,() -> System.out.println(countryName+" not found"));
		
	}
	public void placeOrder() {
		actions.moveToElement(submit).click().build().perform();	
		
	}
	public String validateOrderPlaced() {
		return validation.getText();
		
	}

}
