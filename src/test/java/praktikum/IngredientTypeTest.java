package praktikum;

import org.junit.Test;

import static org.junit.Assert.*;

public class IngredientTypeTest {

    @Test
    public void valueOfIngredientTypeSauceTest() {
        assertEquals(IngredientType.SAUCE, IngredientType.valueOf("SAUCE"));
    }

    @Test
    public void valueOfIngredientTypeFillingTest() {
        assertEquals(IngredientType.FILLING, IngredientType.valueOf("FILLING"));
    }

}