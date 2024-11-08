package frameworkdesign.stepDefinitions;

import java.io.IOException;

import org.testng.Assert;

import frameworkdesign.pageobjects.CartPage;
import frameworkdesign.pageobjects.CheckOutPage;
import frameworkdesign.pageobjects.LandingPage;
import frameworkdesign.pageobjects.ProductCatalogue;
import frameworkdesign.tsetComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinitionimpl extends BaseTest{
	public LandingPage landingpage;
	public ProductCatalogue productdata;
	public CartPage cartpage;
	public CheckOutPage checkoutpage;
	String country = "india";
	@Given("I landed to ECommerce page")
	public void I_landed_to_ECommerce_page() throws IOException{
		landingpage = launchApplication();
		
	}
	@Given("^I Logged in with username as (.+) and password as (.+)$")
	public void I_logged_in_with_username_and_password(String Username,String Password){
		productdata = landingpage.loginApplication(Username, Password);
		
	}
	@When("^I add product (.+) to cart$")
	public void I_add_product_to_cart(String ProductName){
		productdata.getProductList();
		productdata.addProductToCart(ProductName);
		
	}
	@When("^verify (.+) added in cart page$")
	public void verify_add_to_cart_page(String ProductNmae) {
		cartpage = productdata.addToCart();		
		boolean match = cartpage.isProductpresent(ProductNmae);
		
		Assert.assertTrue(match);
		checkoutpage = cartpage.clickOnCheckout();
		
	}
	@When("validate user click on submit button in checkout page")
	public void click_on_submit() {
		checkoutpage.selectCountry(country);
		checkoutpage.placeOrder();
		
	}
	@Then("{string} message is displayed on ConfirmationPage")
	public void message_displayed(String string) {
		String confirmmessage = checkoutpage.validateOrderPlaced();
		Assert.assertTrue(confirmmessage.equalsIgnoreCase(string));
	}

}
