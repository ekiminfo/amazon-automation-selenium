package demo;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chrome.ChromeDriver;

public class AmazonAutoTest {

	public static void main(String[] args) throws InterruptedException{
		
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*","ignore-certificate-errors");
		options.addArguments("--disable-notification");
		
		WebDriver driver =new ChromeDriver(options);
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.amazon.com");
		
		WebElement searchInput = driver.findElement(By.cssSelector("input[id='twotabsearchtextbox']"));
		searchInput.click();
		searchInput.sendKeys("samsung");
		WebElement searchBtn = driver.findElement(By.cssSelector("input[id='nav-search-submit-button']"));
		searchBtn.click();
		
		Thread.sleep(1000);
		
		//Choose product condition (New, Renewed, Used)
		WebElement proCondition = driver.findElement(By.xpath("//a[span[text()='Used']]"));
		proCondition.click();
		
		Thread.sleep(1000);
		
		//Product Review from 4stars and above
		WebElement fourStar = driver.findElement(By.xpath("//i[span[text()='4 Stars & Up']]"));
		fourStar.click();
		
		Thread.sleep(1000);
		
		//Selecting a product by entering price in the text value
		WebElement newPro = driver.findElement(By.xpath("//span[span[text()='439']]"));
		newPro.click();
		
		//Add to cart
		WebElement addCartBtn = driver.findElement(By.cssSelector("input[name='submit.add-to-cart']"));
		addCartBtn.click();
		
		Thread.sleep(5000);
		driver.quit();

	}

}
