package com.example.primeiroprojeto;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class TerceiraTela extends AppCompatActivity {

     TextView tvValorTelaTres;
     Button btnVoltarTela2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.terceira_tela);

        tvValorTelaTres = findViewById(R.id.tvValorTelaTres);
        btnVoltarTela2 = findViewById(R.id.btnVoltarTela2);


        String valor = getIntent().getStringExtra("valor");
        valor = String.valueOf((Integer.parseInt(valor) + 1));

        tvValorTelaTres.setText(valor);

        btnVoltarTela2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTelaDois();
            }
        });
    }

    private void abrirTelaDois(){
        Intent i = new Intent();
        i.putExtra("valor",tvValorTelaTres.getText());
        setResult(RESULT_OK,i);
        finish();
    }
}
