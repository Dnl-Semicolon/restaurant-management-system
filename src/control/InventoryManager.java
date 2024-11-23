package control;

import adt.ListInterface;
import adt.ArrayList;

import entity.Ingredient;

public class InventoryManager {
    private ListInterface<Ingredient> inventory = new ArrayList<>();

    public void addNewInventoryItem(String name, int quantity) {
        inventory.add(new Ingredient(name, quantity));
    }

    public String getAllInventoryItems() {
        String outputStr = "";
        for (int i = 1; i <= inventory.getNumberOfEntries(); i++) {
            outputStr += inventory.getEntry(i) + "\n";
        }
        return outputStr;
    }
}
