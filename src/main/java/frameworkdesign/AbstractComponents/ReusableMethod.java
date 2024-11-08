package frameworkdesign.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import frameworkdesign.pageobjects.OrderPage;

public class ReusableMethod {
	WebDriver driver;
	
	public ReusableMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//button[@routerlink = '/dashboard/cart']")
	WebElement cartButton;
	
	@FindBy(xpath="//button[@routerlink = '/dashboard/myorders']")
	WebElement orderHeader;

	public void waitForElementToAppear(By findby) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));

	}
	public void waitforElementToDissapear(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOf(element));
		
	}
	public void cartPage() {
		cartButton.click();
		
	}
	public void waitForWebElementToAppear(WebElement findby) {
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(findby));

	}
	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderPage = new OrderPage(driver);
		return orderPage;
		
	}

}
