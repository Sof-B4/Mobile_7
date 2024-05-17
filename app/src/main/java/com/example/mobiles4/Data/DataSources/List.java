package com.example.mobiles4.Data.DataSources;

import com.example.mobiles4.Data.Repositories.ListRepository;

import java.util.ArrayList;

import com.example.mobiles4.Data.Models.Item;

public class List implements ListRepository {
    private java.util.List<Item> items;
    public List() {
        items = new ArrayList<>();
    }
    @Override
    public java.util.List<Item> getTasks() { return items; }
    @Override
    public Item get(int index) { return items.get(index); }
    @Override
    public void add(Item item) { items.add(item); }
    @Override
    public boolean isEmpty() { return items.isEmpty(); }
    @Override
    public void clearAll() { items.clear(); }
    @Override
    public int getSize() { return items.size(); }
}


