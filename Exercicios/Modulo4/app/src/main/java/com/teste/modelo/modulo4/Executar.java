package com.teste.modelo.modulo4;

import android.os.AsyncTask;
import android.widget.Button;
import android.widget.TextView;

public class Executar extends AsyncTask <Integer,Integer,Void> { // Parâmetros, Progresso, Resultado

    TextView tvValor;
    Button btnExecutar;

    public Executar(TextView tv, Button btn) {
        this.tvValor = tv;
        this.btnExecutar = btn;
    }


    @Override
    protected void onPreExecute() {
        btnExecutar.setEnabled(false);
    }

    @Override
    protected Void doInBackground(Integer... values) {

        int valorInicial = values[0];

        for(int i = valorInicial; i >= 0; i--){

            try{
                Thread.sleep(1000);
            } catch (InterruptedException ex){
                ex.printStackTrace();
            }

            publishProgress(i);
        }

        return null;
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        tvValor.setText(String.valueOf(values[0]));
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        btnExecutar.setEnabled(true);
    }
}
