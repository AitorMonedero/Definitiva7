/*Actividad en la que se escogeran las pizzas*/

package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Aitor & Jon on 04/12/2017.
 */

public class SegundaPantalla extends AppCompatActivity {



    private Button plus,minus,volver,siguiente,añadir;
    private int cantidad=1,sumaCantidad=0;
    private double precio=0,precioTotal=0;
    private String cantidadString,tipo,masa,tamaño,frase,precioString;
    private TextView cantidadTotal,precioStrings;
    ArrayList<String> pedido;


   RadioGroup TipoPizzas,TamañoPizzas,TipoMasas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        //pedido=new ArrayList<String>();

        Bundle bundle = getIntent().getExtras();
        pedido=bundle.getStringArrayList("Usuarios");


        TipoPizzas = (RadioGroup) findViewById(R.id.tipo01);
        TamañoPizzas = (RadioGroup) findViewById(R.id.tamaño01);
        TipoMasas = (RadioGroup) findViewById(R.id.masa01);

        plus=(Button)findViewById(R.id.btnPlus);
        minus=(Button)findViewById(R.id.btnMinus);
        volver=(Button) findViewById(R.id.btnVolver);
        siguiente=(Button) findViewById(R.id.btnSiguiente);
        añadir=(Button) findViewById(R.id.btnCompra);

        cantidadTotal=(TextView)findViewById(R.id.txtCantidad);
        precioStrings=(TextView) findViewById(R.id.txtPrecio);


        cantidadString=String.valueOf(cantidad);
        cantidadTotal.setText(cantidadString);

        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){

                    cantidad = cantidad + 1;
                    cantidadString = String.valueOf(cantidad);
                    cantidadTotal.setText(cantidadString);


            }
        }

        );

        añadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){

                if(TipoPizzas.getCheckedRadioButtonId() == -1){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debes seleccionar el tipo de pizza que deseas.", Toast.LENGTH_SHORT);
                    toast1.show();
                }else if(cantidadTotal.getText().toString().length() <1){
                    Toast.makeText(getApplicationContext(), "Tiene que haber alguna pizza para añadir", Toast.LENGTH_SHORT).show();
                }else if(TipoMasas.getCheckedRadioButtonId()==-1){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debes seleccionar el tipo de masa que deseas.", Toast.LENGTH_SHORT);
                    toast1.show();
                }else if(TamañoPizzas.getCheckedRadioButtonId()==-1){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debes seleccionar el tamaño de pizza que deseas.", Toast.LENGTH_SHORT);
                    toast1.show();
                }else{
                    if (TipoPizzas.getCheckedRadioButtonId() == R.id.btnCarbonara){
                        tipo = "Pizza carbonara ";
                    }else if (TipoPizzas.getCheckedRadioButtonId() == R.id.btnBarbacoa){
                        tipo = "Pizza barbacoa ";
                    }else if (TipoPizzas.getCheckedRadioButtonId() == R.id.btnQuesos){
                        tipo = "Pizza 4 quesos ";
                    }else if (TipoPizzas.getCheckedRadioButtonId() == R.id.btnVegetal){
                        tipo = "Pizza vegetal ";
                    }else if (TipoPizzas.getCheckedRadioButtonId() == R.id.btnTropical){
                        tipo = "Pizza tropical ";
                    }


                    if (TipoMasas.getCheckedRadioButtonId()==R.id.btnFina){
                        masa="de masa fina";
                    }else if(TipoMasas.getCheckedRadioButtonId()==R.id.btnNormal){
                        masa="de masa normal";
                    }


                    if (TamañoPizzas.getCheckedRadioButtonId()==R.id.btnIndividual){
                        tamaño="individual ";
                        precio=6;
                    }else if(TamañoPizzas.getCheckedRadioButtonId()==R.id.btnMediana){
                        tamaño="mediana ";
                        precio=10;
                    }else if(TamañoPizzas.getCheckedRadioButtonId()==R.id.btnFamiliar){
                        tamaño="familiar ";
                        precio=12;
                    }

                    sumaCantidad=sumaCantidad+cantidad;
                    precioTotal=precioTotal+(precio*cantidad);
                    precioString=String.valueOf(precioTotal)+"€";
                    precioStrings.setText(precioString);
                    cantidadString=String.valueOf(cantidad)+"x ";
                    frase=cantidadString+tipo+tamaño+masa+" "+(precio*cantidad)+"€.";
                    pedido.add(frase);
                    Toast.makeText(getApplicationContext(), "Añadido con exito al carro de la compra", Toast.LENGTH_SHORT).show();
                    cantidad = 1;
                    cantidadTotal.setText("1");

                }


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
                Intent intentaa=new Intent(SegundaPantalla.this,PantallaCero.class);
                startActivity(intentaa);

            }
        }

        );

        siguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){

                if(sumaCantidad==0){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "No puedes pedir menos de 1 pizza.", Toast.LENGTH_SHORT);
                    toast1.show();
                }else {
                    Intent intentaar = new Intent(SegundaPantalla.this, TerceraPantalla.class);
                    intentaar.putExtra("Usuarios", pedido);
                    intentaar.putExtra("Dinero", precioTotal);
                    startActivity(intentaar);
                    finish();
                }

            }
        }

        );
    }
}