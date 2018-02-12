package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
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

    //DECLARAMOS LAS VARIABLES QUE VAMOS A UTILIZAR MAS ADELANTE
    private Button siguiente,salir,buscar,administrar;
    private EditText nombre,usuario,telefono,direccion,email;
    String nombre1, usuario1,direccion1,telefono1,email1;
    int numPedido,numtelefono,codigo;
    private boolean si;

    ArrayList<String> pedido;


//NOTA: LA CASILLA PARA INTRODUCIR EL TELEFONO ES DE TIPO NUMBER Y NO DE TIPO PHONE PORQUE PHONE PERMITE LA INTRODUCCION DE COMAS, ESPACIOS Y PUNTOS.

    @Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cero_pantalla);

        //CREAMOS LAS REFERENCIAS PARA NO TENER QUE ESTAR BUSCANDO TOD0 EL RATO LAS VISTAS
        pedido = new ArrayList<String>();


        siguiente = (Button) findViewById(R.id.BotonSig);
        nombre = (EditText) findViewById(R.id.editText);
        usuario = (EditText) findViewById(R.id.editText2);
        direccion = (EditText) findViewById(R.id.editText4);
        email = (EditText) findViewById(R.id.editText5);
        telefono = (EditText) findViewById(R.id.editText3);

        buscar = (Button) findViewById(R.id.buscar_cliente);
        administrar = (Button) findViewById(R.id.btnMantenimiento);

        //INHABILITAMOS LOS BOTONES
        nombre.setEnabled(false);
        direccion.setEnabled(false);
        telefono.setEnabled(false);
        email.setEnabled(false);
        usuario.requestFocus();

        siguiente.setEnabled(false);

        //LISTENER PARA EL BOTON DE BUSCAR
        buscar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {


                //SI EL METODO ENCONTRAR DEVUELVE TRUE ENTRA DENTRO
                if(encontrar(usuario.getText().toString())==true){

                    //CREAMOS EL OBJETO DE LA CLASE ACTIVITYSQL
                    ActivitySQL usdbh = new ActivitySQL(PantallaCero.this, "DBUsuarios", null, 14);

                    //CREAMOS EL OBJETO DE LA CLASE SLQITEDATABASE
                    final SQLiteDatabase db = usdbh.getWritableDatabase();

                    //nombre VARCHAR(15), direccion VARCHAR(30), telefono VARCHAR(9),email VARCHAR(50)
                    Cursor cursor = db.rawQuery("SELECT nombre,direccion,telefono,email,codigo_cliente from Clientes Where usuario = '"+usuario.getText().toString()+"'",null);


                    //MIENTRAS EL CURSOR ENCUENTRE ALGO SEGUIRÁ AVANZANDO
                    while(cursor.moveToNext()){
                        nombre.setText(cursor.getString(0));
                        direccion.setText(cursor.getString(1));
                        telefono.setText(cursor.getString(2));
                        email.setText(cursor.getString(3));
                        codigo=cursor.getInt(4);
                    }

                    db.close();

                    //INHABILITA LOS CAMPOS PARA NO EDITAR LOS DATOS
                    nombre.setEnabled(false);
                    direccion.setEnabled(false);
                    telefono.setEnabled(false);
                    email.setEnabled(false);
                    siguiente.setEnabled(true);

                    Toast toast1 = Toast.makeText(getApplicationContext(), "Bienvenido.", Toast.LENGTH_SHORT);
                    toast1.show();




                }else{

                    //SI NO ENCUENTRA NADA, SE VUELVE A HABILITAR LOS CAMPOS PARA QUE ESCRIBA EL USUARIO Y SUS DATOS
                    nombre.setEnabled(true);
                    direccion.setEnabled(true);
                    telefono.setEnabled(true);
                    email.setEnabled(true);


                    Toast toast1 = Toast.makeText(getApplicationContext(), "No se ha encontrado al usuario introducido.", Toast.LENGTH_SHORT);
                    toast1.show();
                    siguiente.setEnabled(true);

                }
            }
        }
        );

        //ESCUCHADOR PARA EL BOTON SIGUIENTE
        siguiente.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {

                //VALIDACIONES
                if (usuario.getText().length() == 0) {
                    Toast toast1 = Toast.makeText(getApplicationContext(), "Tienes que introducir un usuario.", Toast.LENGTH_SHORT);
                    toast1.show();
                    usuario.requestFocus();
                }   //else if(usuario.getText().length() >15) {        }

                else if (nombre.getText().length() == 0) {
                    Toast toast2 = Toast.makeText(getApplicationContext(), "Tienes que introducir un nombre.", Toast.LENGTH_SHORT);
                    toast2.show();
                    nombre.requestFocus();
                } else if (telefono.getText().length() == 0) {
                    Toast toast3 = Toast.makeText(getApplicationContext(), "Tienes que introducir un telefono.", Toast.LENGTH_SHORT);
                    toast3.show();
                    telefono.requestFocus();
                } else if (telefono.getText().length() != 9) {
                    Toast toast3 = Toast.makeText(getApplicationContext(), "El telefono debe ser de 9 digitos.", Toast.LENGTH_SHORT);
                    toast3.show();
                    telefono.requestFocus();
                } else if (direccion.getText().length() == 0) {
                    Toast toast4 = Toast.makeText(getApplicationContext(), "Tienes que introducir una direccion.", Toast.LENGTH_SHORT);
                    toast4.show();
                    direccion.requestFocus();
                } else if (emailValidator(email.getText().toString()) == false) {
                    Toast toast6 = Toast.makeText(getApplicationContext(), "Email no válido.", Toast.LENGTH_SHORT);
                    toast6.show();
                    email.requestFocus();
                } else {

                    nombre1 = nombre.getText().toString();
                    usuario1 = usuario.getText().toString();
                    telefono1 = telefono.getText().toString();
                    direccion1 = direccion.getText().toString();
                    email1 = email.getText().toString();
                    numPedido = (int) (Math.random() * 350) + 1;
                    numtelefono=Integer.parseInt(telefono1);

                    //SI NO ENCUENTRA NINGUN USUAIO CON ESE NOMBRE DE USUARIO, LO INSERTA
                    if(encontrar(usuario.getText().toString())==false){
                        insertarCliente(nombre1,direccion1,numtelefono,email1,usuario1);
                    }


                    pedido.add("USUARIO: "+usuario1 + " \n \n" + nombre1 + " " + " \n \nDirección: " + direccion1 + "  \n \nTelefono: " + telefono1 + "  \n \nE-mail: " + email1 + " " + " \n \nPedido #" + numPedido + ".");
                    Intent inten = new Intent(PantallaCero.this, SegundaPantalla.class);

                    //CON LOS PUTEXTRA PASAMOS A LA SIGUIENTE ACTIVIDAD LOS DATOS DESEADOS
                    inten.putExtra("Usuarios", pedido);
                    inten.putExtra("NombreUsuario",usuario1);
                    inten.putExtra("Codigo",codigo);

                    insertarAlbaranes(usuario1);

                    startActivity(inten);
                    finish();
                }

            }
        }

        );

        //BOTON DE SALIR
        salir = (Button) findViewById(R.id.BotonFin);

        salir.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View arg0) {
                                         finish();
                                     }

                                 }

        );


        //BOTON DE ADMINISTRAR PARA ENTRAR
        administrar.setOnClickListener(new View.OnClickListener() {
                                     public void onClick(View arg0) {
                                         Intent inten = new Intent(PantallaCero.this, PantallaAdmin.class);
                                         startActivity(inten);
                                         finish();
                                     }

                                 }

        );


        //SI EDITA EL CAMPO DE USUARIO
        usuario.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(!s.equals("")){
                    nombre.setEnabled(true);
                    direccion.setEnabled(true);
                    telefono.setEnabled(true);
                    email.setEnabled(true);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    //VALIDADOR DE EMAIL
    public boolean emailValidator(String correo){
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(correo);
        return matcher.matches();
    }

    //METODO PARA ENCONTRAR SI EL USUARIO EXISTE
    public boolean encontrar(String nombre){

        si=false;

        ActivitySQL usdbh = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db = usdbh.getWritableDatabase();

        Cursor cursor = db.rawQuery("SELECT * from Clientes Where usuario = '"+nombre+"'",null);

        while(cursor.moveToNext()){
            si=true;
        }

        db.close();
        usdbh.close();

        return si;


    }
    //INSERTAR EN ALBARANES
    public void insertarAlbaranes(String nombre){

        int codigo=0;

        ActivitySQL usdbh = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db = usdbh.getWritableDatabase();

        //String sqlCreateArticulos = "CREATE TABLE Lineas_pizzas (codigo_pedido INTEGER, linea_pizza INTEGER, codigo_pizza INTEGER, cantidad INTEGER, tamanio VARCHAR(10),masa VARCHAR(15),precio FLOAT, PRIMARY KEY (linea_pizza), FOREIGN KEY(codigo_pedido) REFERENCES Cabecera_pedido(codigo_pedido), FOREIGN KEY(codigo_pizza) REFERENCES Pizzas(Codigo_pizza),FOREIGN KEY(tamanio) REFERENCES Tamaños(tamaño),FOREIGN KEY(masa) REFERENCES Masas(tipo_masa))";
        //String sqlCreateDrink = "CREATE TABLE Lineas_bebidas (codigo_pedido INTEGER, linea_bebida INTEGER, codigo_bebida INTEGER, cantidad INTEGER, precio FLOAT, PRIMARY KEY (linea_bebida), FOREIGN KEY(codigo_pedido) REFERENCES Cabecera_pedido(codigo_pedido), FOREIGN KEY(codigo_bebida) REFERENCES Bebidas(codigo_bebida))";
        //String sqlCreatePedidos = "CREATE TABLE Cabecera_pedido (codigo_pedido INTEGER PRIMARY KEY AUTOINCREMENT, codigo_cliente INTEGER,fecha_pedido DATE, precio_total INTEGER, FOREIGN KEY(codigo_cliente) REFERENCES Clientes(codigo_cliente))";
        //String sqlCreateClientes = "CREATE TABLE Clientes (codigo_cliente INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(15), direccion VARCHAR(30), telefono VARCHAR(9),email VARCHAR(50),usuario VARCHAR(15))";


        Cursor cursor = db.rawQuery("SELECT codigo_cliente from Clientes where usuario='"+usuario.getText().toString()+"'",null);

        while(cursor.moveToNext()){
            codigo = cursor.getInt(0);
        }

        db.close();
        usdbh.close();



        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);
        SQLiteDatabase db2 = usdbh2.getWritableDatabase();

        String sqlInsertInto ="INSERT INTO cabecera_pedido(codigo) VALUES("+codigo+")";
        db2.execSQL(sqlInsertInto);

        db2.close();
        usdbh2.close();

    }

    //METODO PARA INSERTAR CLIENTE NUEVO
    public void insertarCliente(String nombre,String direccion,int telefono,String email,String usuario){
        ActivitySQL usdbh = new ActivitySQL(this, "DBUsuarios", null, 14);

        final SQLiteDatabase db = usdbh.getWritableDatabase();

        //(codigo_cliente,nombre,direccion,telefono,email,usuario)
        String comando="INSERT INTO Clientes (nombre,direccion,telefono,email,usuario) VALUES('" + nombre + "','" + direccion + "'," + telefono + ",'" + email + "','"+usuario+"')";

        db.execSQL(comando);

        Toast toast7 = Toast.makeText(getApplicationContext(), "Es tu primera vez, te hemos registrado.", Toast.LENGTH_SHORT);
        toast7.show();

        db.close();
        usdbh.close();
    }



}



