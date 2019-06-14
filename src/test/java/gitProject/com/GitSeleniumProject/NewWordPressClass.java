package gitProject.com.GitSeleniumProject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NewWordPressClass 
{
	WebDriver driver;

	@Parameters("myBrowser")
	@BeforeTest
	public void BeforeTest(String rty) {
		String browser = rty;
		if (browser.equals("chrome")) {

			System.setProperty("webdriver.chrome.driver", "Resource/chromedriver.exe");
			driver = new ChromeDriver();

		} else if (browser.equals("firefox")) {

			System.setProperty("webdriver.gecko.driver", "Resource/geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (browser.equals("ie")) {

			System.setProperty("webdriver.ie.driver", "Resource/IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else {
			throw new RuntimeException("Browser is not available");
		}

		driver.get("http://demosite.center/wordpress/wp-login.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void Credentials() {
		WebElement username = driver.findElement(By.id("user_login"));
		username.sendKeys("admin");
		WebElement password = driver.findElement(By.id("user_pass"));
		password.sendKeys("demo123");
		WebElement RememberMe = driver.findElement(By.xpath("//input[@name='rememberme']"));
		RememberMe.click();
		WebElement Login = driver.findElement(By.id("wp-submit"));
		Login.click();

	}

	@AfterTest
	public void TesrDown() {
		driver.quit();
	}


}
