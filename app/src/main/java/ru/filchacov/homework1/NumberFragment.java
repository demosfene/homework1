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
    private static final String bundleColor = "color";
    private static final String bundleNumber = "number";

    void setNumber(int number, @ColorInt int color){
        Bundle bundle = new Bundle();
        bundle.putInt(bundleColor, color);
        bundle.putInt(bundleNumber, number);
        setArguments(bundle);
    }

    public NumberFragment() {
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null ){
            this.number = bundle.getInt(bundleNumber);
            this.color = bundle.getInt(bundleColor);
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
