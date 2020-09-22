package com.example.segundoprojeto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnCancelar;
    Button btnOk;
    Button abrirLayoutUm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        btnCancelar = findViewById(R.id.btnCancelar);
        btnOk = findViewById(R.id.btnOk);
        abrirLayoutUm = findViewById(R.id.abrirLayoutUm);

        btnCancelar.setOnClickListener(this);
        btnOk.setOnClickListener(this);
        abrirLayoutUm.setOnClickListener(this);
    }

    @Override
    public void onClick(View view){

        if(view instanceof Button){
           switch(view.getId()){
               case R.id.btnCancelar: break;
               case R.id.btnOk:
                   Intent i = new Intent(this,TelaDois.class);
                   startActivity(i);
                   break;

               case R.id.abrirLayoutUm:
                   Intent l1 = new Intent(this,ActivityUm.class);
                   startActivity(l1);
                   break;
               default: break;
           }
        }
    }
}
