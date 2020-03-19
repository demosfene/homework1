package ru.filchacov.homework1;


import android.os.Bundle;

import androidx.annotation.ColorInt;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements OnClickNumber {


    private NumberFragment numberFragment;
    private ListFragment listFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listFragment = (ListFragment) getSupportFragmentManager().findFragmentByTag(ListFragment.TAG);
        if (listFragment == null) {
            listFragment = new ListFragment();
        }
        numberFragment = (NumberFragment) getSupportFragmentManager().findFragmentByTag(NumberFragment.TAG);
        if (numberFragment == null) {
            numberFragment = new NumberFragment();
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
            numberFragment.setNumber(number, color);
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.mainActivity, numberFragment, NumberFragment.TAG)
                    .addToBackStack(null)
                    .commit();
        }
    }


    @Override
    public void clickNumber(int number, @ColorInt int  color) {
        showOneFragment(number, color);
    }
}
