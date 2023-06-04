package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static ru.yandex.praktikum.IngredientType.*;

@RunWith(Parameterized.class)
public class IngredientTest {
    private final IngredientType IngredientType;
    private Ingredient ingredient;
    private final String name;
    private final float price;

    public IngredientTest(IngredientType IngredientType, String name, float price) {
        this.IngredientType = IngredientType;
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "Тестовые данные: {0}: {1}: {2}")
    public static Object[][] getParameters() {
        return new Object[][]{
                {SAUCE, "Соус Spicy-X", 90f},
                {SAUCE, "Соус фирменный Space Sauce", 80.1f},
                {SAUCE, "Соус традиционный галактический", -15f},
                {SAUCE, "Соус с шипами Антарианского плоскоходца", 0f},
                {SAUCE, "null", 1},
                {SAUCE, null, 1337f},
                {null, "Сырный соус", 25f},
                {FILLING, "Говяжий метеорит (отбивная)", 3000f},
                {FILLING, "Биокотлета из марсианской Магнолии", -424f},
                {FILLING, "Филе Люминесцентного тетраодонтимформа", 0f},
                {FILLING, "Хрустящие минеральные кольца", 30.1f},
                {FILLING, "null", 874f},
                {FILLING, null, 762f},
                {FILLING, "Qwerty 1234_!@#$", 4142f},
        };
    }

    @Before
    public void newIngredient() {
        ingredient = new Ingredient(IngredientType, name, price);
    }

    @Test
    public void getPriceTest() {
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(price, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String actualName = ingredient.getName();
        Assert.assertEquals(name, actualName);
    }

    @Test
    public void getTypeTest() {
        IngredientType expectedType = IngredientType;
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(expectedType, actualType);
    }
}
