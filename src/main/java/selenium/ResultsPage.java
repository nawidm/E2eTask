package selenium;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ResultsPage {
	@FindBy(xpath = "//*[@id=\"pr3\"]/div/ul/li[2]/span[2]/strong")
	WebElement make;
	
	@FindBy(xpath = "//*[@id=\"pr3\"]/div/ul/li[3]/span[2]/strong")
	WebElement colour;
	
	public String getMakeValue() {
		return make.getText();
	}
	
	public String getColourValue() {
		return colour.getText();
	}
}
