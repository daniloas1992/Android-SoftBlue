package com.example.fragmentactivity;

import android.app.Activity;
import android.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentOptions extends Fragment implements View.OnClickListener{

    Button btnPreto;
    Button btnAzul;
    Button btnVerde;
    Button btnVermelho;
    Button btnAmarelo;
    ChangeColorListener changeColorListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof ChangeColorListener)) {
            throw new RuntimeException("A classe main deve implementar ChangeColorListener!");
        }

        changeColorListener = (ChangeColorListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_options_layout,container,false);

        btnPreto    = (Button) view.findViewById(R.id.btnPreto);
        btnAzul     = (Button) view.findViewById(R.id.btnAzul);
        btnVerde    = (Button) view.findViewById(R.id.btnVerde);
        btnVermelho = (Button) view.findViewById(R.id.btnVermelho);
        btnAmarelo  = (Button) view.findViewById(R.id.btnAmarelo);

        btnPreto.setOnClickListener(this);
        btnAzul.setOnClickListener(this);
        btnVerde.setOnClickListener(this);
        btnVermelho.setOnClickListener(this);
        btnAmarelo.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button){
            switch(v.getId()){
                case R.id.btnPreto:{
                    changeColorListener.onChangeColor(MainActivity.PRETO);
                    break;
                }
                case R.id.btnAzul:{
                    changeColorListener.onChangeColor(MainActivity.AZUL);
                    break;
                }
                case R.id.btnVerde:{
                    changeColorListener.onChangeColor(MainActivity.VERDE);
                    break;
                }
                case R.id.btnVermelho:{
                    changeColorListener.onChangeColor(MainActivity.VERMELHO);
                    break;
                }
                case R.id.btnAmarelo:{
                    changeColorListener.onChangeColor(MainActivity.AMARELO);
                    break;
                }
            }
        }
    }

    public interface ChangeColorListener{
        public void onChangeColor(String color);
    }
}
