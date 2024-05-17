package com.example.mobiles4.Data.DataSources.Room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.mobiles4.Data.DataSources.Room.DAO.ItemDao;
import com.example.mobiles4.Data.DataSources.Room.Entities.Item2;

@Database(entities = {Item2.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ItemDao itemDao();
}

