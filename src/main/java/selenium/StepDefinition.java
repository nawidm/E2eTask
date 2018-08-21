package selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class StepDefinition {
	WebDriver driver;
	static ExtentReports extent;
	ExtentTest test;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "/Users/nawidmujadidi/Documents/E2e/project/chromedriver.exe");
		extent = new ExtentReports("/Users/nawidmujadidi/Documents/E2e/project/extent.html", true);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		String url = "https://www.gov.uk/get-vehicle-information-from-dvla";
		driver.navigate().to(url);
		test = extent.startTest("Testing Gov vehicle enquiry service");	
	}
	
	@Given("^I press start on the mainpage$")
	public void pressStart() {
		HomePage homePage = PageFactory.initElements(driver, HomePage.class);
		
		homePage.ClickStartBtn(driver);
		test.log(LogStatus.INFO, "Pressed start");

	}
	
	
	@When("^I enter car registration number$")
	public void enterVehicleRegNo() {
		VehicleRegPage vehicleRegPage = PageFactory.initElements(driver, VehicleRegPage.class);
		vehicleRegPage.inputVehicleReg("YP58UAZ");
		test.log(LogStatus.INFO, "Registration number entered");

	}
	
	@And("^I click confirm button$")
	public void clickConfirm() {
		VehicleRegPage vehicleRegPage = PageFactory.initElements(driver, VehicleRegPage.class);
		vehicleRegPage.pressConfirm(driver);
		test.log(LogStatus.INFO, "Confirm button pressed");
	}

	
	@Then("^I can see details of the relevant car$")
	public void checkDetailsAreShown() {
		ResultsPage resultsPage = PageFactory.initElements(driver, ResultsPage.class);
		try {
			assertTrue(resultsPage.getMakeValue().equals("TOYOTA") && resultsPage.getColourValue().equals("SILVER"));
			test.log(LogStatus.PASS, "Details match");
		} catch (AssertionError e) {
			test.log(LogStatus.FAIL, "Vehicle details do not match ");
		}
		
	}
	
	@After
	public void tearDown() {
		driver.quit();
		extent.endTest(test);
	}
}
