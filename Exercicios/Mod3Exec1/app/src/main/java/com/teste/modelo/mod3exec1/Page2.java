package com.teste.modelo.mod3exec1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Page2 extends Activity implements View.OnClickListener{

    private ViewHolder vH;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);

        Bundle extras = getIntent().getExtras();
        int valor = extras.getInt(MainActivity.VALUE_CODE, 0);

        vH = new ViewHolder();
        vH.btnVoltar = findViewById(R.id.btnVoltar);
        vH.btnVoltar.setOnClickListener(this);
        vH.btnVoltar.setText(String.valueOf(valor+1));
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent();
        int valor = Integer.parseInt(vH.btnVoltar.getText().toString());
        i.putExtra(MainActivity.VALUE_CODE, valor);
        setResult(MainActivity.REQUEST_CODE, i);
        finish();
    }

    static class ViewHolder{
        private Button btnVoltar;
    }
}
