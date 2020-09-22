package com.example.primeiroprojeto;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Button;
import android.widget.TextView;

public class HandlerMSG extends Handler {

   TextView tvStatusprocesso;
   Button btnProcessarHandlerMsg;
   public static final int HANDLE_MSG_FIM_PROCESSO = 1000;
   public static final int HANDLE_CONTADOR = 2000;

   public HandlerMSG(TextView tvStatusprocesso, Button btnProcessarHandlerMsg){
       this.btnProcessarHandlerMsg = btnProcessarHandlerMsg;
       this.tvStatusprocesso = tvStatusprocesso;
   }


    @Override
    public void handleMessage(Message msg) {
        if(msg.what == HANDLE_MSG_FIM_PROCESSO){
            btnProcessarHandlerMsg.setEnabled(true);
            tvStatusprocesso.setText("Processo Finalizado!");
        }

        if(msg.what == HANDLE_CONTADOR){
            Bundle bundle = msg.getData();
            tvStatusprocesso.setText(bundle.getString("CONTADOR"));
        }
    }

}
