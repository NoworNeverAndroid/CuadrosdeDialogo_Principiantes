package com.example.nowor_000.cuadrosdedialogo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by nowor_000 on 06/02/2016.
 */
public class DialogoMultiopcion extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final ArrayList mSelectedItems = new ArrayList();  // Where we track the selected items

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // INDICA EL TITULO DEL DIALOG
        builder.setTitle(R.string.dialog_title)
                // ESPECIFICAMOS EL ARRAY DE ITEMS
                // AÑADIMOS UNOS CALLBACK PARA CUANDO SE PULSE UN BOTON
                .setMultiChoiceItems(R.array.items_array, null,
                        new DialogInterface.OnMultiChoiceClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int item, boolean isChecked) {
                                if (isChecked) {
                                    // If the user checked the item, add it to the selected items
                                    mSelectedItems.add(item);
                                } else if (mSelectedItems.contains(item)) {
                                    // Else, if the item is already in the array, remove it
                                    mSelectedItems.remove(Integer.valueOf(item));
                                }
                            }
                        })

                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        // User clicked OK, so save the mSelectedItems results somewhere
                        // or return them to the component that opened the dialog
                        String items="";
                        String array_items[]=getResources().getStringArray(R.array.items_array);

                        for(int i=0; i<mSelectedItems.size(); i++){


                            items+=""+array_items[((int) mSelectedItems.get(i))]+ "\n";
                        }
                        Toast.makeText(getContext(), items , Toast.LENGTH_SHORT).show();



                    }
                })

                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

        return builder.create();
    }
}
