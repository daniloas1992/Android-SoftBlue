package com.example.fragmentactivity;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;

public class MainActivity extends Activity implements FragmentOptions.ChangeColorListener {

    public static final String PRETO    = "PRETO";
    public static final String AZUL     = "AZUL";
    public static final String VERDE    = "VERDE";
    public static final String VERMELHO = "VERMELHO";
    public static final String AMARELO  = "AMARELO";

    Fragment fragResult;
    Fragment fragOptions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        fragOptions = new FragmentOptions();
        fragResult  = new FragmentResult();

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.layoutOptions,fragOptions,"FO");
        ft.add(R.id.layoutResult,fragResult,"FR");
        ft.commit();

    }

    @Override
    public void onChangeColor(String color) {
        ((FragmentResult) fragResult).changeColor(color);
    }
}
