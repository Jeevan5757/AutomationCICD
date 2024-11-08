package frameworkdesign.test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import frameworkdesign.pageobjects.CartPage;
import frameworkdesign.pageobjects.CheckOutPage;
import frameworkdesign.pageobjects.LandingPage;
import frameworkdesign.pageobjects.OrderPage;
import frameworkdesign.pageobjects.ProductCatalogue;
import frameworkdesign.tsetComponents.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SubmitOrderTest extends BaseTest {
		// TODO Auto-generated method stub
	
	@Test(dataProvider="getData",groups= {"Purchase"})
	public void submitOrder(HashMap <String,String> input) throws IOException {
		
		String country = "india";		
		ProductCatalogue productdata = landingpage.loginApplication(input.get("email"), input.get("password"));
		productdata.getProductList();
		productdata.addProductToCart(input.get("product"));
		
		CartPage cartpage = productdata.addToCart();		
		boolean match = cartpage.isProductpresent(input.get("product"));
		
		Assert.assertTrue(match);
		CheckOutPage checkoutpage = cartpage.clickOnCheckout();
		
		checkoutpage.selectCountry(country);
		checkoutpage.placeOrder();
		
		String confirmmessage = checkoutpage.validateOrderPlaced();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));

	}
	@Test(dependsOnMethods = {"submitOrder"})
	public void orderHistory() throws IOException {
		String product_name = "ZARA COAT 3";
		ProductCatalogue productdata = landingpage.loginApplication("beherajeevan25@gmail.com", "Jeevan99@");
		OrderPage orderpage = productdata.goToOrderPage();
		Boolean match = orderpage.VerifyOrderDisplay(product_name);
		Assert.assertTrue(match);		
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException {
//		HashMap <String,String> map = new HashMap<String, String>();
//		map.put("email", "beherajeevan25@gmail.com");		
//		map.put("password", "Jeevan99@");
//		map.put("product", "ZARA COAT 3");
//		
//		HashMap <String,String> map1 = new HashMap<String, String>();
//		map1.put("email", "jeevan.behera99@gmail.com");		
//		map1.put("password", "Password99@");
//		map1.put("product", "ADIDAS ORIGINAL");
		List<HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\frameworkdesign\\data\\PurchaseOrder.json");
	    return new Object[][] {{data.get(0)},{data.get(1)}};
	}
}
