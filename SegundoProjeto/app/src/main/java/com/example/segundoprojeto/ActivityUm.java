package com.example.segundoprojeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class ActivityUm extends Activity implements View.OnClickListener {

    TextView showNome;
    TextView showSexo;
    Button   btnExibir;
    Button   btnLimpar;
    Button   btnAvancarLayoutDois;
    Button   btnVoltarMain;
    EditText edtNome;
    RadioButton rbtnMasculino;
    RadioButton rbtnFeminino;
    RadioGroup rgSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_um);

        showNome  = findViewById(R.id.showNome);
        showSexo  = findViewById(R.id.showSexo);
        btnExibir = findViewById(R.id.btnExibir);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnVoltarMain = findViewById(R.id.btnVoltarMain);
        btnAvancarLayoutDois = findViewById(R.id.btnAvancarLayoutDois);
        edtNome   = findViewById(R.id.edtNome);
        rbtnMasculino = findViewById(R.id.rbtnMasculino);
        rbtnFeminino = findViewById(R.id.rbtnFeminino);
        rgSexo = findViewById(R.id.rgSexo);

        btnExibir.setOnClickListener(this);
        btnLimpar.setOnClickListener(this);
        btnVoltarMain.setOnClickListener(this);
        btnAvancarLayoutDois.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        if(v instanceof Button){

            switch (v.getId()){
                case R.id.btnExibir:{

                    showNome.setText("Nome: " +edtNome.getText());

                    if(rgSexo.getCheckedRadioButtonId() == R.id.rbtnMasculino){
                        showSexo.setText("Sexo:" + rbtnMasculino.getText());
                    }else{
                        showSexo.setText("Sexo:" + rbtnFeminino.getText());
                    }
                    break;
                }

                case R.id.btnLimpar:{
                    edtNome.setText("");
                    showNome.setText("");
                    showSexo.setText("");
                    rbtnMasculino.setSelected(false);
                    rbtnFeminino.setSelected(false);
                    break;
                }

                case R.id.btnAvancarLayoutDois:{
                    Intent i = new Intent(this,ActivityDois.class);
                    startActivity(i);
                    break;
                }

                case R.id.btnVoltarMain: {
                    Intent i = new Intent(this, MainActivity.class);
                    startActivity(i);
                    break;
                }

                default: break;
            }
        }
    }
}
