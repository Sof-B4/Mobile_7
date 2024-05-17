package com.example.mobiles4.UI.View;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mobiles4.Data.DataSources.Room.Entities.Item2;
import com.example.mobiles4.Data.Models.Item;

import com.example.mobiles4.R;

import java.util.List;

public class RecyclerViewAdapter  extends
        RecyclerView.Adapter< RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "MyApp";
    private final LayoutInflater inflater;
    private final List<Item2> items;
    RecyclerViewAdapter(Context context, List<Item2> items) {
        this.items = items;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerViewAdapter.ViewHolder
    onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_view_adapter, parent,
                false);
        return new ViewHolder(view);
    }

    @Override
    public void
    onBindViewHolder(RecyclerViewAdapter.ViewHolder
                             holder, int position) {
        Item2 item2 = items.get(position);
        holder.textView.setText(item2.getText());
        holder.imageView.setImageResource(item2.getImageResource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(holder.itemView.getContext(),"Нажатие на элемент списка" +
                        holder.getAdapterPosition(), Toast.LENGTH_LONG).show();
                Log.i(TAG, "Нажатие на элемент списка" + holder.getAdapterPosition());
            }
        });

    }
    @Override
    public int getItemCount() {
        return items.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        final ImageView imageView;
        ViewHolder(View view){
            super(view);
            textView = view.findViewById(R.id.textView);
            imageView = view.findViewById(R.id.imageView);
        }
    }
}


//
//public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
//    private final LayoutInflater inflater;
//    private final List<Task> tasks;
//    public RecyclerViewAdapter(Context context, List<Task> tasks) {
//        this.tasks = tasks;
//        this.inflater = LayoutInflater.from(context);
//    }
//    @Override
//    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View view = inflater.inflate(R.layout.recycler_view_adapter, parent, false);
//        return new ViewHolder(view);
//    }
//    @Override
//    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder
//                             holder, int position) {
//        Task item = tasks.get(position);
//        holder.textView.setText(item.getText());
//        holder.imageView.setImageResource(item.getImage());
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Bundle bundle1 = new Bundle();
//                bundle1.putInt("getElement", holder.getPosition());
//                Navigation.findNavController(v).navigate(R.id.a_answer, bundle1);
//            }
//        });
//    }
//    @Override
//    public int getItemCount() {
//        return tasks.size();
//    }
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        final TextView textView;
//        final ImageView imageView;
//        ViewHolder(View view){
//            super(view);
//            textView = view.findViewById(R.id.textView);
//            imageView = view.findViewById(R.id.imageView);
//        }
//    }
//}