package com.capgemini.onlinehotelbooking.bdd;

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

	@Given("^the admin has loaded the application in the browser$")
	public void the_admin_has_loaded_the_application_in_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^admin click on login link$")
	public void admin_click_on_login_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters valid email in the emailbox$")
	public void the_admin_enters_valid_email_in_the_emailbox() throws Throwable {
		driver.findElement(By.name("email")).sendKeys("simmimulani1221@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters valid password in the password textbox$")
	public void the_admin_enters_valid_password_in_the_password_textbox() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("Simmi1221");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin clicks on the login button$")
	public void the_admin_clicks_on_the_login_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-loginadmin/div[2]/form/div/div/div[2]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the dashboard page must be displayed$")
	public void the_dashboard_page_must_be_displayed() throws Throwable {
		//driver.findElement(By.xpath("//a[text()='HOME']"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/********************************
	 * Delete Hotel Operation
	 ***************************************************/

	@When("^click on HOTELLIST link$")
	public void click_on_HOTELLIST_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='HOTELLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on the DELETE button$")
	public void click_on_the_DELETE_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-hotellist/div[2]/table/tbody/tr[7]/td[7]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^selected hotel details must be deleted$")
	public void selected_hotel_details_must_be_deleted() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/div/a[3]")).click();
	}

	/********************************
	 * Add Hotel Operation
	 ***************************************************/

	@When("^click on the HOTELLIST link$")
	public void click_on_the_HOTELLIST_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='HOTELLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on the ADD HOTEL button$")
	public void click_on_the_ADD_HOTEL_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-hotellist/div[1]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter hotel name in textbox$")
	public void enter_hotel_name_in_textbox() throws Throwable {
		driver.findElement(By.name("hotelName")).sendKeys("Sansruti");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter location in textbox$")
	public void enter_location_in_textbox() throws Throwable {
		driver.findElement(By.name("location")).sendKeys("Nidah Nagar,MG-Road,Pune");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter image url in textbox$")
	public void enter_image_url_in_textbox() throws Throwable {
		driver.findElement(By.name("imageUrl")).sendKeys("sdfghjkljhgdfghj.jpg");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter mobile number in textbox$")
	public void enter_mobile_number_in_textbox() throws Throwable {
		driver.findElement(By.name("phoneNo")).sendKeys("8788151739");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on submit button$")
	public void click_on_submit_button() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[2]/form/div[5]/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@When("^close the ADD HOTEL pop up$")
	public void close_the_ADD_HOTEL_pop_up() throws Throwable {
		driver.findElement(By.xpath("//*[@id=\"exampleModal\"]/div/div/div[1]/div/button/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^entered hotel details must be added$")
	public void entered_hotel_details_must_be_added() throws Throwable {
		driver.findElement(By.xpath("//a[text()='HOTELLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/********************************
	 * Delete Room Operation
	 ***************************************************/
	
	@When("^click on the ROOMLIST link$")
	public void click_on_the_ROOMLIST_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='ROOMLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on DELETE button$")
	public void click_on_DELETE_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-roomlist/div/table/tbody/tr[6]/td[9]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Then("^selected room must be deleted$")
	public void selected_room_must_be_deleted() throws Throwable {
		driver.findElement(By.xpath("//a[text()='ROOMLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/********************************
	 * Add Room Operation
	 ***************************************************/
	
	@When("^click on ADDROOM link$")
	public void click_on_ADDROOM_link() throws Throwable {
		driver.findElement(By.xpath("//a[text()='ADDROOM']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid hotel id in textbox$")
	public void enter_valid_hotel_id_in_textbox() throws Throwable {
		driver.findElement(By.name("hotelId")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid hotel name in textbox$")
	public void enter_valid_hotel_name_in_textbox() throws Throwable {
		driver.findElement(By.name("hotelName")).sendKeys("Leela Palace");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid room id in textbox$")
	public void enter_valid_room_id_in_textbox() throws Throwable {
		driver.findElement(By.name("roomId")).sendKeys("201");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^select room type$")
	public void select_room_type() throws Throwable {
		driver.findElement(By.name("roomType")).sendKeys("AC Classic(2x)");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^select room capacity$")
	public void select_room_capacity() throws Throwable {
		driver.findElement(By.name("roomCapacity")).sendKeys("2");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^select room status$")
	public void select_room_status() throws Throwable {
		driver.findElement(By.name("roomStatus")).sendKeys("select");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid room rent textbox$")
	public void enter_valid_room_rent_textbox() throws Throwable {
		driver.findElement(By.name("roomRent")).sendKeys("1200");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^enter valid image url in  textbox$")
	public void enter_valid_image_url_in_textbox() throws Throwable {
		driver.findElement(By.name("imageUrl")).sendKeys("sdfghj.jpg");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^click on the submit button$")
	public void click_on_the_submit_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-addroom/div/form/div/div/div[10]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^entered room details must displayed in roomlist$")
	public void entered_room_details_must_displayed_in_roomlist() throws Throwable {
		driver.findElement(By.xpath("//a[text()='ROOMLIST']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


}
