package com.example.segundoprojeto;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityDois extends Activity implements View.OnClickListener{

    Button btnVoltarLayoutUm;
    Button btnAvancarLayoutTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dois);

        btnVoltarLayoutUm = findViewById(R.id.btnVoltarLayoutUm);
        btnAvancarLayoutTres = findViewById(R.id.btnAvancarLayoutTres);

        btnVoltarLayoutUm.setOnClickListener(this);
        btnAvancarLayoutTres.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button){

            switch (v.getId()){

                case R.id.btnVoltarLayoutUm:{
                    Intent i = new Intent(this,ActivityUm.class);
                    startActivity(i);
                    break;
                }

                case R.id.btnAvancarLayoutTres: {
                    Intent i = new Intent(this,ActivityTres.class);
                    startActivity(i);
                    break;
                }

                default: break;
            }
        }

    }
}
