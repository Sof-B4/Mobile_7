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

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

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

                AppSpecificStorage.createFile(getContext(), "RegistrationForTraining.txt");
                AppSpecificStorage.writeToFile(getContext(), "RegistrationForTraining.txt",
                        "Запись на тренировку:" + sectionEditText.getText().toString() + '\n');
                Log.d("CheckingFile", AppSpecificStorage.readFile(getContext(), "RegistrationForTraining.txt"));
            }
        });

        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (ContextCompat.checkSelfPermission(getContext(),
                        Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                        PackageManager.PERMISSION_GRANTED) {
                    string += sectionEditText.getText().toString() + "\n";
                    SharedStorage.writeToFile("RegistrationForTraining2.txt", string);
                    string = "";
                } else {
                    SharedStorage.requestPermissionWrite(getActivity());
                }


//                Bundle result = new Bundle();
//                String sectionToPass = sectionEditText.getText().toString();
//                result.putString("bundleKey", sectionToPass);
//
//                Navigation.findNavController(view).navigate(R.id.fragment3, result);
//
//                AppSpecificStorage.createFile(getContext(), "RegistrationForTraining.txt");
//                AppSpecificStorage.writeToFile(getContext(), "RegistrationForTraining.txt",
//                        "Запись на тренировку:" + sectionEditText.getText().toString() + '\n');
//                Log.d("CheckingFile", AppSpecificStorage.readFile(getContext(), "RegistrationForTraining.txt"));
            }
        });

//        public void onClick(View v) {
//                if (ContextCompat.checkSelfPermission(getContext(),
//                        Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
//                        PackageManager.PERMISSION_GRANTED) {
//                    for (int i = 0; i < 200; i++) {
//                        stringTaskList += "aaaa" + "\n";
//                    }
//                    SharedStorage.writeToFile("List.txt", stringTaskList);
//                    stringTaskList = "";
//                } else {
//                    SharedStorage.requestPermissionWrite(getActivity());
//                }
//            }

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Navigation.findNavController(view).navigate(R.id.fragment1);
            }
        });

    }
}

//
//public class Fragment2 extends Fragment {
//    private static final String TAG = "MyApp";
//    private int defaultValue = 0;
//
//    private static final int PERMISSION_REQUEST_CODE = 100; // Объявление переменной
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //return inflater.inflate(R.layout.fragment2, container, false);
//
//        View view = inflater.inflate(R.layout.fragment2, container, false);
//
//        TextView textView = view.findViewById(R.id.text_return);
//
//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            String name = bundle.getString("bundleKey2");
//            if (name != null) {
//                textView.setText(name);
//            }
//        }
//
//        return view;
//
//    }
//
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//
//        ImageView imageView = view.findViewById(R.id.image_cup);
//        TextView textView = view.findViewById(R.id.text_sections);
//        TextView textView2 = view.findViewById(R.id.text_gymnastics);
//        TextView textView3 = view.findViewById(R.id.text_swimming);
//        TextView textView4 = view.findViewById(R.id.text_acrobatics);
//        TextView textView5 = view.findViewById(R.id.text_yoga);
//        TextView textView6 = view.findViewById(R.id.text_football);
//        TextView textView7 = view.findViewById(R.id.text_boxing);
//
//        Button button = view.findViewById(R.id.button_sign_up);
//        Button button_back = view.findViewById(R.id.button_end2);
//
//        EditText sectionEditText = view.findViewById(R.id.section);
//
//        button.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//                // Проверка наличия разрешения на запись во внешнее хранилище
//                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    // Если разрешение не предоставлено, запросите его
//                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
//                    return;
//                }
//
//                // Создание текстового файла в общем внешнем хранилище
//                File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//                File file = new File(folder, "RegistrationForTraining.txt");
//
//                try {
//                    // Запись данных в файл
//                    FileOutputStream fileOutputStream = new FileOutputStream(file);
//                    String data = "Запись на тренировку:" + sectionEditText.getText().toString() + '\n';
//                    fileOutputStream.write(data.getBytes());
//                    fileOutputStream.close();
//
//                    // Вывод сообщения в лог
//                    Log.d("CheckingFile", "File saved to: " + file.getAbsolutePath());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    // Обработка ошибки записи файла
//                }
//            }
//        });
//    }
//}








//
//
//
//public class Fragment2 extends Fragment {
//    private static final String TAG = "MyApp";
//    private int defaultValue = 0;
//
//    private static final int PERMISSION_REQUEST_CODE = 100; // Объявление переменной
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        //return inflater.inflate(R.layout.fragment2, container, false);
//
//        View view = inflater.inflate(R.layout.fragment2, container, false);
//
//        TextView textView = view.findViewById(R.id.text_return);
//
//        Bundle bundle = getArguments();
//        if (bundle != null) {
//            String name = bundle.getString("bundleKey2");
//            if (name != null) {
//                textView.setText(name);
//            }
//        }
//
//        return view;
//    }
//
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//
//        ImageView imageView = view.findViewById(R.id.image_cup);
//        TextView textView = view.findViewById(R.id.text_sections);
//        TextView textView2 = view.findViewById(R.id.text_gymnastics);
//        TextView textView3 = view.findViewById(R.id.text_swimming);
//        TextView textView4 = view.findViewById(R.id.text_acrobatics);
//        TextView textView5 = view.findViewById(R.id.text_yoga);
//        TextView textView6 = view.findViewById(R.id.text_football);
//        TextView textView7 = view.findViewById(R.id.text_boxing);
//
//        Button button = view.findViewById(R.id.button_sign_up);
//        Button button_back = view.findViewById(R.id.button_end2);
//
//        EditText sectionEditText = view.findViewById(R.id.section);
//
//        button.setOnClickListener(new View.OnClickListener() {
//
//            public void onClick(View view) {
//
//
//                // Проверка наличия разрешения на запись во внешнее хранилище
//                if (ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    // Если разрешение не предоставлено, запросите его
//                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
//                    return;
//                }
//
//                // Создание текстового файла в общем внешнем хранилище
//                File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
//                File file = new File(folder, "RegistrationForTraining.txt");
//
//                try {
//                    // Запись данных в файл
//                    FileOutputStream fileOutputStream = new FileOutputStream(file);
//                    String data = "Запись на тренировку:" + sectionEditText.getText().toString() + '\n';
//                    fileOutputStream.write(data.getBytes());
//                    fileOutputStream.close();
//
//                    // Вывод сообщения в лог
//                    Log.d("CheckingFile", "File saved to: " + file.getAbsolutePath());
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    // Обработка ошибки записи файла
//                }
//            }
//        });
//    }
//}
//
//
//



//public class AddTaskFragment extends Fragment {
//    public AddTaskFragment() {
//        super(R.layout.fragment_add_task);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        TaskListViewModel list = new ViewModelProvider(getActivity()).get(TaskListViewModel.class);
//        Button bAccept = view.findViewById(R.id.b_accept);
//        EditText eTaskText = view.findViewById(R.id.e_tasktext);
//        EditText eTaskAnswer = view.findViewById(R.id.e_taskanswer);
//        bAccept.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                list.addUserTask(new Task(
//                        eTaskText.getText().toString(),
//                        R.drawable.nature,
//                        eTaskAnswer.getText().toString()
//                        ));
//            }
//        });
//    }
//}