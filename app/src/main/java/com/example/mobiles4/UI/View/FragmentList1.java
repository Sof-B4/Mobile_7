package com.example.mobiles4.UI.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.mobiles4.Data.Models.Item;
import com.example.mobiles4.R;

import java.util.ArrayList;
import java.util.List;

public class FragmentList1 extends Fragment {

    private static final String TAG = "MyApp";
    private int defaultValue = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list1, container, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Item> items = new ArrayList<>();
        for (int i = 0; i <= 200; i++) {
            items.add(new Item(R.drawable.img_1, "ListView"));
        }

        ListView itemsList1 = view.findViewById(R.id.list1);
        ListViewAdapter adapter = new ListViewAdapter(getContext(), R.layout.list_view_adapter, items);
        itemsList1.setAdapter(adapter);

        itemsList1.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                Toast.makeText(getContext(),"Нажатие на элемент списка " + position, Toast.LENGTH_LONG)
                        .show();
                Log.i(TAG, "Нажатие на элемент списка " + position);
            } });






    }





//    private int count;
//    public LeftFragment() {
//        super(R.layout.fragment_left);
//    }
//
//    @Override
//    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//        ListView listView = view.findViewById(R.id.listView);
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
//                list.addToList(
//                        list.createRandomMathematicalTask());
//                });
//            }
//        }
//        bundle.putBoolean("CreateList", false);
//        ListViewAdapter adapter = new ListViewAdapter(
//                getContext(),
//                R.layout.list_view_adapter,
//                list.getUiState().getValue().getTasks()
//        );
//        listView.setAdapter(adapter);
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                Bundle bundle1 = new Bundle();
//                bundle1.putInt("getElement", position);
//                Navigation.findNavController(view).navigate(R.id.a_answer, bundle1);
//            }
//        });
//    }
}