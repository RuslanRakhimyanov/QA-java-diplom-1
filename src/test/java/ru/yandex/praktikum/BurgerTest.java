package ru.yandex.praktikum;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static praktikum.IngredientType.FILLING;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    @Mock
    private Ingredient ingredient;
    @Mock
    private Ingredient IngredientOptional;
    @Mock
    private Bun bun;

    private Burger burger;

    @Before
    public void newBurger() {
        burger = new Burger();
    }

    @Test
    public void setBunsTest() {
        Bun expected = bun;
        burger.setBuns(bun);
        Bun actual = burger.bun;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void addIngredientTest() {
        int expected = 1;
        burger.addIngredient(ingredient);
        int actual = burger.ingredients.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void removeIngredientTest() {
        int expected = 1;
        burger.addIngredient(ingredient);
        burger.addIngredient(IngredientOptional);
        burger.removeIngredient(0);
        int actual = burger.ingredients.size();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void moveIngredientTest() {
        List<Ingredient> expected = new ArrayList<>(Arrays.asList(IngredientOptional, ingredient));
        burger.addIngredient(ingredient);
        burger.addIngredient(IngredientOptional);
        burger.moveIngredient(0, 1);
        List<Ingredient> actual = burger.ingredients;
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void getPriceTest() {
        float expected = 2525f;
        burger.setBuns(bun);
        burger.ingredients.addAll(Arrays.asList(ingredient, IngredientOptional));
        Mockito.when(bun.getPrice()).thenReturn(900f);
        Mockito.when(ingredient.getPrice()).thenReturn(700f);
        Mockito.when(IngredientOptional.getPrice()).thenReturn(25f);
        float actual = burger.getPrice();
        Assert.assertEquals(expected, actual, 0);
    }

    @Test
    public void getReceiptTest() {
        burger.setBuns(bun);
        burger.ingredients.add(ingredient);
        Mockito.when(bun.getName()).thenReturn("white bun");
        Mockito.when(bun.getPrice()).thenReturn(900f);
        Mockito.when(ingredient.getType()).thenReturn(FILLING);
        Mockito.when(ingredient.getName()).thenReturn("chicken cutlet");
        Mockito.when(ingredient.getPrice()).thenReturn(700f);
        String expected = String.format("(==== %s ====)%n", bun.getName()) +
                String.format("= %s %s =%n", ingredient.getType().toString().toLowerCase(), ingredient.getName()) +
                String.format("(==== %s ====)%n", bun.getName()) +
                String.format("%nPrice: %f%n", burger.getPrice());
        Assert.assertEquals(expected, burger.getReceipt());
    }
}
