package com.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class Test_CurrencyConversion {
	WebDriver driver;

	@BeforeClass
	public void testSetup() {
		System.out.println("Lunch Browser");
		System.setProperty("webdriver.chrome.driver", ".\\Driver1\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@BeforeMethod(alwaysRun = true)
	public void openBrowser() throws InterruptedException {
		System.out.println("Set URL");
		driver.get("https://www.paysera.lt/v2/en-LT/fees/currency-conversion-calculator#/");
		Thread.sleep(5);
		System.out.println("We are currently on the following URL" + driver.getCurrentUrl());
	}

	JavascriptExecutor js = (JavascriptExecutor) driver;

	@Test(description = "Test Buy and Sell box test ", priority = 01)
	public void testFirstStep() throws InterruptedException {
		driver.findElement(By.xpath("//input[@data-ng-change='currencyExchangeVM.filter.to_amount = null']")).clear();
		driver.findElement(By.xpath("//input[@data-ng-change='currencyExchangeVM.filter.to_amount = null']"))
				.sendKeys("100");
		// js.executeScript("window.scrollBy(0,1000)");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-ng-change='currencyExchangeVM.filter.from_amount = null']")).clear();
		driver.findElement(By.xpath("//input[@data-ng-change='currencyExchangeVM.filter.from_amount = null']"))
				.sendKeys("200");
		Thread.sleep(1000);
	}

	@Test(description = "Test country and price list update", priority = 01)
	public void testSecondStep() throws InterruptedException {
		driver.findElement(By.xpath("//span[@class='dropup']//span[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.id("countries-dropdown")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//ul[@class='dropdown-menu']//a)[2]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//td[@class='ng-binding ng-scope'])[2]")).click();
		// js.executeScript("window.scrollBy(0,10)");
		Thread.sleep(10000);

	}

	@Test(description = "Test provided value", priority = 01)
	public void testThirdStep() throws InterruptedException {
		Thread.sleep(10000);
		String bank_rate = "300";
		driver.findElement(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.from_amount']")).clear();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//input[@data-ng-model='currencyExchangeVM.filter.from_amount']"))
				.sendKeys(bank_rate);
		driver.findElement(By.xpath("(//button[@data-ng-disabled='currencyExchangeVM.loading'])[1]")).click();

		Thread.sleep(10000);

	}

	@Test(description = "Test All Navigation Menu", priority = 02)
	public void testMenu() throws InterruptedException {
		Thread.sleep(10000);
		// js.executeScript("window.scrollBy(0,1000)");
		driver.findElement(By.xpath("(//a[@href='/v2/en-LT/business-solutions'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//a[@href='/v2/en-LT/paysera-account'])[1]")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@href='/v2/en-LT/fees']")).click();
		Thread.sleep(10000);
	}

	@Test(description = "Test Paysera Logo", priority = 04)
	public void homePageLogo() throws InterruptedException {
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//img[@alt='Paysera'])[1]")).click();
		Thread.sleep(1000);

	}

	@BeforeMethod
	public void beforeMethod() {

	}

	@AfterMethod()
	public void afterMethod() {

	}

	@AfterClass
	public void closeBrowser() {
		driver.close();

	}

}
