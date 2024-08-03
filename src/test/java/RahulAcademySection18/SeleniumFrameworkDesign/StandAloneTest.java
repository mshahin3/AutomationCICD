package RahulAcademySection18.SeleniumFrameworkDesign;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		//WebDriver driver = new ChromeDriver();
		WebDriverManager.chromedriver().setup();
		
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.findElement(By.id("userEmail")).sendKeys("mshahin3@yahoo.com");
		driver.findElement(By.id("userPassword")).sendKeys("walton11");
		driver.findElement(By.id("login")).click();
		
		List<WebElement> products =driver.findElements(By.cssSelector(".mb-3"));
		
		WebElement prod = products.stream().filter(product->product
				.findElement(By.cssSelector("b")).getText()
				.equals("ZARA COAT 3")).findFirst().orElse(null);
		
		prod.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		
		

	}

}
