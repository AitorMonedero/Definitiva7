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


    Button siguiente, salir, carrito;
    TextView cajaCoca, cajaNaranja, cajaLimon, cajaAgua, cajaVino, cajaCerveza, price;
    Button masCocaCola, masNaranja, masLimon, masRedbull, masCerveza, masAgua, menosCola, menosAgua, menosLimon, menosNaranja, menosRedBull, menosCerveza;


    ArrayList<String> pedido;

    int cantCoca,
            cantTotal,
            cantNaranja,
            cantLimon,
            cantVino,
            cantAgua,
            cantCerveza;

    double precio,
            precioCoca = 1.50,
            precioAgua = 1.00,
            precioRedBull = 2.00,
            precioNestea = 1.50,
            precioKas = 1.50,
            precioCerveza = 2.00;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pantalla);

        Bundle bundle = getIntent().getExtras();
        pedido = bundle.getStringArrayList("Usuarios");
        precio = bundle.getDouble("Dinero");

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

        masCocaCola = (Button) findViewById(R.id.masCoca);
        masNaranja = (Button) findViewById(R.id.masNaranja);
        masLimon = (Button) findViewById(R.id.masLimon);
        masAgua = (Button) findViewById(R.id.masAgua);
        masRedbull = (Button) findViewById(R.id.masRedbull);
        masCerveza = (Button) findViewById(R.id.masCerveza);

        menosCola = (Button) findViewById(R.id.menoCoca);
        menosAgua = (Button) findViewById(R.id.menosAgua);
        menosCerveza = (Button) findViewById(R.id.menosCerveza);
        menosLimon = (Button) findViewById(R.id.menosLimon);
        menosRedBull = (Button) findViewById(R.id.menosRedBull);
        menosNaranja = (Button) findViewById(R.id.menosNaranja);
        carrito = (Button) findViewById(R.id.btnCompra);


        price = (TextView) findViewById(R.id.txtPrecio);
        price.setText(String.valueOf(precio));

        menosCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantCoca != 0) {
                    cantCoca = cantCoca - 1;
                    cajaCoca.setText("" + cantCoca);
                    precio = precio - precioCoca;
                }
            }
        });
        masCocaCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantCoca = cantCoca + 1;
                cajaCoca.setText("" + cantCoca);
                precio = precio + precioCoca;
            }
        });


        menosNaranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantNaranja != 0) {
                    cantNaranja = cantNaranja - 1;
                    cajaNaranja.setText("" + cantNaranja);
                    precio = precio - precioNestea;
                }
            }
        });
        masNaranja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantNaranja = cantNaranja + 1;
                cajaNaranja.setText("" + cantNaranja);
                precio = precio + precioNestea;
            }
        });


        menosLimon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantLimon == 0) {
                } else {
                    cantLimon = cantLimon - 1;
                    cajaLimon.setText("" + cantLimon);
                    precio = precio - precioKas;
                }
            }
        });
        masLimon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantLimon = cantLimon + 1;
                cajaLimon.setText("" + cantLimon);
                precio = precio + precioKas;
            }
        });

        menosAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantAgua == 0) {
                } else {
                    cantAgua = cantAgua - 1;
                    cajaAgua.setText("" + cantAgua);
                    precio = precio - precioAgua;
                }
            }
        });
        masAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantAgua = cantAgua + 1;
                cajaAgua.setText("" + cantAgua);
                precio = precio + precioAgua;
            }
        });

        menosRedBull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantVino == 0) {
                } else {
                    cantVino = cantVino - 1;
                    cajaVino.setText("" + cantVino);
                    precio = precio - precioRedBull;
                }
            }
        });
        masRedbull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantVino = cantVino + 1;
                cajaVino.setText("" + cantVino);
                precio = precio + precioRedBull;
            }
        });

        menosCerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantCerveza == 0) {
                } else {
                    cantCerveza = cantCerveza - 1;
                    cajaCerveza.setText("" + cantCerveza);
                    precio = precio - precioCerveza;
                }
            }
        });
        masCerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantCerveza = cantCerveza + 1;
                cajaCerveza.setText("" + cantCerveza);
                precio = precio + precioCerveza;
            }
        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (cantCerveza == 0 && cantVino == 0 && cantAgua == 0 && cantLimon == 0 && cantNaranja == 0 && cantCoca == 0) {
                    Toast.makeText(getApplicationContext(), "Tienes que seleccionar por lo menos una bebida.", Toast.LENGTH_SHORT).show();
                } else {

                    if (cantCoca > 0) {
                        pedido.add(cantCoca + "x Coca Cola ("+(cantCoca*precioCoca)+"€).");
                    }
                    if (cantNaranja > 0) {
                        pedido.add(cantNaranja + "x Fanta Naranja ("+(cantNaranja*precioNestea)+"€).");
                    }
                    if (cantLimon > 0) {
                        pedido.add(cantLimon + "x Fanta Limon ("+(cantLimon*precioKas)+"€).");
                    }
                    if (cantAgua > 0) {
                        pedido.add(cantAgua + "x Agua ("+(cantAgua*precioAgua)+"€).");
                    }
                    if (cantVino > 0) {
                        pedido.add(cantVino + "x Vino ("+(cantVino*precioRedBull)+"€).");
                    }
                    if (cantCerveza > 0) {
                        pedido.add(cantCerveza + "x Cerveza ("+(cantCerveza*precioCerveza)+"€).");
                    }

                    cantTotal=cantCerveza+cantVino+cantAgua+cantCoca+cantLimon+cantNaranja;
                    cantAgua = 0;
                    cantCerveza = 0;
                    cantCoca = 0;
                    cantLimon = 0;
                    cantNaranja = 0;
                    cantVino = 0;

                    cajaAgua.setText(String.valueOf(cantAgua));
                    cajaCerveza.setText(String.valueOf(cantCerveza));
                    cajaCoca.setText(String.valueOf(cantCoca));
                    cajaLimon.setText(String.valueOf(cantLimon));
                    cajaNaranja.setText(String.valueOf(cantNaranja));
                    cajaVino.setText(String.valueOf(cantVino));

                    price.setText(String.valueOf(precio));
                    pedido.add("TOTAL: " + precio + "€");

                    if (precio > 15) {
                        pedido.add("Por haber superado los 15€ en el pedido, le vamos a hacer un reagalo de un peluche.");
                    }

                    if (precio > 20) {
                        pedido.add("Ademas del peluche, por haber superado tambien los 20€, le vamos a regalar un vale para comer en el comedor de Cebanc.");
                    }

                    pedido.add("MUCHAS GRACIAS.");


                }


            }
        });


        siguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(cantTotal==0){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "No puedes pedir menos de 1 bebida.", Toast.LENGTH_SHORT);
                    toast1.show();
                }else{
                Intent intenta = new Intent(TerceraPantalla.this, PantallaResumen.class);
                intenta.putExtra("Usuarios", pedido);
                startActivity(intenta);
                finish();}

            }

        });
    }
}


