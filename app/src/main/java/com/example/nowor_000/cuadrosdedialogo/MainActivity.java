package com.example.nowor_000.cuadrosdedialogo;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, DialogoPersonalizadoFragment.NuevoDialogListener {



    private Button btnFragmentDialog, btnAlertBasico, btnAlertLista,btnAlertMultiopcion, btnPersonalizado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addView();
    }

    private void addView() {

        btnFragmentDialog=(Button) findViewById(R.id.btnDialogFragment);
       btnFragmentDialog.setOnClickListener(this);

        btnAlertBasico =(Button) findViewById(R.id.btnAlertBasico);
        btnAlertBasico.setOnClickListener(this);

        btnAlertLista=(Button) findViewById(R.id.btnAlertLista);
        btnAlertLista.setOnClickListener(this);

        btnAlertMultiopcion=(Button) findViewById(R.id.btnMultiopcion);
        btnAlertMultiopcion.setOnClickListener(this);

        btnPersonalizado=(Button) findViewById(R.id.btnPersonalizado);
        btnPersonalizado.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){


            case R.id.btnDialogFragment:
               fragmentDialog();
                break;


            case R.id.btnAlertBasico:
                alertDialogBasico();
                break;


            case R.id.btnAlertLista:
               alertDialogLista();
                break;


            case R.id.btnMultiopcion:
                alertDialogMultiopcion();
                break;

            case R.id.btnPersonalizado:
                dialogoPersonalizado();
            break;





            default:
                break;

        }
    }



    public void fragmentDialog(){


        DialogFragment dialog= new DialogoFragment();
        dialog.show(getSupportFragmentManager(), "dialogo");


    }

    public void alertDialogBasico(){


        // 1. Instancia de AlertDialog.Builder con este constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        // 2. Encadenar varios métodos setter para ajustar las características del diálogo
        builder.setMessage(R.string.dialog_message)
                .setTitle(R.string.dialog_title);


        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });
        builder.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {

            }
        });

        builder.show();

    }

    public void alertDialogLista(){
        DialogoLista lista = new DialogoLista();
        lista.show(getSupportFragmentManager(),"lista");
    }

    public void alertDialogMultiopcion(){
        DialogoMultiopcion multiopcion = new DialogoMultiopcion();
        multiopcion.show(getSupportFragmentManager(),"multiopcion");
    }

    public void dialogoPersonalizado(){
        DialogoPersonalizadoFragment dialogoPersonalizado = new DialogoPersonalizadoFragment();
        dialogoPersonalizado.show(getSupportFragmentManager(), "personalizado");

        android.app.Fragment frag = getFragmentManager().findFragmentByTag("personalizado");

        if (frag != null) {
            getFragmentManager().beginTransaction().remove(frag).commit();
        }
    }

    /**
     * Dialogo personalizado termina
     * @param texto
     */
    @Override
    public void FinalizaCuadroDialogo(String texto) {
        Toast.makeText(this, texto ,Toast.LENGTH_SHORT).show();

    }
}
