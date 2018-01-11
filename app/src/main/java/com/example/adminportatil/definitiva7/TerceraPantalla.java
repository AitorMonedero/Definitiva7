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
    TextView txtCocaCola, txtNestea, txtKas, txtAgua, txtRedBull, txtCerveza, price;
    Button masCocaCola, masNestea, masKas, masRedbull, masCerveza, masAgua, menosCola, menosAgua, menosKas, menosNestea, menosRedBull, menosCerveza;


    ArrayList<String> pedido;

    int cantCoca,
            cantTotal,
            cantNestea,
            cantKas,
            cantRedBull,
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


        //Todos lo relacionado con la Coca-Cola
        txtCocaCola = (TextView) findViewById(R.id.textView19);
        cantCoca = Integer.parseInt(txtCocaCola.getText().toString());
        masCocaCola = (Button) findViewById(R.id.masCoca);
        menosCola = (Button) findViewById(R.id.menoCoca);


        //Todos lo relacionado con el Nestea
        txtNestea = (TextView) findViewById(R.id.textView23);
        cantNestea = Integer.parseInt(txtNestea.getText().toString());
        masNestea = (Button) findViewById(R.id.masNaranja);
        menosNestea = (Button) findViewById(R.id.menosNaranja);


        //Todos lo relacionado con el Kas
        txtKas = (TextView) findViewById(R.id.textView16);
        cantKas = Integer.parseInt(txtKas.getText().toString());
        masKas = (Button) findViewById(R.id.masLimon);
        menosKas = (Button) findViewById(R.id.menosLimon);


        //Todos lo relacionado con el Agua
        txtAgua = (TextView) findViewById(R.id.textView22);
        cantAgua = Integer.parseInt(txtAgua.getText().toString());
        masAgua = (Button) findViewById(R.id.masAgua);
        menosAgua = (Button) findViewById(R.id.menosAgua);


        //Todos lo relacionado con el RedBull
        txtRedBull = (TextView) findViewById(R.id.textView20);
        cantRedBull = Integer.parseInt(txtRedBull.getText().toString());
        masRedbull = (Button) findViewById(R.id.masRedbull);
        menosRedBull = (Button) findViewById(R.id.menosRedBull);


        //Todos lo relacionado con la Cerveza
        txtCerveza = (TextView) findViewById(R.id.textView21);
        cantCerveza = Integer.parseInt(txtCerveza.getText().toString());
        masCerveza = (Button) findViewById(R.id.masCerveza);
        menosCerveza = (Button) findViewById(R.id.menosCerveza);

        //Todos lo relacionado con los botones
        siguiente = (Button) findViewById(R.id.button9);
        salir = (Button) findViewById(R.id.button11);
        carrito = (Button) findViewById(R.id.btnCompra);

        //Todos lo relacionado con el precio
        price = (TextView) findViewById(R.id.txtPrecio);
        price.setText(String.valueOf(precio));

        menosCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantCoca != 0) {
                    cantCoca = cantCoca - 1;
                    txtCocaCola.setText("" + cantCoca);
                    precio = precio - precioCoca;
                }
            }
        });
        masCocaCola.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantCoca = cantCoca + 1;
                txtCocaCola.setText("" + cantCoca);
                precio = precio + precioCoca;
            }
        });


        menosNestea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantNestea != 0) {
                    cantNestea = cantNestea - 1;
                    txtNestea.setText("" + cantNestea);
                    precio = precio - precioNestea;
                }
            }
        });
        masNestea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantNestea = cantNestea + 1;
                txtNestea.setText("" + cantNestea);
                precio = precio + precioNestea;
            }
        });


        menosKas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantKas == 0) {
                } else {
                    cantKas = cantKas - 1;
                    txtKas.setText("" + cantKas);
                    precio = precio - precioKas;
                }
            }
        });
        masKas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantKas = cantKas + 1;
                txtKas.setText("" + cantKas);
                precio = precio + precioKas;
            }
        });

        menosAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantAgua == 0) {
                } else {
                    cantAgua = cantAgua - 1;
                    txtAgua.setText("" + cantAgua);
                    precio = precio - precioAgua;
                }
            }
        });
        masAgua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantAgua = cantAgua + 1;
                txtAgua.setText("" + cantAgua);
                precio = precio + precioAgua;
            }
        });

        menosRedBull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantRedBull == 0) {
                } else {
                    cantRedBull = cantRedBull - 1;
                    txtRedBull.setText("" + cantRedBull);
                    precio = precio - precioRedBull;
                }
            }
        });
        masRedbull.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantRedBull = cantRedBull + 1;
                txtRedBull.setText("" + cantRedBull);
                precio = precio + precioRedBull;
            }
        });

        menosCerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantCerveza == 0) {
                } else {
                    cantCerveza = cantCerveza - 1;
                    txtCerveza.setText("" + cantCerveza);
                    precio = precio - precioCerveza;
                }
            }
        });
        masCerveza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantCerveza = cantCerveza + 1;
                txtCerveza.setText("" + cantCerveza);
                precio = precio + precioCerveza;
            }
        });



        carrito.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (cantCerveza == 0 && cantRedBull == 0 && cantAgua == 0 && cantKas == 0 && cantNestea == 0 && cantCoca == 0) {
                    Toast.makeText(getApplicationContext(), "Tienes que seleccionar por lo menos una bebida.", Toast.LENGTH_SHORT).show();
                } else {

                    if (cantCoca > 0) {
                        pedido.add(cantCoca + "x Coca Cola ("+(cantCoca*precioCoca)+"€).");
                    }
                    if (cantNestea > 0) {
                        pedido.add(cantNestea + "x Fanta Naranja ("+(cantNestea *precioNestea)+"€).");
                    }
                    if (cantKas > 0) {
                        pedido.add(cantKas + "x Fanta Limon ("+(cantKas *precioKas)+"€).");
                    }
                    if (cantAgua > 0) {
                        pedido.add(cantAgua + "x Agua ("+(cantAgua*precioAgua)+"€).");
                    }
                    if (cantRedBull > 0) {
                        pedido.add(cantRedBull + "x Vino ("+(cantRedBull *precioRedBull)+"€).");
                    }
                    if (cantCerveza > 0) {
                        pedido.add(cantCerveza + "x Cerveza ("+(cantCerveza *precioCerveza)+"€).");
                    }

                    cantTotal= cantCerveza + cantRedBull +cantAgua+cantCoca+ cantKas + cantNestea;
                    cantAgua = 0;
                    cantCerveza = 0;
                    cantCoca = 0;
                    cantKas = 0;
                    cantNestea = 0;
                    cantRedBull = 0;

                    txtAgua.setText(String.valueOf(cantAgua));
                    txtCerveza.setText(String.valueOf(cantCerveza));
                    txtCocaCola.setText(String.valueOf(cantCoca));
                    txtKas.setText(String.valueOf(cantKas));
                    txtNestea.setText(String.valueOf(cantNestea));
                    txtRedBull.setText(String.valueOf(cantRedBull));

                    price.setText(String.valueOf(precio));
                    pedido.add("TOTAL: " + precio + "€");

                    if (precio > 30) {
                        pedido.add("Su pedido supera los 30€! Con el pedido le llegará un peluche de Android. Disfrutelo.");
                    }

                    if (precio > 40) {
                        pedido.add("Ademas del peluche por el pedido superior a 30 euros, por haber superado tambien los 40€, le vamos a obsequiar con un vale para comer en el restaurante propio de Cebanc.");
                    }

                    pedido.add("Gracias por el pedido realizado! (^_^).");
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
                    finish();
                }

            }

        });

        salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentaa=new Intent(TerceraPantalla.this,PantallaCero.class);
                startActivity(intentaa);
                finish();
            }
        });
    }
}


