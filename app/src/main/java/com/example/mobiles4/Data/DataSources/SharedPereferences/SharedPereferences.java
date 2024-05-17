package com.example.mobiles4.Data.DataSources.SharedPereferences;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import com.example.mobiles4.Data.Models.Item;
import com.example.mobiles4.R;

import java.util.ArrayList;
import java.util.List;

public class SharedPereferences {
    public static void saveList(Activity activity, int size, List<Item> listData) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        for (int i = 0; i < size; i++) {
            editor.putString(Integer.toString(i), (listData.get(i).toString()));
        }
        editor.apply();
    }
    public static void checkList(Activity activity) {
        String data = "";
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        for (String k : sharedPref.getAll().keySet()) {
            data = sharedPref.getString(k,"Nope");
            Log.d("SharedPereferences", k + ": " + data);
        }
    }
    public static void removeAll(Activity activity) {
        SharedPreferences sharedPref = activity.getPreferences(Context.MODE_PRIVATE);
        sharedPref.edit().clear().apply();
    }
}


