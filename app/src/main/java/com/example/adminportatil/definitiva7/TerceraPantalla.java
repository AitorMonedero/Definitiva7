package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Aitor & Jon on 20/12/2017.
 */

public class TerceraPantalla extends AppCompatActivity {


    private Button plus,minus,volver,siguiente;
    private int cantidad=0;
    private String cantidadString;
    private TextView cantidadTotal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pantalla);

        final Spinner cmbBebidas;
        final ImageView imagen;

        final String[] bebidas; // Array de los datos de los tamaños de pizza

        //Rellenamos el array DATOS.
        bebidas = new String[]{"Coca-Cola","Kas","Agua","Cerveza","Nestea","RedBull"};

        //Elemento ArrayAdapter, que permite coger un Array como fuente de información.
        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource (this, R.array.SpinnerBebidas, android.R.layout.simple_spinner_item);


        //Creamos nuestro Spinner
        cmbBebidas = (Spinner) findViewById (R.id.spnBebida);

        imagen = (ImageView) findViewById(R.id.imageView3);
        adaptador.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        cmbBebidas.setAdapter(adaptador);

        cmbBebidas.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            public void onItemSelected(AdapterView<?> parent, android.view.View v, int position, long id) {
               if (cmbBebidas.getSelectedItemPosition()==0){
                imagen.setImageResource(R.drawable.cocacola);
               }else if(cmbBebidas.getSelectedItemPosition()==1){
                   imagen.setImageResource(R.drawable.kas);
               }else if(cmbBebidas.getSelectedItemPosition()==2){
                   imagen.setImageResource(R.drawable.agua);
               }else if(cmbBebidas.getSelectedItemPosition()==3){
                   imagen.setImageResource(R.drawable.cerveza);
               }else if(cmbBebidas.getSelectedItemPosition()==4){
                   imagen.setImageResource(R.drawable.nestea);
               }else if(cmbBebidas.getSelectedItemPosition()==5){
                   imagen.setImageResource(R.drawable.redbull);
               }
            }
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        plus=(Button)findViewById(R.id.btnPlus);
        minus=(Button)findViewById(R.id.btnMinus);
        volver=(Button) findViewById(R.id.btnVolver);
        siguiente=(Button) findViewById(R.id.btnSiguiente);
        cantidadTotal=(TextView)findViewById(R.id.txtCantidad);

        cantidadString=String.valueOf(cantidad);
        cantidadTotal.setText(cantidadString);

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
                                             Toast toast1 = Toast.makeText(getApplicationContext(), "No puedes pedir menos de 0 bebidas.", Toast.LENGTH_SHORT);
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
                                          Intent intentaa=new Intent(TerceraPantalla.this,SegundaPantalla.class);
                                          startActivity(intentaa);
                                      }
                                  }

        );

        siguiente.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View arg0){
                                             Intent intentaar=new Intent(TerceraPantalla.this,TerceraPantalla.class);
                                             startActivity(intentaar);
                                         }
                                     }

        );

    }
}
