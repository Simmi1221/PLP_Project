package com.example.hotelmanagementsystem.bdd;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionForAdmin {
	
	static {
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/chromedriver.exe");
	}
	WebDriver driver;
	
	@Given("^the user has loaded the application in the browser$")
	public void the_user_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("^user click on login link$")
	public void user_click_on_login_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

	}

	@When("^the user enters valid email in the emailbox$")
	public void the_user_enters_valid_email_in_the_emailbox() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("simmimulani1221@gmail.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^the user enters valid password in the password textbox$")
	public void the_user_enters_valid_password_in_the_password_textbox() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Simmi1221");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@When("^the user clicks on the login button$")
	public void the_user_clicks_on_the_login_button() throws Throwable {
	}

	@Then("^the dashboard page must be displayed$")
	public void the_dashboard_page_must_be_displayed() throws Throwable {
	}

}
