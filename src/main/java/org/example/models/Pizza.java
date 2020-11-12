package org.example.models;

import java.util.List;

public class Pizza extends Dish{

    private DoughType doughType;

    public enum DoughType{
        CLASSIC,THICK,THIN
    }

    public Pizza(String name,List<Ingredient> ingredientList, DoughType doughType,float price,String desc) {
        this.setName(name);
        this.setIngredientList(ingredientList);
        this.doughType = doughType;
        this.setPrice(price);
        this.setDescription(desc);
    }
}