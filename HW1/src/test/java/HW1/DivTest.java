package HW1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DivTest {
    Calculator calc;
    final double DELTA = 0.00001;
	
	@BeforeClass
    public void initCalculator() {
        calc = new Calculator();
    }
	
	@DataProvider
    public static Object[][] divLong() {
        return new Object[][]{
                {10L, 5L, 2L}, 
				{100L, -10L, -10L},
				{-20L, 4L, -5L},
				{-4L,-2L,2L},
				{0L, 5L, 0L}
        };
    }
	@DataProvider
    public static Object[][] divDouble() {
        return new Object[][]{
			    {10.0, 5.0, 2.0},
                {100.0, -10.0, -10.0},
			    {-20.0, 4.0, -5.0},
				{-4.0,-2.0,2.0},
				{0.0, 5.0, 0.0},
				{3.0,0.0,3.0/0.0},
				{0.0,0.0,0.0/0.0}
		}; 
	}
	
    @Test( dataProvider = "divLong")
    public void testSubLong(Long a, Long b, Long res) {
        Assert.assertEquals(calc.div(a, b), res.longValue());
    }

    @Test(dataProvider = "divDouble")
    public void testSubDouble(Double a, Double b, Double res) {
        Assert.assertEquals(calc.div(a, b), res,DELTA);
    }
}