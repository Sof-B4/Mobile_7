package com.example.mobiles4.UI.View;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mobiles4.Data.DataSources.Files.SharedStorage;
import com.example.mobiles4.Data.DataSources.Room.AppDatabase;
import com.example.mobiles4.Data.DataSources.Room.Entities.Item2;
import com.example.mobiles4.Data.DataSources.SharedPereferences.SharedPereferences;
import com.example.mobiles4.R;

import com.example.mobiles4.Data.Models.Item;

import com.example.mobiles4.UI.VM.ListViewModel;

import java.util.ArrayList;
import java.util.List;




public class FragmentList2 extends Fragment {

    private String stringTaskList = "";
    private AppDatabase db;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = Room.databaseBuilder(requireContext(), AppDatabase.class, "app-database").build();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list2, container, false);
        return view;
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Item2> items2 = new ArrayList<>();
        for (int i = 0; i <= 200; i++) {
            items2.add(new Item2(R.drawable.img_2, "RecyclerView"));
        }

        RecyclerView itemsList2 = view.findViewById(R.id.list2);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), items2);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        itemsList2.setLayoutManager(layoutManager);
        itemsList2.setAdapter(adapter);

        Button button_save = view.findViewById(R.id.save);
        button_save.setOnClickListener(v -> {
            for (Item2 item2 : items2) {
                db.itemDao().insertItem(item2);
            }
        });

        Button bCheckTasks = view.findViewById(R.id.check);
        bCheckTasks.setOnClickListener(v -> {
            new Thread(() -> {
                List<Item2> items = db.itemDao().getAllItems();
            }).start();
        });

    }
}








//
//
//public class FragmentList2 extends Fragment {
//
//    private String stringTaskList = "";
//
//    @Override
//    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//
//    }
//
//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.fragment_list2, container, false);
//        return view;
//    }
//
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//
//        List<Item> items2 = new ArrayList<>();
//        for (int i = 0; i <= 200; i++) {
//            items2.add(new Item(R.drawable.img_2, "RecyclerView"));
//        }
//
//        RecyclerView itemsList2 = view.findViewById(R.id.list2);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(getContext(), items2);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
//        itemsList2.setLayoutManager(layoutManager);
//        itemsList2.setAdapter(adapter);
//
//        Button button_save = view.findViewById(R.id.save);
//        button_save.setOnClickListener(v -> {
//            SharedPereferences.saveList(getActivity(), 200, items2);
//        });
//
//        Button bCheckTasks = view.findViewById(R.id.check);
//        bCheckTasks.setOnClickListener(v -> {
//            SharedPereferences.checkList(getActivity());
//        });
//
//    }
//}










//
//public class RightFragment extends Fragment {
//    private int count;
//    private RecyclerView recyclerView;
//    public RightFragment() {
//        super(R.layout.fragment_right);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        recyclerView = view.findViewById(R.id.recyclerView);
//        TaskListViewModel list = new ViewModelProvider(getActivity()).get(TaskListViewModel.class);
//        Bundle bundle = getArguments();
//        if (bundle.getBoolean("CreateList")) {
//            list.getUiState().observe(getViewLifecycleOwner(), uiState -> {
//                list.clearTaskList();
//            });
//            if (bundle.containsKey("qCount")) {
//                count = bundle.getInt("qCount");
//            } else {
//                count = 200;
//            }
//            for (int i = 0; i < count; i++) {
//                list.getUiState().observe(getViewLifecycleOwner(), uiState -> {
//                    list.addToList(
//                            list.setRandomUserTask());
//                });
//            }
//        }
//        bundle.putBoolean("CreateList", false);
//        RecyclerViewAdapter adapter = new RecyclerViewAdapter(
//                getContext(),
//                list.getUiState().getValue().getTasks()
//        );
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity()
//                .getApplicationContext());
//        recyclerView.setLayoutManager(layoutManager);
//        recyclerView.setAdapter(adapter);
//    }
//}