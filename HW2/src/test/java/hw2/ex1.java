package hw2;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;

public class ex1
{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// System Property for Chrome Driver

		System.setProperty("webdriver.chrome.driver", "C:\\\\Java\\\\chromedriver_win32\\\\chromedriver.exe");

		// Instantiate a ChromeDriver class.
		WebDriver driver = new ChromeDriver();

		// Maximize the browser
		driver.manage().window().maximize();

		//1.Open test site by URL
		{
			driver.navigate().to("https://jdi-testing.github.io/jdi-light/index.html ");
		}

		//2.Assert Browser title
		{
			Assert.assertEquals("Home Page",driver.getTitle());
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
			Assert.assertEquals("ROMAN IOVLEV",driver.findElement(By.cssSelector("span[id=user-name]")).getText());
		}

		//5.Assert Browser title
		{
			Assert.assertEquals("Home Page",driver.getTitle());
		}

		//6.Assert that there are 4 items on the header section are displayed and they have proper texts
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("ul.uui-navigation.nav.navbar-nav.m-l8 > li"));

			Assert.assertEquals(elements.size(),4);
			Assert.assertEquals(elements.get(0).getText(),"HOME");
			Assert.assertEquals(elements.get(1).getText(),"CONTACT FORM");
			Assert.assertEquals(elements.get(2).getText(),"SERVICE");
			Assert.assertEquals(elements.get(3).getText(),"METALS & COLORS");
		}

		//7.Assert that there are 4 images on the Index Page and they are displayed
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("div.row.clerafix.benefits > div"));
			Assert.assertEquals(elements.size(),4);
			for(int i=0;i<elements.size();i++)
			{
				Assert.assertTrue(elements.get(i).isDisplayed());
			}
		}

		//8.Assert that there are 4 texts on the Index Page under icons and they have proper text
		{
			List<WebElement> elements = driver.findElements(By.cssSelector("div.row.clerafix.benefits .benefit-txt"));
			Assert.assertEquals(elements.size(),4);
			String[] strs = new String[]{"To include good practices\n" + "and ideas from successful\n" + "EPAM project",
					"To be flexible and\n" + "customizable",
					"To be multiplatform",
					"Already have good base\n" + "(about 20 internal and\n" +
							"some external projects),\n" + "wish to get more…"
			};

			for (int i=0;i<elements.size();i++) {
				Assert.assertEquals(strs[i], elements.get(i).getText());
			}
		}

		//9.Assert a text of the main headers
		{
			WebElement element1=driver.findElement(By.cssSelector("h3.main-title.text-center"));
			Assert.assertTrue(element1.isDisplayed());
			Assert.assertEquals(element1.getText(),"EPAM FRAMEWORK WISHES…");

			WebElement element2=driver.findElement(By.cssSelector("h3:nth-child(3) > a"));
			Assert.assertTrue(element2.isDisplayed());
			Assert.assertEquals(element2.getText(),"JDI GITHUB");
		}

		//10.Assert that there is the iframe in the center of page
		{
			List<WebElement> elements =driver.findElements(By.cssSelector("iframe"));
			//System.out.println(elements.size());
			Assert.assertFalse(elements.isEmpty());
		}

		//11.Switch to the iframe and check that there is Epam logo in the left top conner of iframe
		{
			driver.switchTo().frame("second_frame");
			WebElement element=driver.findElement(By.cssSelector("img#epam-logo"));
			Assert.assertTrue(element.isDisplayed());
		}

		//12.Switch to original window back
		{
			driver.switchTo().defaultContent();
		}

		//13.Assert a text of the sub header
		{
			WebElement element2=driver.findElement(By.cssSelector("h3:nth-child(3) > a"));
			Assert.assertTrue(element2.isDisplayed());
			Assert.assertEquals(element2.getText(),"JDI GITHUB");
		}

		//14.Assert that JDI GITHUB is a link and has a proper URL
		{
			WebElement element = driver.findElement(By.cssSelector(" h3:nth-child(3) > a"));
			Assert.assertTrue(element.isDisplayed());

			Assert.assertEquals(element.getAttribute("href"),"https://github.com/epam/JDI");

		}

		//15.Assert that there is Left Section
		{
			WebElement element = driver.findElement(By.cssSelector(" div.uui-side-bar.mCustomScrollbar._mCS_1.mCS_no_scrollbar"));
			Assert.assertTrue(element.isDisplayed());
		}
		{
			WebElement element = driver.findElement(By.cssSelector("body > footer"));
			Assert.assertTrue(element.isDisplayed());
		}
		// Step 17: Close Browser
		{
			driver.close();
		}

	}
}

