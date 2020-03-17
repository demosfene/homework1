package ru.filchacov.homework1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    private List<Integer> list = new ArrayList<>();
    private OnClickNumber listener;

    void updateWith(List<Integer> number, OnClickNumber listener) {
        list.clear();
        list.addAll(number);
        this.listener = listener;
        notifyDataSetChanged();
    }

    void add(Integer numberAdd){
        list.add(numberAdd);
        notifyItemInserted(getItemCount()-1);
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, null);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        holder.bind(list.get(position));
        holder.bindClickListener(list.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}