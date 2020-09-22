package com.example.primeiroprojeto;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView tvMain;
    TextView tvStatusprocesso;
    Button btnAbrirSegundaTela;
    Button btnProcessar;
    Button btnProcessarHandlerPost;
    Button btnProcessarHandlerMsg;
    Button btnProcessarAsyncTask;
    Button btnProcessarHandlerContador;
    final private int ID_ACTIVITY_MAIN = 1;
    final private int TEMPO_PROCESSO_SEGUNDOS = 10;
    final private int TEMPO_PROCESSO_MILISEGUNDOS = 7500;

    private Handler handler = new Handler();
    private HandlerMSG handlerMSG;
    private HandlerMSG handlerContador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        tvMain                  = findViewById(R.id.tvMain);
        tvStatusprocesso        = findViewById(R.id.tvStatusProcesso);
        btnAbrirSegundaTela     = findViewById(R.id.btnAbrirSegundaTela);
        btnProcessar            = findViewById(R.id.btnProcessar);
        btnProcessarHandlerPost = findViewById(R.id.btnProcessarHandlerPost);
        btnProcessarHandlerMsg  = findViewById(R.id.btnProcessarHandlerMsg);
        btnProcessarAsyncTask   = findViewById(R.id.btnProcessarAsyncTask);
        btnProcessarHandlerContador = findViewById(R.id.btnProcessarHandlerContador);

        handlerMSG = new HandlerMSG(tvStatusprocesso,btnProcessarHandlerMsg);
        handlerContador = new HandlerMSG(tvStatusprocesso,btnProcessarHandlerContador);

        btnProcessar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvStatusprocesso.setText("Processando...");
                btnProcessar.setEnabled(false);
                btnProcessarHandlerPost.setEnabled(false);
                processarAlgoDemorado();
            }
        });

        btnProcessarHandlerPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvStatusprocesso.setText("Processando com Handler POST...");
                btnProcessar.setEnabled(false);
                btnProcessarHandlerPost.setEnabled(false);
                processarComHandlerPost();
            }
        });

        btnProcessarHandlerMsg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvStatusprocesso.setText("Processando com Handler MSG...");
                btnProcessarHandlerMsg.setEnabled(false);
                processarComHandlerMSG();
            }
        });

        btnProcessarAsyncTask.setOnClickListener(new View.OnClickListener(){
           @Override
            public void onClick(View v){
                processarAsyncTask();
           }
        });

        btnProcessarHandlerContador.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                btnProcessarHandlerContador.setEnabled(false);
                processarComHandlerContador();
            }
        });
    }

    public void abrir_segunda_tela(View view) {
        Intent i = new Intent(this, SegundaTela.class);
        i.putExtra("id_texto","Envio de Texto");
        startActivityForResult(i, ID_ACTIVITY_MAIN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == ID_ACTIVITY_MAIN){
            if(resultCode == RESULT_OK){
                if(data != null){
                    tvMain.setText(data.getStringExtra("resultado"));
                    btnAbrirSegundaTela.setEnabled(false);
                }
            }
        }
    }

    private void processarAlgoDemorado(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(TEMPO_PROCESSO_MILISEGUNDOS);

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvStatusprocesso.setText("Processo Finalizado!");
                        btnProcessar.setEnabled(true);
                        btnProcessarHandlerPost.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void processarComHandlerPost() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(TEMPO_PROCESSO_MILISEGUNDOS);

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        tvStatusprocesso.setText("Processo Finalizado!");
                        btnProcessar.setEnabled(true);
                        btnProcessarHandlerPost.setEnabled(true);
                    }
                });
            }
        }).start();
    }

    private void processarComHandlerMSG(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SystemClock.sleep(TEMPO_PROCESSO_MILISEGUNDOS);

                Message msg = Message.obtain();
                msg.what = HandlerMSG.HANDLE_MSG_FIM_PROCESSO;
                handlerMSG.sendMessage(msg);
            }
        }).start();
    }

    private void processarAsyncTask(){
        ProcessarAsyncTask processo = new ProcessarAsyncTask(tvStatusprocesso,btnProcessarAsyncTask);
        processo.execute(TEMPO_PROCESSO_SEGUNDOS);
    }

    private void processarComHandlerContador(){
        new Thread(new Runnable() {
            @Override
            public void run() {

                for(int i = TEMPO_PROCESSO_SEGUNDOS; i >= 0; i--){
                    Message msg = Message.obtain();
                    SystemClock.sleep(1000);
                    msg.what = HandlerMSG.HANDLE_CONTADOR;
                    Bundle bundle = new Bundle();
                    bundle.putString("CONTADOR",String.valueOf(i));
                    msg.setData(bundle);
                    handlerContador.sendMessage(msg);
                }

                Message msg = Message.obtain();
                msg.what = HandlerMSG.HANDLE_MSG_FIM_PROCESSO;
                handlerContador.sendMessage(msg);
            }
        }).start();
    }

}
