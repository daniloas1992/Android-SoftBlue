package com.teste.modelo.modulo4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    ViewHolder vH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vH = new ViewHolder();

        vH.btnExecUm = findViewById(R.id.btnExecUm);
        vH.btnExecDois = findViewById(R.id.btnExecDois);

        vH.btnExecUm.setOnClickListener(this);
        vH.btnExecDois.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnExecUm:{
                Intent i = new Intent(MainActivity.this, Exercicio1.class);
                startActivity(i);
                break;
            }

            case R.id.btnExecDois: {
                Intent i = new Intent(MainActivity.this, Exercicio2.class);
                startActivity(i);
                break;
            }

            default:break;
        }
    }

    static class ViewHolder{
        Button btnExecUm;
        Button btnExecDois;
    }
}
