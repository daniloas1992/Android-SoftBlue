package com.example.fragmentcounter;

import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentRight extends Fragment {

    TextView tvRight;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_right_layout, container, false);

        tvRight = (TextView) view.findViewById(R.id.tvRight);

        return view;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("VALOR",tvRight.getText().toString());
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        if(savedInstanceState != null){
            this.tvRight.setText(savedInstanceState.getString("VALOR"));
        }
    }

    public void incrementar(){
        int valor = Integer.parseInt(tvRight.getText().toString()) + 1;
        tvRight.setText(String.valueOf(valor));
    }
}
