package hw3;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class Page1 {
	WebDriver driver;
	
	@FindBy(css = "li.dropdown.uui-profile-menu")
	WebElement loginIcon;
	@FindBy(css = "#name")
	WebElement login;
	@FindBy(css = "#password")
	WebElement password;
	@FindBy(css = "#login-button")
	WebElement enter;
	@FindBy(css = "#user-name")
	WebElement userName;
	@FindBy(css = "ul.uui-navigation.nav.navbar-nav.m-l8>li")
	List<WebElement> headerSection;
	@FindBy(css = ".benefit-icon")
    List<WebElement> images;
	@FindBy(css = ".benefit-txt")
    List<WebElement> imagesText;
	@FindBy(css=".main-title.text-center")
	WebElement mainTitle;
	@FindBy(css=".main-txt.text-center")
	WebElement mainText;
    @FindBy(css = "#second_frame")
	WebElement secondFrame;
    @FindBy(css = "img#epam-logo")
    WebElement frameLogo;
    @FindBy(css = "h3.text-center>a")
    WebElement subHeader;
    @FindBy(css = "ul.sidebar-menu")
    WebElement leftSection;
    @FindBy(css = "footer")
    WebElement footer;
    @FindBy(css = ".dropdown")
    WebElement serviceHeader;
    @FindBy(css = ".dropdown-menu a")
    List<WebElement>optionsHeader;
    @FindBy(css = ".menu-title")
    WebElement serviceLeft;
    @FindBy(css = "li.menu-title[index='3'] li[index]>a")
    List<WebElement>optionsLeft;
    @FindBy(css = "ul.sub>li[index='8']")
    WebElement different;
    
	public Page1(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public String getBrowserTitle() {
		return driver.getTitle();
	}

	
	public void performLogin(String username, String password) {
		this.loginIcon.click();
		this.login.sendKeys(username);
		this.password.sendKeys(password);
		this.enter.click();
	}
	
	public String getUserName() {
		return userName.getText();
	}
	
	public List<WebElement> getHeaderSection() {
		return headerSection;
	}
	
	public List<WebElement> getImages() {
		return images;
	}
	
	public List<WebElement> getImagesText() {
		return imagesText;
	}
	
	public String getMainTitle() {
		return mainTitle.getText();
	}
	
	public String getMainText() {
		return mainText.getText();
	}
	
	
	public boolean secondFrame(){
		return secondFrame.isDisplayed();
	}
	
	public void toSeconfFrame() {
		driver.switchTo().frame(secondFrame);
	}
	
	public boolean frameLogo(){
		return frameLogo.isDisplayed();
	}
	
	public void toOriginalWindow() {
		driver.switchTo().defaultContent();
	}
	
	
	public String getTextSubHeader() {
		return subHeader.getText();
	}
	
	public String getUrlSubHeader() {
		return subHeader.getAttribute("href");
	}
	
	
	public boolean leftSection(){
		return leftSection.isDisplayed();
	}
	
	public boolean footer(){
		return footer.isDisplayed();
	}
	
	public List<WebElement> getServiceHeader(){
		serviceHeader.click();
		return optionsHeader;
	}
	
	public List<WebElement> getServiceLeft(){
		serviceLeft.click();
		return optionsLeft;
	}
	
	public void clickDifferent(String name) {
		for(int i=0;i<optionsHeader.size();i++)
		{
			if(optionsHeader.get(i).getText().equals(name))
			{
				optionsHeader.get(i).click();
			}
		}
	}
	
}
