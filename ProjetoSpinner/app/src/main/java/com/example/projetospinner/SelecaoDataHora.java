package com.example.projetospinner;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelecaoDataHora extends Activity implements View.OnClickListener {

    private Button btnSelecionarData;
    private Button btnSelecionarHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selecao_data_hora);

        btnSelecionarData = findViewById(R.id.btnSelecionarData);
        btnSelecionarHora = findViewById(R.id.btnSelecionarHora);

        btnSelecionarData.setOnClickListener(this);
        btnSelecionarHora.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button){
            switch(v.getId()){

                case R.id.btnSelecionarData:{
                    DatePicker data = new DatePicker();
                    data.show(getFragmentManager(),"Data");
                    break;
                }

                case R.id.btnSelecionarHora:{
                    TimePicker time = new TimePicker();
                    time.show(getFragmentManager(),"Time");

                    break;
                }
            }
        }
    }
}
