package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    private Burger burger;
    @Mock
    private Bun bun;
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient nextIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
    }

    @Test
    public void setBunsNotNull() {
        assertNotNull(burger.bun);
    }

    @Test
    public void setBuns() {
        Mockito.when(bun.getName()).thenReturn("булочка");
        assertEquals("булочка", burger.bun.getName());
    }


    @Test
    public void addIngredient() {
        assertFalse("Коллекция пустая", burger.ingredients.isEmpty());
    }

    @Test
    public void listIngredientsIsEmpty() {
        burger.ingredients.remove(0);
        assertTrue("Коллекция не пустая", burger.ingredients.isEmpty());
    }

    @Test
    public void removeIngredient() {
        ingredient = new Ingredient(IngredientType.SAUCE, "apple green", 11F);
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);

        assertEquals("Элемент не удален", "apple green", burger.ingredients.get(0).name);
    }

    @Test
    public void moveIngredient() {
        ingredient = new Ingredient(IngredientType.SAUCE, "apple green", 11F);
        burger.addIngredient(ingredient);
        burger.moveIngredient(0, 1);
        assertEquals("Элемент не перемещен", "apple green", burger.ingredients.get(0).name);
    }

    @Test
    public void getReceipt() {
        Mockito.when(bun.getName()).thenReturn("булочка");

        StringBuilder receipt = new StringBuilder(String.format("(==== %s ====)%n", burger.bun.getName()));

        for (Ingredient ingredient : burger.ingredients) {
            Mockito.when(ingredient.getName()).thenReturn("apple");
            Mockito.when(ingredient.getType()).thenReturn(IngredientType.SAUCE);
            receipt.append(String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(),
                    ingredient.getName()));
        }

        receipt.append(String.format("(==== %s ====)%n", burger.bun.getName()));
        Mockito.when(bun.getPrice()).thenReturn(50F);
        receipt.append(String.format("%nPrice: %f%n", burger.getPrice()));

        assertEquals(receipt.toString(), burger.getReceipt());
    }
}