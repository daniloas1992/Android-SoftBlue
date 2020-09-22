package com.example.projetospinner;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

public class MyDialogFragmentListSelecao extends DialogFragment implements AlertDialog.OnClickListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle("Escolha uma opção: ")
                .setSingleChoiceItems(R.array.opcoes,1,this) // Segundo parâmetro define qual está ppré-selecionado
                .create();

    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        String[] opcoes = getActivity().getResources().getStringArray(R.array.opcoes);

        String opcaoSelecionada = opcoes[which];

        Toast.makeText(getActivity(), "Cor selecionada: " + opcaoSelecionada, Toast.LENGTH_SHORT).show();
    }
}
