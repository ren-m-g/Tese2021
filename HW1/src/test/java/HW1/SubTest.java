package HW1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SubTest {
    Calculator calc;
    final double DELTA = 0.00001;

    @BeforeClass
    public void initCalculator() {
        calc = new Calculator();
    }
	
    @DataProvider
    public static Object[][] subLong() {
        return new Object[][] {
                {13L, 12L, 1L},
                {21L, -1L, 22L},
                {100L, 0L, 100L},
				{-2L,20L,-22L},
				{-3L,-10L,7L}
        };
    }

    @DataProvider
    public static Object[][] subDouble() {
        return new Object[][] {
                {3.0, 2.0, 1.0},
                {11.0, -1.0, 12.0},
                {120.0, 0.0, 120.0},
				{-20.0,10.0,-30.0},
				{-12.0,-11.0,-1.0}
        };
    }

    @Test( dataProvider = "subLong")
    public void testSubLong(Long a, Long b, Long res) {
        Assert.assertEquals(calc.sub(a, b), res.longValue());
    }

    @Test(dataProvider = "subDouble")
    public void testSubDouble(Double a, Double b, Double res) {
        Assert.assertEquals(calc.sub(a, b), res,DELTA);
    }

}