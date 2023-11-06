package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.MockitoAnnotations.initMocks;

@RunWith(Parameterized.class)
public class BurgerPriceTest {

    private final float priceBun;
    private final float priceIngredient;
    private Burger burger;
    @Mock
    private Bun bun;

    public BurgerPriceTest(float priceBun, float priceIngredient) {
        this.priceBun = priceBun;
        this.priceIngredient = priceIngredient;
    }

    @Parameterized.Parameters
    public static Object[][] getQuest() {
        return new Object[][]{
                {50F, 10F},
                {70F, 30F},
                {46F, 90F}
        };
    }

    @Before
    public void setUp() {
        initMocks(this);
        burger = new Burger();
        burger.setBuns(bun);
        Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "apple", priceIngredient);
        burger.addIngredient(ingredient);
    }

    @Test
    public void getPrice() {
        Mockito.when(burger.bun.getPrice()).thenReturn(priceBun);
        float price = burger.bun.getPrice() * 2;

        for (Ingredient ingredient : burger.ingredients) {
            price += ingredient.getPrice();
        }

        assertEquals(price, burger.getPrice(), 0);
    }

}
