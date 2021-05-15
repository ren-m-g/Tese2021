package hw3.PageComponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;



public class Page2 {
	public MainElements mainElements;
	public LeftSection leftSection;
	public RightSection rightSection;
	public Page2(WebDriver driver){
		mainElements=new MainElements(driver);
		leftSection=new LeftSection(driver);
		rightSection=new RightSection(driver);
		PageFactory.initElements(driver, this);
	}
}
