package com.example.fragmentactivity;

import android.app.Fragment;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentResult extends Fragment {

    View backgroundView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result_layout, container, false);

        backgroundView = (View) view.findViewById(R.id.backgroundView);

        return view;
    }

    public void changeColor(String color) {

        if (color != null) {

            switch (color) {
                case MainActivity.PRETO: {
                    backgroundView.setBackgroundColor(Color.BLACK);
                    break;
                }
                case MainActivity.AZUL: {
                    backgroundView.setBackgroundColor(Color.BLUE);
                    break;
                }
                case MainActivity.VERDE: {
                    backgroundView.setBackgroundColor(Color.GREEN);
                    break;
                }
                case MainActivity.VERMELHO: {
                    backgroundView.setBackgroundColor(Color.RED);
                    break;
                }
                case MainActivity.AMARELO: {
                    backgroundView.setBackgroundColor(Color.YELLOW);
                    break;
                }
            }

        }
    }
}
