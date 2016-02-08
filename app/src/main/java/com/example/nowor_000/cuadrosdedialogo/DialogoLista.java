package com.example.nowor_000.cuadrosdedialogo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

/**
 * Created by nowor_000 on 06/02/2016.
 */
public class DialogoLista extends DialogFragment {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.dialog_title)
                .setItems(R.array.items_array, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int item) {
                        Toast.makeText(getContext(), "Item Nº"+ item, Toast.LENGTH_SHORT).show();

                    }
                });
        return builder.create();
    }
}