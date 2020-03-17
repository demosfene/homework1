package ru.filchacov.homework1;


import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ListFragment extends Fragment implements OnClickNumber{
    static String TAG = "ListFragment";

    private ArrayList<Integer> number = new ArrayList<>();

    public ListFragment() {
    }

    ListFragment(ArrayList<Integer> number) {
        this.number = number;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            number = savedInstanceState.getIntegerArrayList("number");
        }

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list);

        RecyclerView.LayoutManager layoutManager;


        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            layoutManager = new GridLayoutManager(getActivity(), 3);
        }else{
            layoutManager = new GridLayoutManager(getActivity(), 4);
        }

        recyclerView.setLayoutManager(layoutManager);

        Button button = view.findViewById(R.id.button_add);

        MyAdapter adapter = new MyAdapter();
        button.setOnClickListener(
                (View v) -> {
                        number.add(number.size()+1);
                        adapter.add(number.get(number.size()-1));
                }
        );
        adapter.updateWith(number, this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putIntegerArrayList("number", number);
    }

    @Override
    public void clickNumber(int number, int color) {
        if (getActivity() == null || getActivity() instanceof OnClickNumber){
            return;
        }

        ((MainActivity)getActivity()).clickNumber(number, color);

    }
}