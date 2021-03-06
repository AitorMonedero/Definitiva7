/*Pantalla en la que se va a realizar la eleccion entre informacion o pedido*/

package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class PantallaEleccion extends AppCompatActivity {


    private Button informacion,pedido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_eleccion);

//BOTON DE INFORMACION
        informacion=(Button)findViewById(R.id.btnInfo);

        informacion.setOnClickListener(new View.OnClickListener()
                                    {
                                        public void onClick(View arg0){
                                            Intent inten=new Intent(PantallaEleccion.this,MainActivity.class);

                                            startActivity(inten);
                                            finish();
                                        }

                                    }

        );

//BOTON DE PEDIDO
        pedido=(Button)findViewById(R.id.btnPedido);

        pedido.setOnClickListener(new View.OnClickListener()
                                       {
                                           public void onClick(View arg0){
                                               Intent intenta=new Intent(PantallaEleccion.this,PantallaCero.class);

                                               startActivity(intenta);
                                               finish();
                                           }

                                       }

        );
    }

}
