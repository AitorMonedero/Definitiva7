/*Actividad en la que se escogeran las pizzas*/

package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aitor & Jon on 04/12/2017.
 */

public class SegundaPantalla extends AppCompatActivity {


    private Button plus,minus,volver,siguiente;
    private int cantidad=0;
    private String cantidadString;
    private TextView cantidadTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        Spinner cmbOpciones;
        Spinner opcionesMasa;
        Spinner opcionesTamaño;

        final TextView lblMensaje;

        //LOS ARRAYS

            final String[] datos; // Array de los datos de los tipos de pizza
            final String[] masas; // Array de los datos de las masas de pizza
            final String[] tamaños; // Array de los datos de los tamaños de pizza

            //Rellenamos el array DATOS.
            datos = new String[]{"Pizza Barbacoa","Pizza Carbonara","Pizza 4 Quesos","Pizza Vegetal","Pizza Tropical"};
            //Rellenamos el array MASAS.
            masas = new String[]{"Fina","Normal"};
            //Rellenamos el array TAMAÑOS.
            tamaños = new String[]{"Individual","Mediana","Familiar"};

        //REFERENCIAS

            plus=(Button)findViewById(R.id.btnPlus);
            minus=(Button)findViewById(R.id.btnMinus);
            volver=(Button) findViewById(R.id.btnVolver);
            siguiente=(Button) findViewById(R.id.btnSiguiente);
            cantidadTotal=(TextView)findViewById(R.id.txtCantidad);

        cantidadString=String.valueOf(cantidad);
        cantidadTotal.setText(cantidadString);

        //Elemento ArrayAdapter, que permite coger un Array como fuente de información.
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource (this, R.array.SpinnerArray, android.R.layout.simple_spinner_item);

        //Creamos nuestro Spinner
        cmbOpciones = (Spinner) findViewById (R.id.spnPizza);
        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);

        cmbOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {

            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Array de las masas de la pizza

        //Elemento ArrayAdapter, que permite coger un Array como fuente de información.
        ArrayAdapter<CharSequence> adaptador1 = ArrayAdapter.createFromResource (this, R.array.SpinnerMasas, android.R.layout.simple_spinner_item);

        //Creamos nuestro Spinner
        opcionesMasa = (Spinner) findViewById (R.id.spnMasa);
        adaptador1.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        opcionesMasa.setAdapter(adaptador1);

        opcionesMasa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position1, long id) {

            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //Elemento ArrayAdapter, que permite coger un Array como fuente de información.
        ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource (this, R.array.SpinnerTamaños, android.R.layout.simple_spinner_item);

        //Creamos nuestro Spinner
        opcionesTamaño = (Spinner) findViewById (R.id.spnTamaño);
        adaptador2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        opcionesTamaño.setAdapter(adaptador2);

        opcionesMasa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {

            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });




        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                cantidad=cantidad+1;
                cantidadString=String.valueOf(cantidad);
                cantidadTotal.setText(cantidadString);
            }
        }

        );

        minus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                if(cantidad<1){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "No puedes pedir menos de 0 pizzas.", Toast.LENGTH_SHORT);
                    toast1.show();
                }else{
                    cantidad=cantidad-1;
                    cantidadString=String.valueOf(cantidad);
                    cantidadTotal.setText(cantidadString);
                }
            }
        }

        );

        volver.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                Intent intentaa=new Intent(SegundaPantalla.this,PantallaEleccion.class);
                startActivity(intentaa);
            }
        }

        );

        /*siguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){
                Intent intentaar=new Intent(SegundaPantalla.this,TerceraPantalla.class);
                startActivity(intentaar);
            }
        }

        );*/
    }
}