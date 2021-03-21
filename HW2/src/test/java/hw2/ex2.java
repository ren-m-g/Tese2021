package hw2;

import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.asserts.SoftAssert;
import org.testng.Assert;


public class ex2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System Property for Chrome Driver

		System.setProperty("webdriver.chrome.driver", "C:\\\\Java\\\\chromedriver_win32\\\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();
		SoftAssert softAssert = new SoftAssert();
		// Maximize the browser
		driver.manage().window().maximize();

		//1.Open test site by URL
		{
			driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html");
		}

		//2.Assert Browser title
		{
			softAssert.assertEquals("Home Page",driver.getTitle());
		}


		//3.Perform login
		{
			driver.findElement(By.cssSelector("img[id=user-icon]")).click();
			driver.findElement(By.cssSelector("input[id=name]")).click();
			driver.findElement(By.cssSelector("input[id=name]")).sendKeys("Roman");
			driver.findElement(By.cssSelector("input[id=password]")).click();
			driver.findElement(By.cssSelector("input[id=password]")).sendKeys("Jdi1234");
			driver.findElement(By.cssSelector("button[type=submit]")).click();
		}

		//4.Assert User name in the left-top side of screen that user is loggined
		{
			softAssert.assertEquals("ROMAN IOVLEV",driver.findElement(By.cssSelector("span[id=user-name]")).getText());
		}

		//5.Click on "Service" subcategory in the header and check that drop down contains options
		{
			driver.findElement(By.cssSelector(" li.dropdown")).click();
			List<WebElement> elements = driver.findElements(By.cssSelector("li.dropdown > ul > li"));
			String strs[]= {"SUPPORT", "DATES","SEARCH","COMPLEX TABLE","SIMPLE TABLE","USER TABLE","TABLE WITH PAGES", 
					"DIFFERENT ELEMENTS","PERFORMANCE"};
			for(int i=0;i<elements.size();i++)
			{
				softAssert.assertEquals(elements.get(i).getText(), strs[i]);
			}
		}

		//6.Click on Service subcategory in the left section and check that drop down contains options
		{
			driver.findElement(By.cssSelector("#mCSB_1_container > ul > li:nth-child(3)")).click();
			List<WebElement> elements = driver.findElements(By.cssSelector("#mCSB_1_container > ul > li:nth-child(3) > ul > li"));
			String strs[]= {"Support", "Dates","Complex Table","Simple Table","Search","User Table","Table with pages", 
					"Different elements","Performance"};
			for(int i=0;i<elements.size();i++)
			{
				softAssert.assertEquals(elements.get(i).getText(), strs[i]);
			}
		}

		//7.Open through the header menu Service -> Different Elements Page
		{
			driver.findElement(By.cssSelector("#mCSB_1_container > ul > li:nth-child(3) > ul > li:nth-child(8) > a > span")).click();
		}

		//8.Check interface on Different elements page
		{
			//4 checkboxes
			{
				List<WebElement> elements = driver.findElements(By.cssSelector("input[type=checkbox]"));
				Assert.assertEquals(elements.size(),4);
				for(int i=0;i<elements.size();i++)
				{
					softAssert.assertTrue(elements.get(i).isDisplayed());
				}
			}

			//4 radios
			{
				List<WebElement> elements = driver.findElements(By.cssSelector("input[type=radio]"));
				Assert.assertEquals(elements.size(),4);
				for(int i=0;i<elements.size();i++)
				{
					softAssert.assertTrue(elements.get(i).isDisplayed());
				}
			}

			// 1 dropdown
			{
				List<WebElement> elements = driver.findElements(By.cssSelector("select"));
				Assert.assertEquals(elements.size(),1);
				softAssert.assertTrue(elements.get(0).isDisplayed());
			}

			//2 buttons
			{
				WebElement element1=driver.findElement(By.cssSelector("button.uui-button"));
				softAssert.assertTrue(element1.isDisplayed());

				WebElement element2=driver.findElement(By.cssSelector("input.uui-button"));
				softAssert.assertTrue(element2.isDisplayed());
			}
		}

		//9.Assert that there is Right Section
		{
			WebElement element=driver.findElement(By.cssSelector("div[name=log-sidebar]"));
			softAssert.assertTrue(element.isDisplayed());
		}

		//10.Assert that there is Left Section
		{
			WebElement element=driver.findElement(By.cssSelector("div[name=navigation-sidebar]"));
			softAssert.assertTrue(element.isDisplayed());
		}

		//11.Select checkboxes
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("label.label-checkbox"));
			softAssert.assertTrue(elements.isEmpty());
			for(int i=0;i<elements.size();i++)
			{
				if(elements.get(i).getText().equals("Water") || elements.get(i).getText().equals("Wind"))
				{
					elements.get(i).click();
				}
			}
		}

		//12.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("ul.panel-body-list.logs li"));
			softAssert.assertTrue(elements.isEmpty());
			softAssert.assertTrue(Pattern.matches("[0-9]+:[0-9]+:[0-9]+ Water: condition changed to true",elements.get(0).getText()));
			softAssert.assertTrue(Pattern.matches("[0-9]+:[0-9]+:[0-9]+ Wind: condition changed to true",elements.get(1).getText()));

		}

		//13.Select radio
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("label.label-radio"));
			for(int i=0;i<elements.size();i++)
			{
				if(elements.get(i).getText().equals("Celen"))
				{
					elements.get(i).click();
				}
			}
		}

		//14.Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("ul.panel-body-list.logs li"));
			softAssert.assertTrue(elements.isEmpty());
			softAssert.assertTrue(Pattern.matches("[0-9]+:[0-9]+:[0-9]+ metal: value changed to Selen",elements.get(0).getText()));   
		}

		//15.Select in dropdown
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("select.uui-form-element>option"));
			for(int i=0;i<elements.size();i++)
			{
				if(elements.get(i).getText().equals("Yellow"))
				{
					elements.get(i).click();
				}
			}
		}

		//16.Assert that for dropdown there is a log row and value is corresponded to the selected value.
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("ul.panel-body-list.logs li"));
			softAssert.assertTrue(elements.isEmpty());
			softAssert.assertTrue(Pattern.matches("[0-9]+:[0-9]+:[0-9]+ Colors: value changed to Yellow",elements.get(0).getText()));   
		}

		//17.Unselect and assert checkboxes
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("label.label-checkbox"));
			softAssert.assertTrue(elements.isEmpty());
			for(int i=0;i<elements.size();i++)
			{
				if(elements.get(i).getText().equals("Water") || elements.get(i).getText().equals("Wind"))
				{
					elements.get(i).click();
				}
			}
		}

		//18.Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox. 
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("ul.panel-body-list.logs li"));
			softAssert.assertTrue(elements.isEmpty());
			softAssert.assertTrue(Pattern.matches("[0-9]+:[0-9]+:[0-9]+ Water: condition changed to false",elements.get(0).getText()));
			softAssert.assertTrue(Pattern.matches("[0-9]+:[0-9]+:[0-9]+ Wind: condition changed to false",elements.get(1).getText()));
		}



		{
			driver.close();
		}
	}
}
