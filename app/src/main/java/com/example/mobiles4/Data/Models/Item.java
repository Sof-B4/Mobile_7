package com.example.mobiles4.Data.Models;

public class Item {
    private String itemName;
    private int itemImageResId;

    public Item( int itemImageResId, String itemName) {
        this.itemImageResId = itemImageResId;
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
    public int getItemImageResId() {
        return itemImageResId;
    }
}

