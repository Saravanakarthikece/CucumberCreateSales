package stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition {
	
	public ChromeDriver driver;
	
	@Given("Launch browser and load url and maximize the screen")
	public void launch_browser_and_load_url_and_maximize_the_screen() {
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");
		
		driver = new ChromeDriver(opt);
		opt.addArguments("--disable-notifications");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.get("https://login.salesforce.com");
	}
	@Given("Enter the username as {string}")
	public void enter_the_username_as(String uname) {
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(uname);
	}
	@Given("Enter the password as {string}")
	public void enter_the_password_as(String password) {
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
	}
	@When("Click on the Login button")
	public void click_on_the_login_button() {
		driver.findElement(By.id("Login")).click();
	}
	@When("Click on the toggle menu button in the left corner")
	public void click_on_the_toggle_menu_button_in_the_left_corner() {
		driver.findElement(By.xpath("//div[@class='slds-icon-waffle']")).click();
	}
	@When("Click on View All and select Sales from the App Launcher")
	public void click_on_view_all_and_select_sales_from_the_app_launcher() throws InterruptedException {
		driver.findElement(By.xpath("//button[@class='slds-button']")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//p[text()='Sales']")).click();
	}
	@When("Click on the Opportunity tab")
	public void click_on_the_opportunity_tab() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement Opp = driver.findElement(By.xpath("//span[text()='Opportunities']"));
		js.executeScript("arguments[0].click();", Opp);
	}
	@When("Click on the New button")
	public void click_on_the_new_button() {
		driver.findElement(By.xpath("//div[@title='New']")).click();
	}
	@When("Enter the Opportunity name as {string}")
	public void enter_the_opportunity_name_as(String name) {
		WebElement userName = driver.findElement(By.xpath("//input[@name='Name']"));
		userName.sendKeys(name);
		String UserName = userName.getAttribute("value");
		System.out.println("User name: "+UserName);
	}
	@When("Enter Amount as {string}")
	public void enter_amount_as(String num) {
		driver.findElement(By.xpath("//input[@name='Amount']")).sendKeys(num);
	}
	@When("Choose the close date as Today")
	public void choose_the_close_date_as_today() {
		driver.findElement(By.xpath("//input[@name='CloseDate']")).click();
		driver.findElement(By.xpath("//button[@name='today']")).click();
	}
	@When("Select Stage as Need Analysis")
	public void select_stage_as_need_analysis() throws InterruptedException {
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement stageClick = driver.findElement(By.xpath("(//div[@class='slds-combobox_container']/div/div/button)[2]"));
		js.executeScript("arguments[0].click();", stageClick);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@title='Needs Analysis']")).click();
		
	}
	@When("Click on the Save button")
	public void click_on_the_save_button() {
		driver.findElement(By.xpath("//button[@name='SaveEdit']")).click();
	}
	@Then("Verify the Opportunity Name as {string}")
	public void verify_the_opportunity_name (String name) throws InterruptedException {
		Thread.sleep(5000);
		String CreatedName = driver.findElement(By.xpath("//lightning-formatted-text[@slot='primaryField']")).getText();
		System.out.println("Created Opportunity Name: "+CreatedName);
		
		if(CreatedName.equalsIgnoreCase(name)) {
			System.out.println("The opportunity name has been successfully generated");
		}else {
			System.out.println("The attempt to generate the opportunity name was unsuccessful.");
		}

	}

}
