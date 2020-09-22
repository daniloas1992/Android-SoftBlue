package com.example.fragmentcounter;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentLeft extends Fragment {

    TextView tvLeft;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_left_layout,container,false);

        tvLeft = (TextView) view.findViewById(R.id.tvLeft);

        if(savedInstanceState != null){
            String valor = savedInstanceState.getString("VALOR");
            this.tvLeft.setText(valor);
        }

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("VALOR",tvLeft.getText().toString());
    }

    public void incrementar(){
        int valor = Integer.parseInt(tvLeft.getText().toString()) + 1;
        tvLeft.setText(String.valueOf(valor));
    }
}
