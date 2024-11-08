package frameworkdesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import frameworkdesign.AbstractComponents.ReusableMethod;

public class CartPage extends ReusableMethod {
	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
@FindBy(css = ".cartSection h3")
List<WebElement> cartproduct;

@FindBy(css=".totalRow .btn-primary")
WebElement checkout;

public Boolean isProductpresent(String productname) {
	Boolean match = cartproduct.stream().anyMatch(item->item.getText().equalsIgnoreCase(productname));
	return match;
	
}

public CheckOutPage clickOnCheckout() {
	checkout.click();
	CheckOutPage checkoutpage = new CheckOutPage(driver);
	return checkoutpage;
}


}
