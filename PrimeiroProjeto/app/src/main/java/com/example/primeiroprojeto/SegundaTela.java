package com.example.primeiroprojeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SegundaTela extends Activity {

    private final static int ID_ACTIVITY_DOIS = 2;

    Button btnAbrirTelaTres;
    TextView tvSegundaTela;
    TextView tvValor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.segunda_tela);

        String texto = getIntent().getStringExtra("id_texto");

        btnAbrirTelaTres = findViewById(R.id.btnAbrirTelaTres);
        tvSegundaTela    = findViewById(R.id.tvSegundaTela);
        tvValor          = findViewById(R.id.tvValor);

        tvSegundaTela.setText(texto);

        btnAbrirTelaTres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                abrirTerceiraTela();
            }
        });
    }

    private void abrirTerceiraTela() {
        Intent i = new Intent(this, TerceiraTela.class);
        i.putExtra("valor",tvValor.getText());
        startActivityForResult(i,ID_ACTIVITY_DOIS);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent();
        i.putExtra("resultado","Veio da Segunda Tela");
        setResult(RESULT_OK,i);
        finish();
    }


    public void tirarFoto(View view) {
        Intent i = new Intent(this,TirarFoto.class);
        startActivity(i);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ID_ACTIVITY_DOIS){
            if(resultCode == RESULT_OK){
                if(data != null){
                    String valor = data.getStringExtra("valor");
                    valor = String.valueOf((Integer.parseInt(valor) + 1)) ;
                    tvValor.setText(valor);
                }
            }
        }
    }
}
