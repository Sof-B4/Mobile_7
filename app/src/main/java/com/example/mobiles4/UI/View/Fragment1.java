package com.example.mobiles4.UI.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mobiles4.R;

public class Fragment1 extends Fragment {
    public Fragment1() {
        super(R.layout.fragment1);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button sections = view.findViewById(R.id.sections);
        Button sign_up = view.findViewById(R.id.sign_up);
        Button list1 = view.findViewById(R.id.list1);
        Button list2 = view.findViewById(R.id.list2);


        sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Navigation.findNavController(v).navigate(R.id.fragment3);
            }
        });

        sections.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment2);
            }
        });

        list1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment_list1);
            }
        });

        list2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(v).navigate(R.id.fragment_list2);
            }
        });


    }
}