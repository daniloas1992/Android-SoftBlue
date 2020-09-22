package com.example.fragmentcounter;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentInc.IncrementListener {

    Fragment fragInc;
    Fragment fragLeft;
    Fragment fragRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);


        FragmentManager     fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        fragInc = (FragmentInc) fm.findFragmentById(R.id.incLayout);
        if(fragInc == null){
            fragInc   = new FragmentInc();
            ft.add(R.id.incLayout,fragInc,"FI");
        }

        fragLeft = (FragmentLeft) fm.findFragmentById(R.id.leftLayout);
        if (fragLeft == null) {
            fragLeft = new FragmentLeft();
            ft.add(R.id.leftLayout, fragLeft,"FL");
        }

        fragRight = (FragmentRight) fm.findFragmentById(R.id.rightLayout);
        if(fragRight == null){
            fragRight = new FragmentRight();
            ft.add(R.id.rightLayout,fragRight,"FR");
        }
        ft.commit();
    }

    @Override
    public void onIncrement() {
        ((FragmentRight) fragRight).incrementar();
        ((FragmentLeft) fragLeft).incrementar();
    }
}
