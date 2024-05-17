package com.example.mobiles4.Data.DataSources.Room.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

//import com.example.mobiles4.Data.DataSources.List;
import com.example.mobiles4.Data.DataSources.Room.Entities.Item2;
import com.example.mobiles4.Data.Models.Item;

@Dao
public interface ItemDao {
    @Insert
    void insertItem(Item2 item2);

    @Query("SELECT * FROM items")
    List<Item2> getAllItems();
}


