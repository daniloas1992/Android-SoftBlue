package com.teste.modelo.modulo4;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Exercicio1 extends Activity implements View.OnClickListener {

    private ViewHolder vH;
    private final int VALOR_INICIAL = 10;
    private final int UPDATE_COUNT  = 1000;
    private final int UPDATE_FINISH  = 1001;

    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercicio1);

        vH = new ViewHolder();



        vH.btnExecutarUm = findViewById(R.id.btnExecutarUm);
        vH.tvContUm = findViewById(R.id.tvContUm);

        vH.btnExecutarUm.setOnClickListener(this);
        vH.tvContUm.setText(String.valueOf(VALOR_INICIAL));

        handler = new Handler(){

            @Override
            public void handleMessage(Message msg) {
                if(msg.what == UPDATE_COUNT){
                    int valor = msg.arg1;
                    vH.tvContUm.setText(String.valueOf(valor));
                }

                if(msg.what == UPDATE_FINISH){
                    if(msg.arg1 == 1);
                    vH.btnExecutarUm.setEnabled(true);
                }
            }
        };

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnExecutarUm:{

                vH.btnExecutarUm.setEnabled(false);
                processar();
                break;
            }

            default:break;
        }
    }

    private void processar() {

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {

                for (int i = VALOR_INICIAL; i >= 0; i--){

                    try{
                        Thread.sleep(1000);
                    } catch (InterruptedException ex){
                        ex.printStackTrace();
                    }

                    Message m = Message.obtain();
                    m.what = UPDATE_COUNT;
                    m.arg1 = i;
                    handler.sendMessage(m);
                }

                Message m = Message.obtain();
                m.what = UPDATE_FINISH;
                m.arg1 = 1;
                handler.sendMessage(m);

            }
        });

        t.start();
    }

    static class ViewHolder{
        Button btnExecutarUm;
        TextView tvContUm;
    }

}
