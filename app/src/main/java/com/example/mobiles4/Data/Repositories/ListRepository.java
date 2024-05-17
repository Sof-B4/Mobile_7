package com.example.mobiles4.Data.Repositories;

import java.util.List;

import com.example.mobiles4.Data.Models.Item;

public interface ListRepository {
    public List<Item> getTasks();
    public Item get(int index);
    public void add(Item item);
    public boolean isEmpty();
    public void clearAll();
    public int getSize();
}
