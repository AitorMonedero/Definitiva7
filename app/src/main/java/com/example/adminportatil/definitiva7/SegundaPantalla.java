/*Actividad en la que se escogeran las pizzas*/

package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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


//DECLARAMOS LAS VARIABLES QUE VAYAMOS A NECESITAR
    private Button plus,minus,volver,siguiente,añadir;
    private int cantidad=1,sumaCantidad=0;
    private double precio=0,precioTotal=0,precioTamaño=0,precioTipo=0,precioMasa=0;
    private String cantidadString,tipo,masa,tamaño,frase,precioString;
    private TextView cantidadTotal,precioStrings,prueba;
    ArrayList<String> pedido;
    private String username;
    private boolean si;
    private int codigo_pizza,lineaActual=1,codigoUsuario,codigoPedido;
    private String tipo_masa, tipo_tamaño;
    RadioGroup TipoPizzas,TamañoPizzas,TipoMasas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda_pantalla);

        lineaActual=1;
        //pedido=new ArrayList<String>();

        //HACEMOS LAS REFERENCIAS NECESARIAS
        Bundle bundle = getIntent().getExtras();
        pedido=bundle.getStringArrayList("Usuarios");
        username=bundle.getString("NombreUsuario");
        codigoUsuario=bundle.getInt("Codigo");




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


//LISTENER PARA EL BOTON DE SUMAR CANTIDAD
        plus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){

                    cantidad = cantidad + 1;
                    cantidadString = String.valueOf(cantidad);
                    cantidadTotal.setText(cantidadString);


            }
        }

        );

        //BOTON PARA AÑADIR AL CARRITO

        añadir.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){

                //VALIDACIONES DE QUE HAYA ALGO SELECCIONADO
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
                        precioTipo=3;
                        codigo_pizza=1;
                    }else if (TipoPizzas.getCheckedRadioButtonId() == R.id.btnBarbacoa){
                        tipo = "Pizza barbacoa ";
                        precioTipo=4;
                        codigo_pizza=2;
                    }else if (TipoPizzas.getCheckedRadioButtonId() == R.id.btnQuesos){
                        tipo = "Pizza 4 quesos ";
                        precioTipo=5;
                        codigo_pizza=3;
                    }else if (TipoPizzas.getCheckedRadioButtonId() == R.id.btnVegetal){
                        tipo = "Pizza vegetal ";
                        precioTipo=2;
                        codigo_pizza=4;
                    }else if (TipoPizzas.getCheckedRadioButtonId() == R.id.btnTropical){
                        tipo = "Pizza tropical ";
                        precioTipo=1;
                        codigo_pizza=5;
                    }


                    if (TipoMasas.getCheckedRadioButtonId()==R.id.btnFina){
                        masa="de masa fina";// esto es lo que sale en el resumen
                        precioMasa=2;
                        tipo_masa="Fina"; // esto es lo que se mete en la base de datos
                    }else if(TipoMasas.getCheckedRadioButtonId()==R.id.btnNormal){
                        masa="de masa normal";
                        precioMasa=3;
                        tipo_masa="Normal";
                    }


                    if (TamañoPizzas.getCheckedRadioButtonId()==R.id.btnIndividual){
                        tamaño="individual ";
                        precioTamaño=6;
                        tipo_tamaño="Individual";
                    }else if(TamañoPizzas.getCheckedRadioButtonId()==R.id.btnMediana){
                        tamaño="mediana ";
                        precioTamaño=10;
                        tipo_tamaño="Mediana";
                    }else if(TamañoPizzas.getCheckedRadioButtonId()==R.id.btnFamiliar){
                        tamaño="familiar ";
                        precioTamaño=12;
                        tipo_tamaño="Familiar";
                    }



                    sumaCantidad=sumaCantidad+cantidad;
                    precio=precioTamaño+precioTipo+precioMasa;
                    precioTotal=precioTotal+(precio*cantidad);
                    precioString=String.valueOf(precioTotal)+"€";
                    precioStrings.setText(precioString);
                    cantidadString=String.valueOf(cantidad)+"x ";
                    frase=cantidadString+tipo+tamaño+masa+" ("+(precio*cantidad)+"€).";
                    pedido.add(frase);



                    //RECOGEMOS EL METODO DE OBTENER EL CODIGO DEL CLIENTE AL QUE LE PASAMOS EL USUARIO COMO PARAMETRO
                    codigoUsuario=obtenerCodigoCliente(username);
                    //RECOGEMOS EL METODO DE OBTENER EL CODIGO DEL PEDIDO CON EL CODIGO DEL USUARIO
                    codigoPedido=obtenerCodigoPedido(codigoUsuario);
                    //lineaActual=obtenerLinea(codigoPedido);

//INSERTAMOS EN LINEAS PIZZA CON EL METODO DE INSERTAR LINEA
                    insertarLinea(codigo_pizza,tipo_tamaño,tipo_masa,username,lineaActual,cantidad,precio,codigoUsuario);
                    //prueba.setText(lineaActual);

                    lineaActual=lineaActual+1;

                    //Toast.makeText(getApplicationContext(), "Añadido con exito al carro de la compra", Toast.LENGTH_SHORT).show();
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

                //borrarSesion(codigoUsuario);
                finish();

            }
        }

        );

        siguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0){

                if(sumaCantidad==0){
                    Toast toast1 = Toast.makeText(getApplicationContext(), "El carrito está vacio.", Toast.LENGTH_SHORT);
                    toast1.show();
                }else {
                    Intent intentaar = new Intent(SegundaPantalla.this, TerceraPantalla.class);
                    intentaar.putExtra("Usuarios", pedido);
                    intentaar.putExtra("Dinero", precioTotal);
                    intentaar.putExtra("Username",username);
                    intentaar.putExtra("Codigo",codigoPedido);
                    startActivity(intentaar);
                    finish();
                }

            }
        }

        );


    }

    public void insertarLinea(int a,String b, String c,String nombre,int lineaActual,int canti,double precio,int codigo){

        int codigo2=0;

        //CREAMOS LOS OBJETOS DE LAS CLASES QUE NECESITAREMOS
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();

        Cursor cursor2 = db2.rawQuery("SELECT codigo_pedido from cabecera_pedido where codigo="+codigo+"",null);

        while(cursor2.moveToNext()){
            codigo2 = cursor2.getInt(0);
        }


        String sqlInsertPizzas="INSERT INTO Lineas_pizzas(codigo_pedido,linea_pizza,codigo_pizza,cantidad,tamanio,masa,precio) VALUES("+codigo2+","+lineaActual+","+a+",'"+canti+"','"+b+"','"+c+"',"+precio+")";
        db2.execSQL(sqlInsertPizzas);


        db2.close();
        usdbh2.close();
    }



    public int obtenerCodigoCliente(String username){

        int codigo=1;


            ActivitySQL usdbh = new ActivitySQL(this, "DBUsuarios", null, 14);

            SQLiteDatabase db = usdbh.getWritableDatabase();

            Cursor cursor = db.rawQuery("SELECT codigo_cliente FROM clientes WHERE usuario = '" + username + "'", null);

            while (cursor.moveToNext()) {
                codigo = cursor.getInt(0);
            }


            db.close();
            usdbh.close();


        return codigo;
    }



    public int obtenerCodigoPedido(int codigo){

        int codigo2=1;


        ActivitySQL usdbh = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db = usdbh.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT codigo_pedido FROM cabecera_pedido WHERE codigo = '" + codigo + "'", null);

        while (cursor.moveToNext()) {
            codigo2 = cursor.getInt(0);
        }


        db.close();
        usdbh.close();


        return codigo2;
    }



}