package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;
    Bun bun;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}: {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 0},
                {"Стандартная", -1},
                {"black bun", 100f},
                {"white bun", 200f},
                {"red bun", 300f},
        };
    }
    @Before
    public void newBun() {
        bun = new Bun(name, price);
    }
    @Test
    public void checkBunNameTest() {
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void checkBunNamePrice() {
        Assert.assertEquals(price, bun.getPrice(),0);
    }
}

