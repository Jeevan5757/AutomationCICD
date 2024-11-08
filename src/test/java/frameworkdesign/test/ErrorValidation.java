package frameworkdesign.test;



import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import frameworkdesign.pageobjects.CartPage;
import frameworkdesign.pageobjects.CheckOutPage;
import frameworkdesign.pageobjects.ProductCatalogue;
import frameworkdesign.tsetComponents.BaseTest;
import frameworkdesign.tsetComponents.Retry;

public class ErrorValidation extends BaseTest{
	
	@Test(groups={"ErrorHandling"},retryAnalyzer=Retry.class)
	public void loginErrorValidation() {
	
	String product_name = "ZARA COAT 3";
	ProductCatalogue productdata = landingpage.loginApplication("beherajee25@gmail.com", "Jevan99@");
	Assert.assertEquals("Incorrect  or password.", landingpage.geterrorMessage());
	}
	@Test(retryAnalyzer=Retry.class)
	public void productErrorValidation() throws IOException {
		String product_name = "ZARA COAT 3";	
		ProductCatalogue productdata = landingpage.loginApplication("beherajeevan25@gmail.com", "Jeevan99@");
		productdata.getProductList();
		productdata.addProductToCart(product_name);
		
		CartPage cartpage = productdata.addToCart();		
		boolean match = cartpage.isProductpresent(product_name);
		
		Assert.assertTrue(match);

	}
}
