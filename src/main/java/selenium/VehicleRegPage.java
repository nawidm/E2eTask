package selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class VehicleRegPage {
	
	@FindBy(className = "form-control form-control-1-4 input-upper")
	WebElement inputBox;
	
	@FindBy(className = "button")
	WebElement confirmBtn;
	
	public void inputVehicleReg(String input) {
		inputBox.sendKeys(input);
	}
	
	public void pressConfirm(WebDriver driver) {
		Actions action = new Actions(driver);
		action.moveToElement(confirmBtn).click().perform();
	}
}
