package ru.filchacov.homework1;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Objects;


public class ListFragment extends Fragment implements OnClickNumber{
    static String TAG = "ListFragment";
    private static final String bundleNumberArr = "numberArr";
    private ArrayList<Integer> number;

    public ListFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null) {
            number = savedInstanceState.getIntegerArrayList(bundleNumberArr);
        }else{
            number = new ArrayList<>();
            for (int i = 1; i <= 100; i++) {
                number.add(i);
            }
        }

    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle saveInstanceState){

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        RecyclerView recyclerView = view.findViewById(R.id.list);

        RecyclerView.LayoutManager layoutManager;


        layoutManager = new GridLayoutManager(getActivity(), Objects.requireNonNull(getContext()).getResources().getInteger(R.integer.col_count));



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
        outState.putIntegerArrayList(bundleNumberArr, number);
    }



    @Override
    public void clickNumber(int number, @ColorInt int color) {
        if (getActivity() instanceof OnClickNumber){
            ((OnClickNumber)getActivity()).clickNumber(number, color);
        }
    }
}