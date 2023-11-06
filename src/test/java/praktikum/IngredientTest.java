package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTest {

    private final Ingredient ingredient = new Ingredient(IngredientType.SAUCE, "apple", 100F);

    @Test
    public void getPriceTest() {
        var actual = ingredient.getPrice();
        Assert.assertEquals("Метод getPrice работает не корректно", 100F, actual, 0);
    }

    @Test
    public void getNameTest() {
        var actual = ingredient.getName();
        Assert.assertEquals("Метод getName работает не корректно", "apple", actual);
    }

    @Test
    public void getIngredientTypeTest() {
        var actual = ingredient.getType();
        Assert.assertEquals("Метод getType работает не корректно", IngredientType.SAUCE, actual);
    }
}