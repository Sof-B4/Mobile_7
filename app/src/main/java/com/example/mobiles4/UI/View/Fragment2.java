package com.example.mobiles4.UI.View;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.mobiles4.Data.DataSources.Files.AppSpecificStorage;
import com.example.mobiles4.Data.DataSources.Files.SharedStorage;
import com.example.mobiles4.R;



public class Fragment2 extends Fragment {
    private static final String TAG = "MyApp";
    private int defaultValue = 0;
    private String string = "";

    private static final int PERMISSION_REQUEST_CODE = 100; // Объявление переменной

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return inflater.inflate(R.layout.fragment2, container, false);

        View view = inflater.inflate(R.layout.fragment2, container, false);

        TextView textView = view.findViewById(R.id.text_return);

        Bundle bundle = getArguments();
        if (bundle != null) {
            String name = bundle.getString("bundleKey2");
            if (name != null) {
                textView.setText(name);
            }
        }

        return view;

    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {



        Button button = view.findViewById(R.id.button_sign_up);
        Button button_back = view.findViewById(R.id.button_end2);
        Button button_save = view.findViewById(R.id.save);

        EditText sectionEditText = view.findViewById(R.id.section);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                Bundle result = new Bundle();
                String sectionToPass = sectionEditText.getText().toString();
                result.putString("bundleKey", sectionToPass);

                Navigation.findNavController(view).navigate(R.id.fragment3, result);

                AppSpecificStorage.createFile(getContext(), "InformationForMeditation.txt");
                AppSpecificStorage.writeToFile(getContext(), "InformationForMeditation.txt",
                        "Go to Fragment №3:" + sectionEditText.getText().toString() + '\n');
                Log.d("CheckingFile", AppSpecificStorage.readFile(getContext(), "InformationForMeditation.txt"));
            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_GRANTED) {
                    string += sectionEditText.getText().toString() + "\n";
                    SharedStorage.writeToFile("InformationForMeditation2.txt", string);
                    string = "";
                } else {
                    SharedStorage.requestPermissionWrite(getActivity());
                }


            }
        });



        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragment1);
            }
        });

    }
}





