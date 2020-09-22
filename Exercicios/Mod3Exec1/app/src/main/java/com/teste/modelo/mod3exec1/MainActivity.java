package com.teste.modelo.mod3exec1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener{

    private ViewHolder vH;
    public final static int REQUEST_CODE = 100;
    public final static String VALUE_CODE = "VALOR";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vH = new ViewHolder();
        vH.btnAbrirTelaDois = findViewById(R.id.btnAbrirTelaDois);
        vH.btnAbrirTelaDois.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnAbrirTelaDois:{
                Intent i = new Intent(this, Page2.class);

                int valor = Integer.parseInt(vH.btnAbrirTelaDois.getText().toString());
                i.putExtra(VALUE_CODE,valor);
                startActivityForResult(i, REQUEST_CODE);
                break;
            }
            default: break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == REQUEST_CODE){
            int valor = data.getIntExtra(VALUE_CODE, 0);
            vH.btnAbrirTelaDois.setText(String.valueOf(valor+1));
        }
    }

    static class ViewHolder{
        private Button btnAbrirTelaDois;
    }

}
