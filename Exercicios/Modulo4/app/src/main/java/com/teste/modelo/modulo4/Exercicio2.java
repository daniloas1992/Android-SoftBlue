package com.teste.modelo.modulo4;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exercicio2 extends Activity implements View.OnClickListener {

    private final int VALOR_INICIAL = 10;
    private ViewHolder vH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio2);

        vH = new ViewHolder();

        vH.btnExecutarDois = findViewById(R.id.btnExecutarDois);
        vH.tvContDois = findViewById(R.id.tvContDois);

        vH.btnExecutarDois.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnExecutarDois:{
                processar();
                break;
            }

            default:break;
        }
    }

    private void processar() {

        Executar executar = new Executar(vH.tvContDois, vH.btnExecutarDois);
        executar.execute(VALOR_INICIAL);
        return;
    }

    static class ViewHolder{
        Button btnExecutarDois;
        TextView tvContDois;
    }

}
