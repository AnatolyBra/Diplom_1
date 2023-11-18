package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static config.ConfigApp.ZERO_DELTA;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunTest {
    private final String expectedName;
    private final float expectedPrice;

    public BunTest(String expectedName, float expectedPrice) {
        this.expectedName = expectedName;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters
    public static Object[][] getBunData() {
        return new Object[][]{
                {"Краторная булка N-200i", Float.MAX_VALUE},
                {"crater bun N-200i", Float.MIN_VALUE},
                {"", 100.5f},
                {null, 10f},
                {"!@#$%^&*()_+{}[]:", 900f},
                {"Флюоресцентная булка R2-D3", ZERO_DELTA},
        };
    }


    @Test
    public void getName() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedName, bun.getName());
    }

    @Test
    public void getPrice() {
        Bun bun = new Bun(expectedName, expectedPrice);
        assertEquals(expectedPrice, bun.getPrice(), ZERO_DELTA);
    }
}