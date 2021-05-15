package hw3;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import hw3.PageComponents.Page2;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {

	WebDriver driver;
	Page1 page1;
	Page2 page2;
	Properties prop;
	@Before
	public void initTest() throws IOException {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromedriver.exe");
		driver=new ChromeDriver();
		page1=new Page1(driver);
		page2=new Page2(driver);
		prop = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(
				new File("src/test/data.properties")));
		prop.load(in);
	}

	// Step 1: Open test site by URL
	@Given("I open the page")
	public void openPage() {
		driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html ");
		driver.manage().window().maximize();
	}

	// Step 3: Perform login
	@And("I log as {string} - {string}")
	public void login(String username, String password) {
		page1.performLogin(username, password);
	}

	//4.Assert User name in the left-top side of screen that user is loggined
	@Then("Username is {string}")
	public void assertUserName(String userName) {
		Assert.assertEquals(page1.getUserName(),userName);
	}

	//5.Assert Browser title
	@Then("Browser title is {string}")
	public void assertBrowserTitle(String title) {
		Assert.assertEquals(page1.getBrowserTitle(),title);
	}

	//6.Assert that there are 4 items on the header section are displayed and they have proper texts
	@Then("4 items of header section have proper texts")
	public void assertImagesText() {
		List<WebElement>itemHeader=page1.getHeaderSection();
		Assert.assertEquals(String.valueOf(itemHeader.size()),prop.getProperty("countItemHeader"));
		for(int i=0;i<itemHeader.size();i++)
		{
			System.out.println(itemHeader.get(i).getText());
			System.out.println(prop.getProperty("itemHeader"+String.valueOf(i+1)));
			Assert.assertEquals(itemHeader.get(i).getText(),
					prop.getProperty("itemHeader"+String.valueOf(i+1)));
		}
	}


	//7.Assert that there are 4 images on the Index Page and they are displayed
	@Then("Images are displayed")
	public void assertImages() {
		Assert.assertEquals(String.valueOf(page1.getImages().size()), 
				prop.getProperty("countImage"));
		for(WebElement image:page1.getImages()) {
			image.isDisplayed();
		}
	}

	//8.Assert that there are 4 texts on the Index Page under icons and they have proper text
	@Then("There are {string} corresponding texts")
	public void assertCountTextImage(String count) {
		List<WebElement>imageTexts=page1.getImagesText();
		Assert.assertEquals(String.valueOf(imageTexts.size()),count);
		for(int i=0;i<imageTexts.size();i++)
		{
			Assert.assertEquals(imageTexts.get(i).getText(),
					prop.getProperty("imageText"+String.valueOf(i+1)));
		}
	}
	//9.Assert a text of the main headers
	@Then("First paragraph of main header has proper text")
	public void assertMainTitle(){
		Assert.assertEquals(page1.getMainTitle(),prop.getProperty("mainTitle"));
	}
	@Then("Second paragraph of main header has proper text")
	public void assertMainText(){
		Assert.assertEquals(page1.getMainText(),prop.getProperty("mainText"));
	}


	//10.Assert that there is the iframe in the center of page
	@Then("iframe in the center of page")
	public void assertSecondFrame() {
		Assert.assertTrue(page1.secondFrame());
	}


	//11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
	@When("Switch to the iframe")
	public void assertToSeconfFrame() {
		page1.toSeconfFrame();
	}
	@Then("Check EPAM logo")
	public void assertFrameLogo() {
		Assert.assertTrue(page1.frameLogo());
	}

	//12.Switch to original window back
	@And("Switch to home page")
	public void assertToOriginalWindow() {
		page1.toOriginalWindow();
	}

	//13.Assert a text of the sub header
	@Then("Text is {string}")
	public void assertTextSubHeader(String text) { 
		Assert.assertEquals(text,page1.getTextSubHeader());
	}

	//14.Assert that JDI GITHUB is a link and has a proper URL
	@Then("JDI GITHUB is a Link")
	public void assertLink() {
		Assert.assertEquals(page1.getUrlSubHeader(), prop.getProperty("urlSubHeader"));
	}

	//15.Assert that there is Left Section
	@Then("Left Section exists")
	public void assertLeftSection() {
		Assert.assertTrue(page1.leftSection());
	}

	//16.Assert that there is Footer
	@Then("Footer exists")
	public void assertLeFooter() {
		Assert.assertTrue(page1.footer());
	}


	// Now begin Step defines of ex2
	// 5: Click on "Service" subcategory in the header and check that drop down contains options
	@Then("Drop down options of top Service have proper values")
	public void assertServiceHeader() {
		List<WebElement>serviceHeader=page1.getServiceHeader();
		Assert.assertEquals(serviceHeader.size(),9);
		for(int i=0;i<serviceHeader.size();i++)
		{
			Assert.assertEquals(serviceHeader.get(i).getText(),
					prop.getProperty("optionHeaderService"+String.valueOf(i+1)));
		}
	}

	//6.Click on Service subcategory in the left section and check that drop down contains options
	@Then("Drop down options of left Service have proper values")
	public void assertServiceLeft() {
		List<WebElement>serviceLeft=page1.getServiceLeft();
		Assert.assertEquals(serviceLeft.size(),9);
		for(int i=0;i<serviceLeft.size();i++)
		{
			Assert.assertEquals(serviceLeft.get(i).getText(),
					prop.getProperty("optionLeftService"+String.valueOf(i+1)));
		}
	}

	//7.Open through the header menu Service -> Different Elements Page
	@Given("Open Different Elements Page")
	public void assertClickDifferent() {
		page1.getServiceLeft();
		page1.clickDifferent("DIFFERENT ELEMENTS");
	}


	//8.Check interface on Different elements page, it contains all needed elements
	@Then("There are 4 checkboxes")
	public void assertCheckboxes() {
		Assert.assertEquals(page2.mainElements.getCheckbox().size(), 4);
	}

	@Then("There are 4 radios")
	public void assertRadios() {
		Assert.assertEquals(page2.mainElements.getRadio().size(), 4);
	}

	@Then("There are 1 dropdown")
	public void assertDropdown() {
		Assert.assertEquals(page2.mainElements.getSelect().size(), 1);
	}

	@Then("There are 2 buttons")
	public void assertButtons() {
		Assert.assertEquals(page2.mainElements.getButton().size(), 2);
	}
	//9.Assert that there is Right Section
	@Then("Right Section displayed")
	public void assertRightSection() {
		Assert.assertTrue(page2.rightSection.rightSection());
	}

	//10.Assert that there is Left Section
	@Then("Left Section displayed")
	public void assertLeftSection2() {
		Assert.assertTrue(page2.leftSection.leftSection());
	}
	//11.Select checkboxes
	//12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
	@Given("Checkboxes Water selected")
	public void assertClickWater() {
		page2.mainElements.clickCheckbox("Water");
	}

	@Then("Display the information that Water is selected on the log")
	public void assertLogWater() {
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternWaterTrue")
				, page2.rightSection.getNewLog()));
	}

	@Given("Checkboxes Wind selected")
	public void assertClickWind() {
		page2.mainElements.clickCheckbox("Wind");
	}

	@Then("Display the information that Wind is selected on the log")
	public void assertLogWind() {
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternWindTrue")
				, page2.rightSection.getNewLog()));
	}

	//13.Select radio
	@Given("Radio Selen is selected")
	public void assertClickSelen() {
		page2.mainElements.clickRadio("Selen");
	}

	//14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
	@Then("Status of radios in Log row is displayed and corresponding")
	public void assertLogSelen() {
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternSelenTrue")
				, page2.rightSection.getNewLog()));
	}

	//15.Select in dropdown
	@Given("Yellow in dropdown is selected")
	public void assertSelectColor() {
		page2.mainElements.selectColors("Yellow");
	}
	//16.Assert that for dropdown there is a log row and value is corresponded to the selected value.
	@Then("Status of dropdown in Log row is displayed and corresponding")
	public void assertLogYellow() {
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternYellow")
				, page2.rightSection.getNewLog()));
	}

	//17.Unselect and assert checkboxes
	//18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
	@Given("Checkboxes Water selected Again")
	public void assertClickWaterAgain() {
		page2.mainElements.clickCheckbox("Water");
	}

	@Then("Display the information that Water is selected on the log Again")
	public void assertLogWaterAgain() {
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternWaterFalse")
				, page2.rightSection.getNewLog()));
	}

	@Given("Checkboxes Wind selected Again")
	public void assertClickWindAgain() {
		page2.mainElements.clickCheckbox("Wind");
	}

	@Then("Display the information that Wind is selected on the log Again")
	public void assertLogWindAgain() {
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternWindFalse")
				, page2.rightSection.getNewLog()));
	}





}
