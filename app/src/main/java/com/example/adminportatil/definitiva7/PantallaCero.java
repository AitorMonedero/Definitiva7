package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by adminportatil on 27/12/2017.
 */


public class PantallaCero extends AppCompatActivity {

    private Button siguiente,salir;
    private EditText nombre,apellido,telefono,direccion,email;
    String nombre1,apellido1,direccion1,telefono1,email1;
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
            } else if (email.getText().length()==0 && isValidEmailAddress(email.getText().toString())==false){
                Toast toast6 = Toast.makeText(getApplicationContext(), "Email no válido.", Toast.LENGTH_SHORT);
                toast6.show();
            }else{

                nombre1=nombre.getText().toString();
                apellido1=apellido.getText().toString();
                telefono1=telefono.getText().toString();
                direccion1=direccion.getText().toString();
                email1=email.getText().toString();
                numPedido=(int) (Math.random() * 350) + 1;

                pedido.add(nombre1+" "+apellido1+" "+" \n \nDirección: "+direccion1+"  \n \n telefono:  "+telefono1+"  \n \ne-mail: "+email1+" " +" \n \nPedido #"+numPedido+".");
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

    public static boolean isValidEmailAddress(String correo) {
        boolean result;
        if(!correo.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+(.[a-zA-Z]{2,})$"))
            result=false;
        else result=true;

        return result;
    }

}



