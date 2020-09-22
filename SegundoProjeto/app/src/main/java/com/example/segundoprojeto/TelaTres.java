package com.example.segundoprojeto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class TelaTres extends Activity implements View.OnClickListener {

    Button btnCancelar_telaTres;
    Button btnOk_telaTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela_tres_layout);

        btnCancelar_telaTres = findViewById(R.id.btnCancelar_telaTres);
        btnOk_telaTres = findViewById(R.id.btnOk_telaTres);

        btnCancelar_telaTres.setOnClickListener(this);
        btnOk_telaTres.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button){
            switch(v.getId()){

                case R.id.btnOk_telaTres:
                    Intent i = new Intent(this,TelaQuatro.class);
                    startActivity(i);
                    break;
                case R.id.btnCancelar_telaTres:
                    Intent i2 = new Intent(this,TelaDois.class);
                    startActivity(i2);
                    break;
                default: break;
            }
        }
    }
}
