/*Actividad en la que se escogeran las pizzas*/

package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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