package com.example.projetospinner;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

public class DialogSair extends DialogFragment implements DialogInterface.OnClickListener {

    private ExitListener exitListener;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        if (!(activity instanceof ExitListener)) {
            throw new RuntimeException("Activity deve impleemntar a interface ExitListener");
        } else {
            exitListener = (ExitListener) activity;
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        return new AlertDialog.Builder(getActivity())
                .setTitle("Deseja sair?")
                .setPositiveButton("Sim", this)
                .setNegativeButton("Não", this)
                .create();
    }


    @Override
    public void onClick(DialogInterface dialog, int which) {
        if (which == DialogInterface.BUTTON_POSITIVE && exitListener != null) {
            exitListener.onExit();
        }
    }

    public interface ExitListener {
        public void onExit();
    }
}
