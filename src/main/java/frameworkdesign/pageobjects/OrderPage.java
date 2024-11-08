package frameworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworkdesign.AbstractComponents.ReusableMethod;

public class OrderPage extends ReusableMethod{
	WebDriver driver;

	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//tr/td[2] ")
	List<WebElement> productName;
	
	public boolean VerifyOrderDisplay(String ProductName) {
		Boolean match = productName.stream().anyMatch(product->product.getText().equalsIgnoreCase(ProductName));
		return match;
	}

}
