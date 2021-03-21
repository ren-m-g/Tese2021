package HW1;

import com.epam.tat.module4.Calculator;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddTest {
    Calculator calc;
    final double DELTA = 0.00001;

    @BeforeClass
    public void initCalculator() {
        calc = new Calculator();
    }
	
    @DataProvider
    public static Object[][] addLong() {
        return new Object[][] {
                {1L, 2L, 3L},
                {1L, -1L, 0L},
                {100L, 0L, 100L}
				
        };
    }

    @DataProvider
    public static Object[][] addDouble() {
        return new Object[][] {
                {11.0, 22.0, 33.0},
                {11.0, -1.0, 10.0},
				{101.0,0.0,101.0}
        };
    }


    @Test(dataProvider = "addLong"
    )
    public void testAddLong(Long a, Long b, Long res) {
        Assert.assertEquals(calc.sum(a, b), res.longValue());
    }

    @Test(dataProvider = "addDouble")
    public void testAddDouble(Double a, Double b, Double res) {
        Assert.assertEquals(calc.sum(a, b), res,DELTA);
    }

}