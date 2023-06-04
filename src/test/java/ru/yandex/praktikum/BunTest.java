package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Bun;
@RunWith(Parameterized.class)
public class BunTest {
    private final String name;
    private final float price;

    public BunTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}: {1}")
    public static Object[][] dataForTest() {
        return new Object[][]{
                {"Флюоресцентная булка R2-D3", 988},
                {"Краторная булка N-200i", 1255},
                {"Булочка с кунжутом", 0},
                {"Стандартная", -1},
                {"Бриошь", 0.1f},
        };
    }

    @Test
    public void checkBunNameTest() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(name, bun.getName());
    }

    @Test
    public void checkBunNamePrice() {
        Bun bun = new Bun(name, price);
        Assert.assertEquals(price, bun.getPrice(),0);
    }
}

