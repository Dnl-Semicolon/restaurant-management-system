package entity;

import java.io.Serializable;

public class Ingredient implements Serializable {
    private String ingredientName;
    private int quantity;

    public Ingredient(String ingredientName, int stock) {
        this.ingredientName = ingredientName;
        this.quantity = stock;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "ingredientName='" + ingredientName + '\'' +
                ", quantity=" + quantity +
                '}';
    }
}
