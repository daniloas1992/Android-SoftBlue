package com.example.segundoprojeto;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.app.Activity;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

public class TelaQuatro extends Activity {

    TextView tvDadosProcessados;
    ProgressBar progressProcessandoDados;
    private int tempoAnimacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_quatro);

        tvDadosProcessados = findViewById(R.id.tvDadosProcessados);
        progressProcessandoDados = findViewById(R.id.progressProcessandoDados);

        tempoAnimacao = getResources().getInteger(android.R.integer.config_longAnimTime);

        tvDadosProcessados.setVisibility(View.GONE);
        progressProcessandoDados.setVisibility(View.VISIBLE);

        processarDados();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    public void processarDados(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(5000);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        processamentoFinalizado();
                    }
                });

            }
        }).start();
    }

    public void processamentoFinalizado(){
        //progressProcessandoDados.setVisibility(View.GONE);
        //tvDadosProcessados.setVisibility(View.VISIBLE);

        tvDadosProcessados.setVisibility(View.VISIBLE);
        tvDadosProcessados.setAlpha(0.0f); // tranaparência 0=transparente  1=opaco
        tvDadosProcessados.animate().alpha(1.0f).setDuration(tempoAnimacao).setListener(null);

        progressProcessandoDados.animate().alpha(0.0f).setDuration(tempoAnimacao).setListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                progressProcessandoDados.setVisibility(View.GONE);
            }
        });



    }

}
