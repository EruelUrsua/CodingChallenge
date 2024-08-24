package com.codingchallenge;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario_2 {
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Notes\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login-button")));
		
		
		
		// Scenario 2
		
				System.out.println("Scenario 2");
				
				//1.  log in using locked out user
				
				driver.findElement(By.id("user-name")).sendKeys("locked_out_user");
				driver.findElement(By.id("password")).sendKeys("secret_sauce");
				driver.findElement(By.id("login-button")).click();
				
				//2. verify error message
				
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("error-button")));
				
				boolean button_error = driver.findElement(By.className("error-button")).isDisplayed();
				
				if (button_error == false)
					
				{
					System.out.println("user did not receive an error message");
				}
				
				else {
				
				System.out.println("user has received the error message");
				
				//driver.findElement(By.className("error-button")).click();
				}
				
				
			
		
		
	}
}
