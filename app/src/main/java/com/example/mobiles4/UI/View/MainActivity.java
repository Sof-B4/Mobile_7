package com.example.mobiles4.UI.View;
import java.util.Random;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mobiles4.R;

public class MainActivity extends AppCompatActivity {
    public MainActivity() {
        super(R.layout.activity_main);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        String chars = "abcdefghijklmnoqrstu0987654321";

        // Random для генерации случайных чисел
        Random random = new Random();

        // Длина случайной строки
        int stringLength = 6;

        for (int k = 90; k <= 100; k++) {
            StringBuilder randomString = new StringBuilder();

            // Генерация случайной строки длиной stringLength
            for (int i = 0; i < stringLength; i++) {
                int index = random.nextInt(chars.length());
                randomString.append(chars.charAt(index));
            }

            String data = "com.example.mobiles4.Data.Models.Item@" + randomString.toString();
            Log.d("SharedPreferences", k + ": " + data);
        }

    }
}
