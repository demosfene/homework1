package ru.filchacov.homework1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class NumberFragment extends Fragment {

    static String TAG = "NumberFragment";

    @ColorInt
    private int color;
    private int number;

    void setNumber(int number, @ColorInt int color){
        Bundle bundle = new Bundle();
        bundle.putInt(String.valueOf(R.string.color), color);
        bundle.putInt(String.valueOf(R.string.number), number);
        setArguments(bundle);
    }

    public NumberFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null ){
            this.number = bundle.getInt(String.valueOf(R.string.number));
            this.color = bundle.getInt(String.valueOf(R.string.color));
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.number, container, false);


    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TextView textView = view.findViewById(R.id.oneNumber);
        textView.setText(String.valueOf(this.number));
        textView.setTextColor(this.color);

    }
}
