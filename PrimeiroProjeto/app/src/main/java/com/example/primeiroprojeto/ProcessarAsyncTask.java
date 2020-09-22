package com.example.primeiroprojeto;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.widget.Button;
import android.widget.TextView;

// Parametros, Progresso, Resultado
public class ProcessarAsyncTask extends AsyncTask<Integer, Integer, Void> {

    private Button btnProcessarAsyncTask;
    private TextView tvStatusprocesso;

    public ProcessarAsyncTask(TextView tvStatusprocesso, Button btnProcessarAsyncTask){
        this.tvStatusprocesso = tvStatusprocesso;
        this.btnProcessarAsyncTask = btnProcessarAsyncTask;
    }

    @Override
    protected void onPreExecute() {
        btnProcessarAsyncTask.setEnabled(false);
    }

    @Override
    protected Void doInBackground(Integer... integers) {

        final int tempo = integers[0];

        for(int i = tempo; i >= 0; i--){
            SystemClock.sleep(500);
            publishProgress(i);
        }

        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        btnProcessarAsyncTask.setEnabled(true);
        tvStatusprocesso.setText("Processo Finalizado!");
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        int contador = values[0];
        tvStatusprocesso.setText(String.valueOf(contador));
    }
}
