package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by adminportatil on 27/12/2017.
 */


public class PantallaCero extends AppCompatActivity {

    private Button siguiente,salir;
    private EditText nombre,apellido,telefono,direccion,email;
    String nombre1,apellido1;
    int numPedido;

    ArrayList<String> pedido;
    @Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_cero_pantalla);

    pedido=new ArrayList<String>();

        siguiente=(Button)findViewById(R.id.BotonSig);
        nombre=(EditText)findViewById(R.id.editText);
        apellido=(EditText)findViewById(R.id.editText2);
        direccion=(EditText)findViewById(R.id.editText4);
        email=(EditText)findViewById(R.id.editText5);
        telefono=(EditText)findViewById(R.id.editText3);



        siguiente.setOnClickListener(new View.OnClickListener()
        {
        public void onClick(View arg0){
            if (nombre.getText().length()==0){
                Toast toast1 = Toast.makeText(getApplicationContext(), "Tienes que introducir un nombre.", Toast.LENGTH_SHORT);
                toast1.show();
                nombre.requestFocus();
            }else if(apellido.getText().length()==0){
                Toast toast2 = Toast.makeText(getApplicationContext(), "Tienes que introducir un apellido.", Toast.LENGTH_SHORT);
                toast2.show();
                apellido.requestFocus();
            }else if(telefono.getText().length()==0){
                Toast toast3 = Toast.makeText(getApplicationContext(), "Tienes que introducir un telefono.", Toast.LENGTH_SHORT);
                toast3.show();
                telefono.requestFocus();
            }else if(telefono.getText().length()!=9){
                Toast toast3 = Toast.makeText(getApplicationContext(), "El telefono debe ser de 9 digitos.", Toast.LENGTH_SHORT);
                toast3.show();
                telefono.requestFocus();
            }else if(direccion.getText().length()==0){
                Toast toast4 = Toast.makeText(getApplicationContext(), "Tienes que introducir una direccion.", Toast.LENGTH_SHORT);
                toast4.show();
                direccion.requestFocus();
            }else if(email.getText().length()==0){
                Toast toast5 = Toast.makeText(getApplicationContext(), "Tienes que introducir un email.", Toast.LENGTH_SHORT);
                toast5.show();
                email.requestFocus();
            } else{

                nombre1=nombre.getText().toString();
                apellido1=apellido.getText().toString();
                numPedido=(int) (Math.random() * 350) + 1;

                pedido.add(nombre1+" "+apellido1+" "+"Pedido #"+numPedido);
             Intent inten=new Intent(PantallaCero.this,PantallaEleccion.class);
            inten.putExtra("Usuarios",pedido);
             startActivity(inten);}
        }

       }

        );

        salir=(Button)findViewById(R.id.BotonFin);

        salir.setOnClickListener(new View.OnClickListener()
                                     {
                                         public void onClick(View arg0){
                                           finish();
                                         }

                                     }

        );

}

}
