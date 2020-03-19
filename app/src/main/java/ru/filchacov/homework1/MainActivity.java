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
        listFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(ListFragment.TAG);
        if (listFragment == null) {
            listFragment = new ListFragment(number);
        }
        oneNumberFragment = (NumberFragment) getSupportFragmentManager().findFragmentByTag(NumberFragment.TAG);
        if (oneNumberFragment == null) {
            oneNumberFragment = new NumberFragment();
        }

        showListFragment();
    }

    public void showListFragment(){
        if (getSupportFragmentManager().findFragmentByTag(ListFragment.TAG) == null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.mainActivity, listFragment, ListFragment.TAG)
                    .commit();
        }
    }

    public void showOneFragment(int number, @ColorInt int color){
        if (getSupportFragmentManager().findFragmentByTag(NumberFragment.TAG) == null) {
            oneNumberFragment.setNumber(number, color);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivity, oneNumberFragment, NumberFragment.TAG)
                    .addToBackStack(null)
                    .commit();
        }
    }


    @Override
    public void clickNumber(int number, @ColorInt int  color) {
        showOneFragment(number, color);
    }
}
