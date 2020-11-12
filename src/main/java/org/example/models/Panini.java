package org.example.models;

import java.util.List;

public class Panini extends Dish{

    public Panini(String name,String title, List<Ingredient> ingredientList, float price, String desc) {
        this.setName(name);
        this.setTitle(title);
        this.setIngredientList(ingredientList);
        this.setPrice(price);
        this.setDescription(desc);
    }
}
