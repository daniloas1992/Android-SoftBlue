package com.example.fragmentcounter;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentInc extends Fragment implements View.OnClickListener {

    Button btnIncrementar;
    IncrementListener incrementListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if(activity instanceof IncrementListener){
            incrementListener = (IncrementListener) activity;
        }else{
            throw new RuntimeException("A classe MainActivity deve implementar IncrementListener!");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_inc_layout,container,false);

        btnIncrementar = (Button) view.findViewById(R.id.btnIncrementar);

        btnIncrementar.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button){
            if(v.getId() == R.id.btnIncrementar){
                incrementListener.onIncrement();
            }
        }
    }

    public interface IncrementListener{
        public void onIncrement();
    }
}
