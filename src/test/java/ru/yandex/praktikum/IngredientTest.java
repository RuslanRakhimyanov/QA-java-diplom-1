package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.*;

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
                {SAUCE, "Соус фирменный Space Sauce", 80f},
                {SAUCE, "Соус традиционный галактический", 15f},
                {SAUCE, "Соус с шипами Антарианского плоскоходца", 88f},
                {SAUCE, "Сырный соус", 25f},
                {FILLING, "Мясо бессмертных моллюсков Protostomia", 1337f},
                {FILLING, "Говяжий метеорит (отбивная)", 3000f},
                {FILLING, "Биокотлета из марсианской Магнолии", 424f},
                {FILLING, "Филе Люминесцентного тетраодонтимформа", 988f},
                {FILLING, "Хрустящие минеральные кольца", 300f},
                {FILLING, "Плоды Фалленианского дерева", 874f},
                {FILLING, "Кристаллы марсианских альфа-сахаридов", 762f},
                {FILLING, "Мини-салат Экзо-Плантаго", 4400f},
                {FILLING, "Сыр с астероидной плесенью", 4142f},
                {FILLING, "chicken cutlet", 700f},
        };
    }

    @Before
    public void newIngredient() {
        ingredient = new Ingredient(IngredientType, name, price);
    }

    @Test
    public void getPriceTest() {
        float expectedPrice = price;
        float actualPrice = ingredient.getPrice();
        Assert.assertEquals(expectedPrice, actualPrice, 0);
    }

    @Test
    public void getNameTest() {
        String expectedName = name;
        String actualName = ingredient.getName();
        Assert.assertEquals(expectedName, actualName);
    }

    @Test
    public void getTypeTest() {
        IngredientType expectedType = IngredientType;
        IngredientType actualType = ingredient.getType();
        Assert.assertEquals(expectedType, actualType);
    }
}
