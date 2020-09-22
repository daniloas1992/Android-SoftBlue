package com.example.fragmentodinamico;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        FragmentoEsquerda fe = new FragmentoEsquerda();
        FragmentoDireita  fd = new FragmentoDireita();

        FragmentManager     fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.add(R.id.layoutEsquerda,fe, "FE");
        ft.add(R.id.layoutDireita, fd, "FD");
        ft.commit();

    }
}
