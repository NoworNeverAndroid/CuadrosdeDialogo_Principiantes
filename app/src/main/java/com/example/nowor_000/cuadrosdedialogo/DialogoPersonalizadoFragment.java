package com.example.nowor_000.cuadrosdedialogo;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by nowor_000 on 03/02/2016.
 */
public class DialogoPersonalizadoFragment extends DialogFragment implements TextView.OnEditorActionListener {

    private  EditText mEditText;


    public interface NuevoDialogListener {
        void FinalizaCuadroDialogo(String texto);
    }

    // El contructor vacio es requerido para el dialogFragment
    public DialogoPersonalizadoFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialogo_personalizado, container);
        mEditText = (EditText) view.findViewById(R.id.ed_texto_dialog);

        // creamos una instancia para el escuchador de eventos para la accion de Edicion
        mEditText.setOnEditorActionListener(this);
        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getDialog().setTitle(" Mi Titulo");

        return view;
    }

    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        // Return input text to activity
        NuevoDialogListener activity = (NuevoDialogListener) getActivity();
        activity.FinalizaCuadroDialogo(mEditText.getText().toString());
        this.dismiss();
        return true;
    }
}