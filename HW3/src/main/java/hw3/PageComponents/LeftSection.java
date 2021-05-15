package hw3.PageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftSection {
	@FindBy(css="#mCSB_1")
	WebElement leftSection;
	
	public LeftSection(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public boolean leftSection() {
		return leftSection.isDisplayed();
	}
}
