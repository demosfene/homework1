package ru.filchacov.homework1;

import android.graphics.Color;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class MyHolder extends RecyclerView.ViewHolder {
    private TextView textView;


    MyHolder(@NonNull View itemView) {
        super(itemView);
        textView = itemView.findViewById(R.id.number);
    }

    void bindClickListener(int number, OnClickNumber onClickNumber) {
        textView.setOnClickListener(
                (v) -> onClickNumber.clickNumber(number, getColor(number))
        );
    }

    void bind (int position){
        textView.setText(String.valueOf(position));
        textView.setTextColor(getColor(position));
    }

    private int getColor(int position){
        if(position % 2 == 0){
            return Color.RED;
        }else
            return Color.BLUE;
    }




}