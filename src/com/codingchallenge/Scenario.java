package com.codingchallenge;


import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Scenario {
	
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "D:\\Notes\\chromedriver-win64\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.saucedemo.com/");
		driver.manage().window().maximize();
		
		
		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login-button")));
		
		// Scenario 1
		
		System.out.println("Scenario 1");
		
		//1. log in using standard user
		
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		
		//2. verify that user is able to navigate to home 

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_container")));
		
		boolean container_inventory = driver.findElement(By.className("inventory_container")).isDisplayed();
		
		if(container_inventory == false) {
			System.out.println("user failed to navigate to home");
		}
		
		else
		{	
			System.out.println("user was able to navigate to home");	
		}
		
		System.out.println("login");
		//3. log out
		
	 	driver.findElement(By.id("react-burger-menu-btn")).click();
	 	
	 	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@href='#']")));
		
		driver.findElement(By.id("logout_sidebar_link")).click();

		
		//4. verify that user is navigated to login page
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("login-button")));
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("login_container")));
		
		boolean container_login = driver.findElement(By.className("login_container")).isDisplayed();
		
		if(container_login == false) {
			System.out.println("user failed to navigate to login page");
		}
		
		else
		{	
			System.out.println("user was able to navigate to login page");
			
		}
		
		System.out.println("logout");
		
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
		
		driver.findElement(By.className("error-button")).click();
		}
		
		
		driver.close();
	
	}

}
