package com.example.mobiles4.Data.DataSources;

import com.example.mobiles4.Data.Repositories.ListRepository;

import java.util.ArrayList;
import java.util.List;

import com.example.mobiles4.Data.Models.Item;

public class UserList implements ListRepository {
    private List<Item> tasks;
    public UserList() {
        tasks = new ArrayList<>();
    }
    @Override
    public List<Item> getTasks() { return tasks; }
    @Override

    public Item get(int index) { return tasks.get(index); }
    @Override
    public void add(Item item) { tasks.add(item); }

    @Override
    public void clearAll() { tasks.clear(); }

    @Override
    public boolean isEmpty() { return tasks.isEmpty(); }
    @Override
    public int getSize() { return tasks.size(); }
}
