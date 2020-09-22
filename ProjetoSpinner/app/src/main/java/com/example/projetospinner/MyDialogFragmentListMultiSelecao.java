package com.example.projetospinner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MyDialogFragmentListMultiSelecao extends DialogFragment implements DialogInterface.OnMultiChoiceClickListener {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        boolean[] itensPreChecados = {true,false,true,false,false};

        return new AlertDialog.Builder(getActivity())
                .setTitle("Escolha uma opção: ")
                .setMultiChoiceItems(R.array.opcoes, itensPreChecados,this) // Segundo parâmetro define qual está ppré-selecionado
                .create();

    }

    @Override
    public void onClick(DialogInterface dialog, int which, boolean isChecked) {
        String[] opcoes = getActivity().getResources().getStringArray(R.array.opcoes);

        String opcaoSelecionada = opcoes[which];

        if(isChecked){
            Toast.makeText(getActivity(), "Cor selecionada: " + opcaoSelecionada, Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(getActivity(), "Cor desmarcada: " + opcaoSelecionada, Toast.LENGTH_SHORT).show();
        }
    }
}
