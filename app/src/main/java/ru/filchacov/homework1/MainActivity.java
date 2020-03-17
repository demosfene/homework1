package ru.filchacov.homework1;


import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnClickNumber {


    private NumberFragment oneNumberFragment;
    private ListFragment listFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<Integer> number = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            number.add(i);
        }

        listFragment = new ListFragment(number);
        oneNumberFragment = new NumberFragment();

        showListFragment(savedInstanceState);
    }

    void showListFragment(Bundle savedInstanceState){
        if (savedInstanceState == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.mainActivity, listFragment, ListFragment.TAG)
                    .commit();
        }
    }

    void showOneFragment(int number, int color){
        oneNumberFragment.setNumber(number, color);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.mainActivity, oneNumberFragment, NumberFragment.TAG)
                .addToBackStack(null)
                .commit();
    }


    @Override
    public void clickNumber(int number, @ColorInt int  color) {
        showOneFragment(number, color);
    }
}
