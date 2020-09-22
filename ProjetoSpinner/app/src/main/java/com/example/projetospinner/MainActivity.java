package com.example.projetospinner;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener, View.OnClickListener,DialogSair.ExitListener{

    private ArrayAdapter<Character> adapter;
    private Spinner spnLetras;
    private Button btnAbrirDialog;
    private Button btnAbrirDialogLista;
    private Button btnAbrirDialogListaSelecao;
    private Button btnAbrirDialogListaSelecaoMultipla;
    private Button btnAbrirDataHora;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spnLetras = findViewById(R.id.spnLetras);
        btnAbrirDialog = findViewById(R.id.btnAbrirDialog);
        btnAbrirDialogLista = findViewById(R.id.btnAbrirDialogLista);
        btnAbrirDialogListaSelecao = findViewById(R.id.btnAbrirDialogListaSelecao);
        btnAbrirDialogListaSelecaoMultipla = findViewById(R.id.btnAbrirDialogListaSelecaoMultipla);
        btnAbrirDataHora = findViewById(R.id.btnAbrirDataHora);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item );
        adapter.add('A');
        adapter.add('B');
        adapter.add('C');
        adapter.add('D');

        spnLetras.setAdapter(adapter);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spnLetras.setOnItemSelectedListener(this);
        btnAbrirDialog.setOnClickListener(this);
        btnAbrirDialogLista.setOnClickListener(this);
        btnAbrirDialogListaSelecao.setOnClickListener(this);
        btnAbrirDialogListaSelecaoMultipla.setOnClickListener(this);
        btnAbrirDataHora.setOnClickListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Character letra = adapter.getItem(position);
        Toast.makeText(this, "Selecionado: "+ letra, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if(v instanceof Button){
            switch(v.getId()){

                case R.id.btnAbrirDialog:{
                    MyDialogFragment dialog = new MyDialogFragment();
                    dialog.show(getFragmentManager(),"MyDialog");
                    break;
                }

                case R.id.btnAbrirDialogLista:{

                    MyDialogFragmentList dialogList = new MyDialogFragmentList();
                    dialogList.show(getFragmentManager(),"MyDialogList");
                    break;
                }

                case R.id.btnAbrirDialogListaSelecao:{
                    MyDialogFragmentListSelecao dialogListSelecao = new MyDialogFragmentListSelecao();
                    dialogListSelecao.show(getFragmentManager(),"MyDialogListSelecao");
                    break;
                }

                case R.id.btnAbrirDialogListaSelecaoMultipla:{
                    MyDialogFragmentListMultiSelecao dialogListMultiSelecao = new MyDialogFragmentListMultiSelecao();
                    dialogListMultiSelecao.show(getFragmentManager(),"MyDialogListMultiSelecao");
                    break;
                }

                case R.id.btnAbrirDataHora:{
                    Intent i = new Intent(this, SelecaoDataHora.class);
                    startActivity(i);
                    break;
                }
            }

        }
    }

    @Override
    public void onBackPressed() {
        DialogSair sairDialog = new DialogSair();
        sairDialog.show(getFragmentManager(),"Sair");

    }

    @Override
    public void onExit() {
        finish();
    }
}
