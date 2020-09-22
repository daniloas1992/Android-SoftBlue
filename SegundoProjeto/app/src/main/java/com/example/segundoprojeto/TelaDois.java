package com.example.segundoprojeto;

import android.app.Activity;
import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaDois extends Activity implements View.OnClickListener{

    Button btnOK_TelaDois;
    Button btnCancelar_TelaDois;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_dois_layout);

        btnOK_TelaDois = findViewById(R.id.btnOK_TelaDois);
        btnCancelar_TelaDois = findViewById(R.id.btnCancelar_TelaDois);

        btnOK_TelaDois.setOnClickListener(this);
        btnCancelar_TelaDois.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button){
            switch(v.getId()){
                case R.id.btnOK_TelaDois:
                    Intent i = new Intent(this,TelaTres.class);
                    startActivity(i);
                    break;

                case R.id.btnCancelar_TelaDois:
                    Intent i2 = new Intent(this,MainActivity.class);
                    startActivity(i2);
                    break;

                default: break;
            }
        }
    }
}
