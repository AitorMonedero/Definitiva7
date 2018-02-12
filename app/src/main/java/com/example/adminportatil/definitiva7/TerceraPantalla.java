package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Aitor & Jon on 20/12/2017.
 */

public class TerceraPantalla extends AppCompatActivity {


    //DECLARAMOS LAS VARIABLES
    int codigo;
    ArrayList<String> arrayBebida;
    ArrayAdapter<String> adapter;
    TextView labelPrecio,labelPrecio2;
    double precioBebida;
    int bebida,cantidadTotal;
    double precioTotal;
    String precioSeleccionado,bebidaa,username,nombreBebida;


    Button siguiente, salir, mas, menos, añadir;
    TextView cant, labelNombre;
    private int linea=0;
    ListView bebidas;
    private int cantidad,codigoPedido,codigoBebida,codigoUsuario,userCode;

    ArrayList<String> pedido;

    int cantTotal;


    double precio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera_pantalla);
        //INSTANCIAMOS LAS VARIABLES
        pedido=new ArrayList<String>();

        Bundle bundle = getIntent().getExtras();
        username=bundle.getString("NombreUsuario");

        precio = bundle.getDouble("Dinero");
        pedido = bundle.getStringArrayList("Usuarios");
        codigoPedido= bundle.getInt("Codigo");



        salir = (Button) findViewById(R.id.button11);
        labelNombre = (TextView) findViewById(R.id.textView20);
        cant = (TextView) findViewById(R.id.textView19);
        mas = (Button) findViewById(R.id.mas);
        menos = (Button) findViewById(R.id.menos);
        siguiente = (Button) findViewById(R.id.button9);
        salir = (Button) findViewById(R.id.button11);
        labelPrecio=(TextView) findViewById(R.id.txtPrecio);
        labelPrecio2 = (TextView) findViewById(R.id.txtPrecio2);




        añadir = (Button) findViewById(R.id.button14);

        linea = 1;

        bebidas = (ListView) findViewById(R.id.lista);


        arrayBebida=new ArrayList<String>();
        rellenarBebidas(bebidas);


        labelPrecio2.setText(""+precio);


        bebidas.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int posicion, long id) {
                elegirBebida(posicion);
            }
        });

        mas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cantidad = cantidad + 1;
                cant.setText("" + cantidad);
            }
        });


        menos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (cantidad <= 0) {
                } else {
                    cantidad = cantidad - 1;
                    cant.setText("" + cantidad);
                }
            }
        });


        salir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                //borrarSesion(codigoUsuario);
                finish();

            }
        }

        );

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (labelNombre.getText() == "") {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debes elegir una bebida.", Toast.LENGTH_SHORT);
                    toast1.show();
                } else if (cantidad == 0) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Debes seleccionar una cantidad.", Toast.LENGTH_SHORT);
                    toast1.show();
                } else {



                    insertarLineaBebida(codigoBebida, linea, cantidad, precioBebida,codigoPedido);
                    linea = linea + 1;

                    //bebidaa = labelNombre.getText().toString().toLowerCase();

                    precioTotal = precioBebida * cantidad;
                    cantidadTotal=cantidadTotal+cantidad;

                    pedido.add(cantidad + " " + nombreBebida + ": " + precioTotal + "€");

                    precio = precio + precioTotal;

                    labelPrecio.setText("" + precioBebida);

                    labelPrecio2.setText(""+precio);

                    cantidad = 0;
                    cant.setText("" + cantidad);


                }
            }
        });

        siguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                if(cantidadTotal==0){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "El carrito no tiene bebidas.", Toast.LENGTH_SHORT);
                    toast1.show();
                }else{

                    Date c = Calendar.getInstance().getTime();


                    SimpleDateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                    String formattedDate = df.format(c);

                    ActivitySQL usdbh2 = new ActivitySQL(TerceraPantalla.this, "DBUsuarios", null, 14);

                    SQLiteDatabase db2 = usdbh2.getWritableDatabase();

                    String sqlIntroduceDatos="UPDATE cabecera_pedido SET fecha_pedido='"+formattedDate+"', precio_total="+precio+" WHERE codigo_pedido = '"+codigoPedido+"'";

                    db2.execSQL(sqlIntroduceDatos);

                    db2.close();
                    usdbh2.close();


                    pedido.add("TOTAL: " + precio + "€");

                    if (precio > 30) {
                        pedido.add("Su pedido supera los 30€! Con el pedido le llegará un peluche de Android. Disfrutelo.");
                    }

                    if (precio > 40) {
                        pedido.add("Ademas del peluche por el pedido superior a 30 euros, por haber superado tambien los 40€, le vamos a obsequiar con un vale para comer en el restaurante propio de Cebanc.");
                    }

                    pedido.add("Gracias por el pedido realizado! (^_^).");

                    //INSERTAR EN LA BASE DE DATOS

                    userCode=obtenerCodigoUsuario(codigoPedido);


                    Intent intenta = new Intent(TerceraPantalla.this, PantallaResumen.class);
                    intenta.putExtra("Usuarios", pedido);
                    intenta.putExtra("Codigo",codigoPedido);
                    intenta.putExtra("Money",precio);
                    intenta.putExtra("codigoUsuario",userCode);

                    startActivity(intenta);
                    finish();
                }

            }
        });

        }


        //METODOS PARA EL FUNCIONAMIENTO DE LAS BEBIDAS
    public void rellenarBebidas(ListView lista){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();
        Cursor cursor = db2.rawQuery("SELECT nombre FROM bebidas", null);

        while (cursor.moveToNext()) {
            arrayBebida.add(cursor.getString(0));
        }

        db2.close();
        usdbh2.close();

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrayBebida);
        bebidas.setAdapter(adapter);
    }

    public void elegirBebida(int posicion){

        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();

        Cursor cursor = db2.rawQuery("SELECT codigo_bebida,nombre,precio From Bebidas WHERE codigo_bebida = " + (posicion +1) + "",null);

        while (cursor.moveToNext()) {

            precioSeleccionado = cursor.getString(2);

            labelPrecio.setText(precioSeleccionado);

            nombreBebida = cursor.getString(1);

            labelNombre.setText(nombreBebida);

            precioBebida = Double.parseDouble(cursor.getString(2));

            bebida = posicion;

            cant.setText("0");

            codigoBebida = cursor.getInt(0);

        }

        db2.close();
        usdbh2.close();
        cantidad = Integer.parseInt(""+cant.getText());
    }

    public void insertarLineaBebida(int codigoBebida,int lineaActual,int canti,double precio,int codigo){

        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();


        String sqlInsertPizzas="INSERT INTO Lineas_bebidas(codigo_pedido,linea_bebida,codigo_bebida,cantidad,precio) VALUES("+codigo+","+lineaActual+","+codigoBebida+","+canti+","+precio+")";
        db2.execSQL(sqlInsertPizzas);


        db2.close();
        usdbh2.close();
    }

    public int obtenerCodigoUsuario(int codigo){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();

        Cursor cursor = db2.rawQuery("SELECT codigo From cabecera_pedido WHERE codigo_pedido = " + codigo + "",null);

        while (cursor.moveToNext()) {

            codigoUsuario=cursor.getInt(0);

        }

        db2.close();
        usdbh2.close();
        return codigoUsuario;
    }


}