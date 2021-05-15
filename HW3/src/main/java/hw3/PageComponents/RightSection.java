package hw3.PageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RightSection {
	@FindBy(css="#mCSB_2")
	WebElement rightSection;
	@FindBy(css="ul.panel-body-list.logs li")
	List<WebElement>logs;
	public RightSection(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public boolean rightSection() {
		return rightSection.isDisplayed();
	}
	public String getNewLog() {
		return logs.get(0).getText();
	}
}
