package hw3;

import org.testng.annotations.Test;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@Test
@CucumberOptions(plugin = {"pretty", "html:target/cucumber-report.html"}, 
               features = "src/test/ex1.feature")
public class RunTestEx1 extends AbstractTestNGCucumberTests{

}
