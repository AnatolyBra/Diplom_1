package praktikum;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class BunTest {

    private final Bun bun = new Bun("Giga", 100F);

    @Test
    public void getNameTest() {
        var actual = bun.getName();
        Assert.assertEquals("Метод getName работает не корректно", "Giga", actual);
    }

    @Test
    public void getPriceTest() {
        var actual = bun.getPrice();
        Assert.assertEquals("Метод getPrice работает не корректно", 100F, actual, 0);
    }
}