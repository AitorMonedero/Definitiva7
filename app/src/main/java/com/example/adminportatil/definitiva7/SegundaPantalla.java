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


    private Button plus,minus;
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

        final TextView lblMensaje1;
        final String[] datos;
        final String[] masas;
        final String[] tamaños;


        datos = new String[]{"Pizza Barbacoa","Pizza Carbonara","Pizza 4 Quesos","Pizza Vegetal","Pizza Tropical"};
        masas = new String[]{"Fina","Normal"};
        tamaños = new String[]{"Individual","Mediana","Familiar"};

        lblMensaje1=(TextView) findViewById(R.id.lblMensaje1);

        //Elemento ArrayAdapter, que permite coger un Array como fuente de información.
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource (this, R.array.SpinnerArray, android.R.layout.simple_spinner_item);

        //Creamos nuestro Spinner
        cmbOpciones = (Spinner) findViewById (R.id.spnPizza);
        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        cmbOpciones.setAdapter(adaptador);

        cmbOpciones.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
                lblMensaje1.setText("Seleccionado: "+ datos[position]+","+masas[position]+","+tamaños[position]);
                //Podemos recuperar el ítem seleccionado usando
                //parent.getItemAtPosition(position)
            }
            public void onNothingSelected(AdapterView<?> parent) {
                lblMensaje1.setText("");
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
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
                lblMensaje1.setText("Seleccionado: "+ datos[position]+","+masas[position]+","+tamaños[position]);
                //Podemos recuperar el ítem seleccionado usando
                //parent.getItemAtPosition(position)
            }
            public void onNothingSelected(AdapterView<?> parent) {
                lblMensaje1.setText("");
            }
        });




        //Elemento ArrayAdapter, que permite coger un Array como fuente de información.
        ArrayAdapter<CharSequence> adaptador2 = ArrayAdapter.createFromResource (this, R.array.SpinnerTamaños, android.R.layout.simple_spinner_item);

        //Creamos nuestro Spinner
        opcionesTamaño = (Spinner) findViewById (R.id.spnTamaño);
        adaptador2.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        opcionesTamaño.setAdapter(adaptador2);

        opcionesMasa.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position2, long id) {
                lblMensaje1.setText("Seleccionado: "+ datos[position2]+","+masas[position2]+","+tamaños[position2]);
                //Podemos recuperar el ítem seleccionado usando
                //parent.getItemAtPosition(position)
            }
            public void onNothingSelected(AdapterView<?> parent) {
                lblMensaje1.setText("");
            }
        });


        plus=(Button)findViewById(R.id.btnPlus);
        minus=(Button)findViewById(R.id.btnMinus);
        cantidadTotal=(TextView)findViewById(R.id.txtCantidad);


        cantidadString=String.valueOf(cantidad);
        cantidadTotal.setText(cantidadString);

        plus.setOnClickListener(new View.OnClickListener()
                                       {
                                           public void onClick(View arg0){
                                              cantidad=cantidad+1;
                                              cantidadString=String.valueOf(cantidad);
                                              cantidadTotal.setText(cantidadString);
                                           }

                                       }

        );

        minus.setOnClickListener(new View.OnClickListener()
                                {
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
    }
}