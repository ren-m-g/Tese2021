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






public class AppTest 
{
	WebDriver driver;
	Page1 page1;
	Page2 page2;
	Properties prop;
	@BeforeClass
	public void initTest() throws IOException {
		driver=new ChromeDriver();
		page1=new Page1(driver);
		page2=new Page2(driver);
		prop = new Properties();
		InputStream in = new BufferedInputStream(new FileInputStream(
				new File("src/test/data.properties")));
		prop.load(in);
		
		System.out.println(prop.getProperty("url"));
	}
	@Test
	public void openPage() {
		driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html ");
		driver.manage().window().maximize();
		page1.performLogin("Roman", "Jdi1234");
		Assert.assertEquals(page1.getUserName(),"ROMAN IOVLEV");
		List<WebElement>serviceHeader=page1.getServiceHeader();
		Assert.assertEquals(serviceHeader.size(),9);
		for(int i=0;i<serviceHeader.size();i++)
		{
			Assert.assertEquals(serviceHeader.get(i).getText(),
					prop.getProperty("optionHeaderService"+String.valueOf(i+1)));
		}
		
		List<WebElement>serviceLeft=page1.getServiceLeft();
		Assert.assertEquals(serviceLeft.size(),9);
		for(int i=0;i<serviceLeft.size();i++)
		{
			Assert.assertEquals(serviceLeft.get(i).getText(),
					prop.getProperty("optionLeftService"+String.valueOf(i+1)));
		}
		System.out.println("asdfg");
		page1.clickDifferent("DIFFERENT ELEMENTS");
		Assert.assertEquals(page2.mainElements.getCheckbox().size(), 4);
		Assert.assertEquals(page2.mainElements.getRadio().size(), 4);
		Assert.assertEquals(page2.mainElements.getSelect().size(), 1);
		Assert.assertEquals(page2.mainElements.getButton().size(), 2);
		Assert.assertTrue(page2.rightSection.rightSection());
		Assert.assertTrue(page2.leftSection.leftSection());
		page2.mainElements.clickCheckbox("Water");
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternWaterTrue")
				, page2.rightSection.getNewLog()));
		page2.mainElements.clickCheckbox("Wind");
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternWindTrue")
				, page2.rightSection.getNewLog()));
		page2.mainElements.clickRadio("Selen");
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternSelenTrue")
				, page2.rightSection.getNewLog()));
		page2.mainElements.selectColors("Yellow");
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternYellow")
				, page2.rightSection.getNewLog()));
		page2.mainElements.clickCheckbox("Water");
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternWaterFalse")
				, page2.rightSection.getNewLog()));
		page2.mainElements.clickCheckbox("Wind");
		Assert.assertTrue(Pattern.matches(prop.getProperty("patternWindFalse")
				, page2.rightSection.getNewLog()));
		driver.close();
	}

}
