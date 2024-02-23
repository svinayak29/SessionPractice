import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Spotify_Practice {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		String timeStamp = LocalDateTime.now().toString().replace(':', '-');
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://open.spotify.com/");
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.titleIs("Spotify - Web Player: Music for everyone"));
		
		WebElement loginLink = driver.findElement(By.xpath("//span[text()='Log in']"));
		loginLink.click();
		Thread.sleep(2000);
		driver.findElement(By.id("login-username")).sendKeys("shidhi917@gmail.com");
		Thread.sleep(2000);
		driver.findElement(By.id("login-password")).sendKeys("Raja#1998$");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
		Thread.sleep(2000);
		
		WebElement searchText = driver.findElement(By.xpath("//span[text()='Search']"));
		Actions actions = new Actions(driver);
		actions.moveToElement(searchText).pause(1000).click(searchText).pause(1000).sendKeys(searchText, "zaroorat").perform();
		
		WebElement songPic = driver.findElement(By.xpath("//div[@data-testid='herocard-click-handler']"));
		File tempFile = songPic.getScreenshotAs(OutputType.FILE);
		File permFile = new File("./song_screenShot/"+ timeStamp + "zaroorat.png");
		FileUtils.copyFile(tempFile, permFile);
		Thread.sleep(2000);
		driver.manage().window().minimize();
		driver.quit();
		
		
		
		
		
		
		

	}

}
