package frameworkdesign.test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import frameworkdesign.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SeleniumTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String product_name = "ZARA COAT 3";
//		String country = "india";
//		WebDriverManager.chromedriver().setup(); 
////		String Chromedriverpath = "E:\\Java\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe";
////		System.setProperty("webdriver.chrome.driver", Chromedriverpath);
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
//		driver.manage().window().maximize();
//		driver.get("https://rahulshettyacademy.com/client");
//		LandingPage landingpage = new LandingPage(driver);
//		driver.findElement(By.id("userEmail")).sendKeys("beherajeevan25@gmail.com");
//		driver.findElement(By.id("userPassword")).sendKeys("Jeevan99@");
//		driver.findElement(By.id("login")).click();
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div .col-lg-4")));
//		List<WebElement> products = driver.findElements(By.cssSelector("div .col-lg-4"));
//		WebElement prod = products.stream().filter(product->product.findElement(By.cssSelector("b"))
//				.getText().equals(product_name)).findFirst().orElse(null);
//		
////		System.out.println(prod);
//		
//		prod.findElement(By.cssSelector("div .card-body button:last-of-type")).click();
//		
//		
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#toast-container")));
////		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
//		driver.findElement(By.xpath("//button[@routerlink = '/dashboard/cart']")).click();
//		
//		List<WebElement> cartproduct = driver.findElements(By.cssSelector(".cartSection h3"));
//		Boolean match = cartproduct.stream().anyMatch(item->item.getText().equalsIgnoreCase(product_name));
//		Assert.assertTrue(match);
//		driver.findElement(By.cssSelector(".totalRow .btn-primary")).click();
//		Actions a = new Actions(driver);
//		a.sendKeys(driver.findElement(By.xpath("//input[@placeholder = 'Select Country']")), country).build().perform();
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
//		List<WebElement> countryselect = driver.findElements(By.cssSelector(".list-group-item .ng-star-inserted"));
//		countryselect.stream().filter(count->count.getText().equalsIgnoreCase(country)).findFirst()
//		.ifPresentOrElse(WebElement::click,() -> System.out.println(country+" not found"));
//		a.moveToElement(driver.findElement(By.cssSelector(".action__submit"))).click().build().perform();
//		String confirmmessage = driver.findElement(By.cssSelector(".hero-primary")).getText();
//		Assert.assertTrue(confirmmessage.equalsIgnoreCase("Thankyou for the order."));
//		driver.quit();	
//		System.out.println("driver closed successfully");
		System.out.println(System.getProperty("user.dir"));
		
	}

}
