package HW1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class MultTest {
    Calculator calc;
    final double DELTA = 0.00001;
	
	@BeforeClass
    public void initCalculator() {
        calc = new Calculator();
    }
	
	@DataProvider
    public static Object[][] mulLong() {
        return new Object[][]{
			    {1L,2L,2L},
				{0L,2L,0L},
				{-5L,4L,-20L},
				{-10L,-3L,30L}
        };
    }
	@DataProvider
    public static Object[][] mulDouble() {
        return new Object[][]{
			    {1.0,2.0,2.0},
				{0.0,2.0,0.0},
				{-5.0,4.0,-20.0},
				{-10.0,-3.0,30.0}
		};	 
	}
	

    @Test( dataProvider = "mulLong")
    public void testSubLong(Long a, Long b, Long res) {
        Assert.assertEquals(calc.mult(a, b), res.longValue());
    }

    @Test(dataProvider = "mulDouble")
    public void testSubDouble(Double a, Double b, Double res) {
        Assert.assertEquals(calc.mult(a, b), res,DELTA);
    }
}