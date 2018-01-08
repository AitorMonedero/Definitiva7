package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import java.util.ArrayList;

/**
 * Created by Aitor & Jon on 20/12/2017.
 */

public class TerceraPantalla extends AppCompatActivity {


    Button siguiente,salir;
    TextView cajaCoca,cajaNaranja,cajaLimon,cajaAgua,cajaVino,cajaCerveza;
    Button masCola,masNaranja,masLimon,masVino,masCerveza,masAgua,menosCola,menosAgua,menosLimon,menosNaranja,menosVino,menosCerveza;

    double precio;
    ArrayList<String> pedido;
    int cantCoca;
    int cantNaranja;
    int cantLimon;
    int cantVino;
    int cantAgua;
    int cantCerveza;
    double precioCoca = 1.50,
            precioAgua = 1.00,
            precioVino = 2.00,
            precioNaranja = 1.50,
            precioLimon = 1.50,
            precioCerveza = 2.00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pantalla);



        siguiente = (Button) findViewById(R.id.button9);
        salir = (Button) findViewById(R.id.button11);

        cajaCoca = (TextView) findViewById(R.id.textView19);
        cajaNaranja = (TextView) findViewById(R.id.textView23);
        cajaLimon = (TextView) findViewById(R.id.textView16);
        cajaAgua = (TextView) findViewById(R.id.textView22);
        cajaVino = (TextView) findViewById(R.id.textView20);
        cajaCerveza = (TextView) findViewById(R.id.textView21);

        cantCoca = Integer.parseInt(cajaCoca.getText().toString());
        cantNaranja = Integer.parseInt(cajaNaranja.getText().toString());
        cantLimon = Integer.parseInt(cajaLimon.getText().toString());
        cantAgua = Integer.parseInt(cajaAgua.getText().toString());
        cantVino = Integer.parseInt(cajaVino.getText().toString());
        cantCerveza = Integer.parseInt(cajaCerveza.getText().toString());

        masCola = (Button) findViewById(R.id.masCoca);
        masNaranja = (Button) findViewById(R.id.masNaranja);
        masLimon = (Button) findViewById(R.id.masLimon);
        masAgua = (Button) findViewById(R.id.masAgua);
        masVino = (Button) findViewById(R.id.masVino);
        masCerveza = (Button) findViewById(R.id.masCerveza);

        menosCola = (Button) findViewById(R.id.menoCoca);
        menosAgua = (Button) findViewById(R.id.menosAgua);
        menosCerveza = (Button) findViewById(R.id.menosCerveza);
        menosLimon = (Button) findViewById(R.id.menosLimon);
        menosVino = (Button) findViewById(R.id.menosVino);
        menosNaranja = (Button) findViewById(R.id.menosNaranja);

        menosCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cantCoca==0) {
                }else{
                    cantCoca = cantCoca - 1;
                    cajaCoca.setText(""+cantCoca);
                    precio = precio - precioCoca;
                }
            }
        });
        masCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantCoca = cantCoca + 1;
                cajaCoca.setText(""+cantCoca);
                precio = precio + precioCoca;
            }
        });


        menosNaranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cantNaranja==0) {
                }else{
                    cantNaranja = cantNaranja - 1;
                    cajaNaranja.setText(""+cantNaranja);
                    precio = precio - precioNaranja;
                }
            }
        });
        masNaranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantNaranja = cantNaranja + 1;
                cajaNaranja.setText(""+cantNaranja);
                precio = precio + precioNaranja;
            }
        });


        menosLimon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cantLimon==0) {
                }else{
                    cantLimon = cantLimon - 1;
                    cajaLimon.setText(""+cantLimon);
                    precio = precio - precioLimon;
                }
            }
        });
        masLimon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantLimon = cantLimon + 1;
                cajaLimon.setText(""+cantLimon);
                precio = precio + precioLimon;
            }
        });

        menosAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cantAgua==0) {
                }else{
                    cantAgua = cantAgua - 1;
                    cajaAgua.setText(""+cantAgua);
                    precio = precio - precioAgua;
                }
            }
        });
        masAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantAgua = cantAgua + 1;
                cajaAgua.setText(""+cantAgua);
                precio = precio + precioAgua;
            }
        });

        menosVino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cantVino==0) {
                }else{
                    cantVino = cantVino - 1;
                    cajaVino.setText(""+cantVino);
                    precio = precio - precioVino;
                }
            }
        });
        masVino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantVino = cantVino + 1;
                cajaVino.setText(""+cantVino);
                precio = precio + precioVino;
            }
        });

        menosCerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(cantCerveza==0) {
                }else{
                    cantCerveza = cantCerveza - 1;
                    cajaCerveza.setText(""+cantCerveza);
                    precio = precio - precioCerveza;
                }
            }
        });
        masCerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantCerveza = cantCerveza + 1;
                cajaCerveza.setText(""+cantCerveza);
                precio = precio + precioCerveza;
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(cantCerveza == 0 && cantVino ==0 && cantAgua == 0 && cantLimon == 0 && cantNaranja == 0 && cantCoca == 0){
                    Toast.makeText(getApplicationContext(), "Tienes que elegir por lo menos una bebida.", Toast.LENGTH_SHORT).show();
                }else{

                    if (cantCoca > 0) {
                        pedido.add(cantCoca + " - Coca Cola.");
                    }
                    if (cantNaranja > 0) {
                        pedido.add(cantNaranja + " - Fanta Naranja.");
                    }
                    if (cantLimon > 0) {
                        pedido.add(cantLimon + " - Fanta Limon.");
                    }
                    if (cantAgua > 0) {
                        pedido.add(cantAgua + " - Agua.");
                    }
                    if (cantVino > 0) {
                        pedido.add(cantVino + " - Vino.");
                    }
                    if (cantCerveza > 0) {
                        pedido.add(cantCerveza + " - Cerveza.");
                    }

                    pedido.add("TOTAL: " + precio + "€");

                    if (precio > 15) {
                        pedido.add("Por haber superado los 15€ en el pedido, le vamos a hacer un reagalo de un peluche.");
                    }

                    if (precio > 20) {
                        pedido.add("Ademas del peluche, por haber superado tambien los 20€, le vamos a regalar un vale para comer en el comedor de Cebanc.");
                    }

                    pedido.add("MUCHAS GRACIAS.");

                    Intent intent = new Intent(TerceraPantalla.this, TerceraPantalla.class);
                    intent.putExtra("Usuarios", pedido);
                    startActivity(intent);
                    finish();
                }


            }
        });

    }
}
