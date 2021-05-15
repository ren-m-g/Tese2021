package hw3.PageComponents;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainElements {
	@FindBy(css = ".checkbox-row  .label-checkbox")
	List<WebElement>checkbox;
	@FindBy(css=".checkbox-row .label-radio")
	List<WebElement>radio;
	@FindBy(css="select")
	List<WebElement>select;
	@FindBy(css="select.uui-form-element>option")
	List<WebElement>colors;
	@FindBy(css=".main-content .uui-button")
	List<WebElement>button;
	
	public MainElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	public List<WebElement> getCheckbox(){
		return checkbox;
	}
	public List<WebElement> getRadio(){
		return radio;
	}
	public List<WebElement> getSelect(){
		return select;
	}
	public List<WebElement> getButton(){
		return button;
	}
	
	public void clickCheckbox(String name) {
		for(int i=0;i<checkbox.size();i++)
		{
			if(checkbox.get(i).getText().equals(name))
			{
				checkbox.get(i).click();
			}
		}
	}
	
	public void clickRadio(String name) {
		for(int i=0;i<radio.size();i++)
		{
			if(radio.get(i).getText().equals(name))
			{
				radio.get(i).click();
			}
		}
	}
	
	public void selectColors(String color) {
		for(int i=0;i<colors.size();i++)
		{
			if(colors.get(i).getText().equals(color))
			{
				colors.get(i).click();
			}
		}
	}
	
	
}
