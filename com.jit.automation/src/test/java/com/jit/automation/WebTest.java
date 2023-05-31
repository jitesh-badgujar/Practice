package com.jit.automation;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTest {

	@Test
	public void myFirstTest() {

		WebDriver driver = new ChromeDriver();
		// new ChromeOptions().addArguments("--remote-allow-origins=*")
		driver.get("https://www.google.com");
	}

}
