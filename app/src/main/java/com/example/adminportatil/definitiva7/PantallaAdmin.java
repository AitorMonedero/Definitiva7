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
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class PantallaAdmin extends AppCompatActivity {

    //DECLARAMOS LAS VARIABLES QUE VAMOS A UTILIZAR
    Spinner accion,spinner1,TABLE;
    String[] actions;
    ArrayAdapter<String> adapter1;
    TextView label1,mostrarDatos,label2,mostrarPrecio;

    EditText txtAñadir,introduceEmail,introduceTelefono,introduceDireccion,cajaIntroducir,añadirPrecio;

    int accion1;
    Button btnBorrar,atras,actualizar,añadir;
    String[] tablas;
    ArrayAdapter<String> adapter2;
    ArrayList<String> array;
    ArrayAdapter<String> adapter3;
    boolean si;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_admin);

        //RECOGEMOS EN LAS VARIABLES LOS VIEWS.
        accion = (Spinner) findViewById(R.id.spinner2);
        TABLE = (Spinner) findViewById(R.id.spinner);
        spinner1 = (Spinner) findViewById(R.id.spinner3);

        label1 = (TextView) findViewById(R.id.label1);
        label2 = (TextView) findViewById(R.id.lblPrecio);
        mostrarDatos = (TextView) findViewById(R.id.label2);
        mostrarPrecio = (TextView) findViewById(R.id.lblMostrarPrecio);

        txtAñadir = (EditText) findViewById(R.id.editText);
        añadirPrecio = (EditText) findViewById(R.id.editText2);
        introduceDireccion = (EditText) findViewById (R.id.editTextDireccion);
        introduceEmail = (EditText) findViewById (R.id.editTextEmail);
        introduceTelefono = (EditText) findViewById (R.id.editTextTelefono);
        cajaIntroducir = (EditText) findViewById(R.id.editMostrar);



        añadir = (Button) findViewById(R.id.btnInsertar);
        btnBorrar = (Button) findViewById(R.id.btnBorrar);
        actualizar = (Button) findViewById(R.id.btnActualizar);
        atras=(Button) findViewById(R.id.btnAtras);

        array = new ArrayList<String>();

        //CREAMOS DOS ARRAYS PARA SIMULAR UN MENU
        actions = new String[] { "Insertar", "Borrar", "Mostrar","Actualizar"}; // LO QUE SE LE ASIGNA A ACCIONES
        tablas = new String[] { "", "Clientes", "Bebidas"}; // LO QUE SE ASIGNA A TABLA

        //ASIGNAMOS LOS ARRAYS A UNOS ADAPTADORES QUE LE ASIGNAREMOS A LOS SPINNER
        adapter1 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, actions);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        accion.setAdapter(adapter1);

        adapter2 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, tablas);
        adapter2.setDropDownViewResource(android.R.layout.simple_list_item_multiple_choice);
        TABLE.setAdapter(adapter2);

        accion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(position == 0) {//INSERTAR
                    accion1 = 1;
                   //PONEMOS TOD0 INVISIBLE PARA QUE NO MOLESTE CUANDO ESCOJAMOS OTRA OPCION Y VAMOS ACTIVANDO A MEDIDA QUE NECESITEMOS.
                    TABLE.setSelection(0);
                    txtAñadir.setVisibility(View.INVISIBLE);
                    añadirPrecio.setVisibility(View.INVISIBLE);
                    label1.setVisibility(View.INVISIBLE);
                    label2.setVisibility(View.INVISIBLE);
                    añadir.setVisibility(View.INVISIBLE);
                    spinner1.setVisibility(View.INVISIBLE);
                    mostrarDatos.setVisibility(View.INVISIBLE);
                    mostrarPrecio.setVisibility(View.INVISIBLE);
                    cajaIntroducir.setVisibility(View.INVISIBLE);
                    btnBorrar.setVisibility(View.INVISIBLE);
                    introduceDireccion.setVisibility(View.INVISIBLE);
                    introduceEmail.setVisibility(View.INVISIBLE);
                    introduceTelefono.setVisibility(View.INVISIBLE);
                    actualizar.setVisibility(View.INVISIBLE);
                }else if(position == 1){//BORRAR
                    accion1 = 2;
                    TABLE.setSelection(0);
                    txtAñadir.setVisibility(View.INVISIBLE);
                    añadirPrecio.setVisibility(View.INVISIBLE);
                    label1.setVisibility(View.INVISIBLE);
                    label2.setVisibility(View.INVISIBLE);
                    añadir.setVisibility(View.INVISIBLE);
                    spinner1.setVisibility(View.INVISIBLE);
                    mostrarDatos.setVisibility(View.INVISIBLE);
                    mostrarPrecio.setVisibility(View.INVISIBLE);
                    cajaIntroducir.setVisibility(View.INVISIBLE);
                    btnBorrar.setVisibility(View.INVISIBLE);
                    introduceDireccion.setVisibility(View.INVISIBLE);
                    introduceEmail.setVisibility(View.INVISIBLE);
                    introduceTelefono.setVisibility(View.INVISIBLE);
                    actualizar.setVisibility(View.INVISIBLE);
                }else if(position == 2){//MOSTRAR
                    accion1 = 3;
                    TABLE.setSelection(0);
                    txtAñadir.setVisibility(View.INVISIBLE);
                    añadirPrecio.setVisibility(View.INVISIBLE);
                    label1.setVisibility(View.INVISIBLE);
                    label2.setVisibility(View.INVISIBLE);
                    añadir.setVisibility(View.INVISIBLE);
                    spinner1.setVisibility(View.INVISIBLE);
                    mostrarDatos.setVisibility(View.INVISIBLE);
                    mostrarPrecio.setVisibility(View.INVISIBLE);
                    cajaIntroducir.setVisibility(View.INVISIBLE);
                    btnBorrar.setVisibility(View.INVISIBLE);
                    introduceDireccion.setVisibility(View.INVISIBLE);
                    introduceEmail.setVisibility(View.INVISIBLE);
                    introduceTelefono.setVisibility(View.INVISIBLE);
                    actualizar.setVisibility(View.INVISIBLE);
                }else if(position == 3){//ACTUALIZAR
                    accion1 = 4;
                    TABLE.setSelection(0);
                    txtAñadir.setVisibility(View.INVISIBLE);
                    añadirPrecio.setVisibility(View.INVISIBLE);
                    label1.setVisibility(View.INVISIBLE);
                    label2.setVisibility(View.INVISIBLE);
                    añadir.setVisibility(View.INVISIBLE);
                    spinner1.setVisibility(View.INVISIBLE);
                    mostrarDatos.setVisibility(View.INVISIBLE);
                    mostrarPrecio.setVisibility(View.INVISIBLE);
                    cajaIntroducir.setVisibility(View.INVISIBLE);
                    btnBorrar.setVisibility(View.INVISIBLE);
                    introduceDireccion.setVisibility(View.INVISIBLE);
                    introduceEmail.setVisibility(View.INVISIBLE);
                    introduceTelefono.setVisibility(View.INVISIBLE);
                    actualizar.setVisibility(View.INVISIBLE);
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });

        //LE PONEMOS EL LISTENER A TABLE PARA CUANDO ESCOJA OTRA OPCION
        TABLE.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                //PARA LA ACCION INSERTAR QUE HAGA LAS SIGUIENTES ORDENES
                if (position == 1 && accion1 == 1) {
                    txtAñadir.setVisibility(View.VISIBLE);
                    añadirPrecio.setVisibility(View.VISIBLE);
                    label1.setVisibility(View.VISIBLE);
                    label2.setVisibility(View.VISIBLE);
                    añadir.setVisibility(View.VISIBLE);
                    introduceDireccion.setVisibility(View.VISIBLE);
                    introduceEmail.setVisibility(View.VISIBLE);
                    introduceTelefono.setVisibility(View.VISIBLE);
                    label1.setText("Introduce un Cliente:");
                    txtAñadir.setText("");
                    label2.setText("Introduce un nombre:");
                    añadirPrecio.setText("");
                    txtAñadir.setHint("Usuario");
                    añadirPrecio.setHint("Nombre del usuario");


                    introduceTelefono.setText("");
                    introduceEmail.setText("");
                    introduceDireccion.setText("");

                } else if (position == 2 && accion1 == 1) {
                    txtAñadir.setVisibility(View.VISIBLE);
                    añadirPrecio.setVisibility(View.VISIBLE);
                    label1.setVisibility(View.VISIBLE);
                    label2.setVisibility(View.VISIBLE);
                    añadir.setVisibility(View.VISIBLE);

                    introduceDireccion.setVisibility(View.INVISIBLE);
                    introduceEmail.setVisibility(View.INVISIBLE);
                    introduceTelefono.setVisibility(View.INVISIBLE);

                    label1.setText("Introduce una bebida:");
                    txtAñadir.setText("");
                    añadirPrecio.setText("");
                    label2.setText("Introduce un precio");
                    txtAñadir.setHint("Nombre de la bebida");
                    añadirPrecio.setHint("Precio de la bebida");

                }

                //PARA LA ACCION DE BORRAR
                if (position == 1 && accion1 == 2) {
                    spinner1.setVisibility(View.VISIBLE);
                    mostrarDatos.setVisibility(View.VISIBLE);
                    mostrarPrecio.setVisibility(View.VISIBLE);
                    cajaIntroducir.setVisibility(View.VISIBLE);
                    btnBorrar.setVisibility(View.VISIBLE);
                    cajaIntroducir.setEnabled(false);
                    introduceTelefono.setEnabled(false);
                    introduceEmail.setEnabled(false);
                    introduceDireccion.setEnabled(false);
                    rellenarUsuarios();

                    btnBorrar.setText("BORRAR");
                    mostrarDatos.setText("Elige un Usuario");
                    mostrarPrecio.setText("Nombre :");

                } else if (position == 2 && accion1 == 2) {
                    spinner1.setVisibility(View.VISIBLE);
                    mostrarDatos.setVisibility(View.VISIBLE);
                    mostrarPrecio.setVisibility(View.VISIBLE);
                    cajaIntroducir.setVisibility(View.VISIBLE);
                    btnBorrar.setVisibility(View.VISIBLE);
                    cajaIntroducir.setEnabled(false);
                    rellenarBebidas();

                    mostrarDatos.setText("Elige una bebida");
                    mostrarPrecio.setText("Precio :");
                    btnBorrar.setText("BORRAR");

                }



                //PARA LA ACCION DE MOSTRAR
                if (position == 1 && accion1 == 3) {
                    spinner1.setVisibility(View.VISIBLE);
                    mostrarDatos.setVisibility(View.VISIBLE);
                    mostrarPrecio.setVisibility(View.VISIBLE);
                    cajaIntroducir.setVisibility(View.VISIBLE);

                    introduceDireccion.setVisibility(View.VISIBLE);
                    introduceEmail.setVisibility(View.VISIBLE);
                    introduceTelefono.setVisibility(View.VISIBLE);

                    cajaIntroducir.setEnabled(false);


                    rellenarUsuarios();
                    rellenarNombre(spinner1.getSelectedItem().toString());
                    rellenarDireccion(spinner1.getSelectedItem().toString());
                    rellenarEmail(spinner1.getSelectedItem().toString());
                    rellenarTelefono(spinner1.getSelectedItem().toString());

                    mostrarDatos.setText("Elige un Usuario");
                    mostrarPrecio.setText("Nombre:");

                } else if (position == 2 && accion1 == 3) {
                    spinner1.setVisibility(View.VISIBLE);
                    mostrarDatos.setVisibility(View.VISIBLE);
                    mostrarPrecio.setVisibility(View.VISIBLE);
                    cajaIntroducir.setVisibility(View.VISIBLE);
                    cajaIntroducir.setEnabled(false);
                    introduceDireccion.setVisibility(View.INVISIBLE);
                    introduceEmail.setVisibility(View.INVISIBLE);
                    introduceTelefono.setVisibility(View.INVISIBLE);
                    rellenarBebidas();

                    mostrarDatos.setText("Elige una bebida");
                    mostrarPrecio.setText("Precio:");


                }

                //PARA LA ACCION DE ACTUALIZAR
                if (position == 1 && accion1 == 4) {
                    spinner1.setVisibility(View.VISIBLE);
                    mostrarDatos.setVisibility(View.VISIBLE);
                    mostrarPrecio.setVisibility(View.VISIBLE);
                    cajaIntroducir.setVisibility(View.VISIBLE);
                    actualizar.setVisibility(View.VISIBLE);
                    introduceDireccion.setVisibility(View.VISIBLE);
                    introduceEmail.setVisibility(View.VISIBLE);
                    introduceTelefono.setVisibility(View.VISIBLE);

                    cajaIntroducir.setText("");

                    cajaIntroducir.setEnabled(true);
                    introduceDireccion.setEnabled(true);
                    introduceEmail.setEnabled(true);
                    introduceTelefono.setEnabled(true);

                    rellenarUsuarios();
                    rellenarNombre(spinner1.getSelectedItem().toString());
                    rellenarDireccion(spinner1.getSelectedItem().toString());
                    rellenarEmail(spinner1.getSelectedItem().toString());
                    rellenarTelefono(spinner1.getSelectedItem().toString());

                    mostrarDatos.setText("Elige un Usuario");
                    mostrarPrecio.setText("Nuevo nombre:");

                } else if (position == 2 && accion1 == 4) {
                    spinner1.setVisibility(View.VISIBLE);
                    mostrarDatos.setVisibility(View.VISIBLE);
                    mostrarPrecio.setVisibility(View.VISIBLE);
                    cajaIntroducir.setVisibility(View.VISIBLE);
                    actualizar.setVisibility(View.VISIBLE);
                    introduceDireccion.setVisibility(View.INVISIBLE);
                    introduceEmail.setVisibility(View.INVISIBLE);
                    introduceTelefono.setVisibility(View.INVISIBLE);
                    cajaIntroducir.setEnabled(true);
                    cajaIntroducir.setText("");
                    rellenarBebidas();

                    mostrarDatos.setText("Elige una bebida");
                    mostrarPrecio.setText("Nuevo precio:");



                }


            }
            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
            }
        });



        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                if(accion.getSelectedItem().toString()=="Borrar" && TABLE.getSelectedItem().toString()=="Clientes"){
                    rellenarNombre(spinner1.getSelectedItem().toString());
                }else if(accion.getSelectedItem().toString()=="Borrar" && TABLE.getSelectedItem().toString()=="Bebidas"){
                    rellenarPrecio(spinner1.getSelectedItem().toString());
                }else if(accion.getSelectedItem().toString()=="Mostrar" && TABLE.getSelectedItem().toString()=="Bebidas"){
                    rellenarPrecio(spinner1.getSelectedItem().toString());
                }else if(accion.getSelectedItem().toString()=="Mostrar" && TABLE.getSelectedItem().toString()=="Clientes"){
                    rellenarTodo(spinner1.getSelectedItem().toString());
                }else if(accion.getSelectedItem().toString()=="Actualizar" && TABLE.getSelectedItem().toString()=="Clientes"){
                    rellenarTodo(spinner1.getSelectedItem().toString());
                }else if(accion.getSelectedItem().toString()=="Actualizar" && TABLE.getSelectedItem().toString()=="Bebidas"){
                    rellenarPrecio(spinner1.getSelectedItem().toString());
                }



                //.setText(spinner1.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // your code here
            }

        });

//ACTIVAMOS EL LISTENER PARA EL BOTON DE AÑADIR

        añadir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //SI ESCOGE LA TABLA USUARIOS ENTRA EN ESTE IF
                if(TABLE.getSelectedItemPosition()== 1) {
                    try {


                        if (txtAñadir.getText().length() == 0) {
                            Toast toast1 = Toast.makeText(getApplicationContext(), "Tienes que introducir un usuario.", Toast.LENGTH_SHORT);
                            toast1.show();
                            txtAñadir.requestFocus();
                        }   //else if(usuario.getText().length() >15) {        }

                        else if (añadirPrecio.getText().length() == 0) {
                            Toast toast2 = Toast.makeText(getApplicationContext(), "Tienes que introducir un nombre.", Toast.LENGTH_SHORT);
                            toast2.show();
                            añadirPrecio.requestFocus();
                        } else if (introduceTelefono.getText().length() == 0) {
                            Toast toast3 = Toast.makeText(getApplicationContext(), "Tienes que introducir un telefono.", Toast.LENGTH_SHORT);
                            toast3.show();
                            introduceTelefono.requestFocus();
                        } else if (introduceTelefono.getText().length() != 9) {
                            Toast toast3 = Toast.makeText(getApplicationContext(), "El telefono debe ser de 9 digitos.", Toast.LENGTH_SHORT);
                            toast3.show();
                            introduceTelefono.requestFocus();
                        } else if (introduceDireccion.getText().length() == 0) {
                            Toast toast4 = Toast.makeText(getApplicationContext(), "Tienes que introducir una direccion.", Toast.LENGTH_SHORT);
                            toast4.show();
                            introduceDireccion.requestFocus();
                        } else if (emailValidator(introduceEmail.getText().toString()) == false) {
                            Toast toast6 = Toast.makeText(getApplicationContext(), "Email no válido.", Toast.LENGTH_SHORT);
                            toast6.show();
                            introduceEmail.requestFocus();
                        }else{

                            if(encontrar(txtAñadir.getText().toString())==false) {
                                añadirCliente(txtAñadir.getText().toString(), añadirPrecio.getText().toString(), introduceDireccion.getText().toString(), introduceEmail.getText().toString(), Integer.parseInt(introduceTelefono.getText().toString()));
                                txtAñadir.setText("");
                                añadirPrecio.setText("");
                                introduceEmail.setText("");
                                introduceDireccion.setText("");
                                introduceTelefono.setText("");
                                Toast toast1 = Toast.makeText(getApplicationContext(), "El cliente se ha introducido correctamente.", Toast.LENGTH_SHORT);
                                toast1.show();
                            }else{
                                txtAñadir.setError("Usuario ya introducido");
                                    Toast toast1 = Toast.makeText(getApplicationContext(), "Usuario repetido.", Toast.LENGTH_SHORT);
                                    toast1.show();
                                }
                        }
                    } catch (Exception e) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Error al insertar el cliente.", Toast.LENGTH_SHORT);
                        toast1.show();
                    }

                    //SI ESCOGE BEBIDAS ENTRA EN ESTE OTRO
                }else if(TABLE.getSelectedItemPosition()== 2) {
                    try {
                        añadirBebida(txtAñadir.getText().toString(), Double.parseDouble(añadirPrecio.getText().toString()));
                        txtAñadir.setText("");
                        añadirPrecio.setText("");
                        Toast toast1 = Toast.makeText(getApplicationContext(), "La bebida se ha introducido correctamente.", Toast.LENGTH_SHORT);
                        toast1.show();
                    } catch (Exception e) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Error al insertar la bebida.", Toast.LENGTH_SHORT);
                        toast1.show();

                    }
                }

            }
        });

//EL LISTENER PARA EL BOTON DE BORRAR
        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(TABLE.getSelectedItemPosition()== 1) {
                    try {
                        borrarCliente(spinner1.getSelectedItem().toString());
                        Toast toast1 = Toast.makeText(getApplicationContext(), "El cliente se ha borrado correctamente.", Toast.LENGTH_SHORT);
                        toast1.show();
                    } catch (Exception e) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Error al borrar el cliente.", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                }else if(TABLE.getSelectedItemPosition()== 2) {
                    try {
                        borrarBebida(spinner1.getSelectedItem().toString());
                        Toast toast1 = Toast.makeText(getApplicationContext(), "La bebida se ha eliminado correctamente.", Toast.LENGTH_SHORT);
                        toast1.show();
                    } catch (Exception e) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Error al insertar la bebida.", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                }

            }
        });

//LISTENER PARA EL BOTON DE ACTUALIZAR
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TABLE.getSelectedItemPosition()== 1) {
                    try {
                        if (cajaIntroducir.getText().length() == 0) {
                            Toast toast2 = Toast.makeText(getApplicationContext(), "Tienes que introducir un nombre.", Toast.LENGTH_SHORT);
                            toast2.show();
                            cajaIntroducir.requestFocus();
                        } else if (introduceTelefono.getText().length() == 0) {
                            Toast toast3 = Toast.makeText(getApplicationContext(), "Tienes que introducir un telefono.", Toast.LENGTH_SHORT);
                            toast3.show();
                            introduceTelefono.requestFocus();
                        } else if (introduceTelefono.getText().length() != 9) {
                            Toast toast3 = Toast.makeText(getApplicationContext(), "El telefono debe ser de 9 digitos.", Toast.LENGTH_SHORT);
                            toast3.show();
                            introduceTelefono.requestFocus();
                        } else if (introduceDireccion.getText().length() == 0) {
                            Toast toast4 = Toast.makeText(getApplicationContext(), "Tienes que introducir una direccion.", Toast.LENGTH_SHORT);
                            toast4.show();
                            introduceDireccion.requestFocus();
                        } else if (emailValidator(introduceEmail.getText().toString()) == false) {
                            Toast toast6 = Toast.makeText(getApplicationContext(), "Email no válido.", Toast.LENGTH_SHORT);
                            toast6.show();
                            introduceEmail.requestFocus();
                        }else{


                                actualizarCliente(spinner1.getSelectedItem().toString(), cajaIntroducir.getText().toString(), introduceDireccion.getText().toString(), introduceEmail.getText().toString(), Integer.parseInt(introduceTelefono.getText().toString()));
                                txtAñadir.setText("");
                                añadirPrecio.setText("");
                                introduceEmail.setText("");
                                introduceDireccion.setText("");
                                introduceTelefono.setText("");
                                Toast toast1 = Toast.makeText(getApplicationContext(), "El cliente se ha actualizado correctamente.", Toast.LENGTH_SHORT);
                                toast1.show();
                            }

                    } catch (Exception e) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Error al actualizar el cliente.", Toast.LENGTH_SHORT);
                        toast1.show();
                    }

                }else if(TABLE.getSelectedItemPosition()== 2) {
                    try {
                        actualizarBebida(spinner1.getSelectedItem().toString(),Double.parseDouble(cajaIntroducir.getText().toString()));
                        Toast toast1 = Toast.makeText(getApplicationContext(), "La bebida se ha actualizado correctamente.", Toast.LENGTH_SHORT);
                        toast1.show();
                    } catch (Exception e) {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "Error al insertar la bebida.", Toast.LENGTH_SHORT);
                        toast1.show();
                    }
                }

            }
        });



        atras.setOnClickListener(new View.OnClickListener() {
                                         public void onClick(View arg0){
             Intent intentaar = new Intent(PantallaAdmin.this, PantallaCero.class);

             startActivity(intentaar);
             finish();

             }
                                     }

        );

    }




















    //METODOS DE AQUI PARA ABAJO



    //BEBIDA
    public void rellenarBebidas(){

        array.clear();
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();
        Cursor cursor = db2.rawQuery("SELECT nombre FROM BEBIDAS", null);

        while (cursor.moveToNext()) {
            array.add(cursor.getString(0));
        }

        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, array);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter3);

        db2.close();
        usdbh2.close();

    }

    public void rellenarPrecio(String nombre){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();
        Cursor cursor = db2.rawQuery("SELECT precio FROM Bebidas where nombre='"+nombre+"'", null);

        while (cursor.moveToNext()) {
            cajaIntroducir.setText(cursor.getString(0));
        }

        db2.close();
        usdbh2.close();
    }

    public void añadirBebida(String bebida, Double precio){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();

        String insert = "INSERT INTO BEBIDAS (nombre,precio) VALUES('"+bebida+"',"+precio+")";
        db2.execSQL(insert);
        db2.close();
        usdbh2.close();
    }

    public void borrarBebida(String nombre){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();

        String delete = "DELETE FROM BEBIDAS WHERE nombre='"+nombre+"'";
        db2.execSQL(delete);
        db2.close();
        usdbh2.close();
    }

    public void actualizarBebida (String nombre,double precio){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();

        String update = "UPDATE BEBIDAS SET PRECIO = "+precio+" WHERE nombre='"+nombre+"'";

        db2.execSQL(update);
        db2.close();
        usdbh2.close();
    }







    //USUARIO
    public void rellenarUsuarios(){
        array.clear();
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();
        Cursor cursor = db2.rawQuery("SELECT usuario FROM clientes", null);

        while (cursor.moveToNext()) {
            array.add(cursor.getString(0));
        }

        adapter3 = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, array);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(adapter3);
        db2.close();
        usdbh2.close();

    }

    public void rellenarTodo(String clave){
        rellenarNombre(clave);
        rellenarDireccion(clave);
        rellenarEmail(clave);
        rellenarTelefono(clave);
    }

    public void rellenarNombre(String nombre){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();
        Cursor cursor = db2.rawQuery("SELECT nombre FROM clientes where usuario='"+nombre+"'", null);

        while (cursor.moveToNext()) {
            cajaIntroducir.setText(cursor.getString(0));
        }
        db2.close();
        usdbh2.close();
    }

    public void rellenarEmail(String clave){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();
        Cursor cursor = db2.rawQuery("SELECT email FROM clientes where usuario='"+clave+"'", null);

        while (cursor.moveToNext()) {
            introduceEmail.setText(cursor.getString(0));
        }
        db2.close();
        usdbh2.close();
    }

    public void rellenarTelefono(String clave){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();
        Cursor cursor = db2.rawQuery("SELECT telefono FROM clientes where usuario='"+clave+"'", null);

        while (cursor.moveToNext()) {
            introduceTelefono.setText(cursor.getString(0));
        }
        db2.close();
        usdbh2.close();
    }

    public void rellenarDireccion(String clave){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();
        Cursor cursor = db2.rawQuery("SELECT direccion FROM clientes where usuario='"+clave+"'", null);

        while (cursor.moveToNext()) {
            introduceDireccion.setText(cursor.getString(0));
        }
        db2.close();
        usdbh2.close();
    }

    public void borrarCliente(String clave){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();

        String delete = "DELETE FROM CLIENTES WHERE usuario = '"+clave+"'";
        db2.execSQL(delete);
        db2.close();
        usdbh2.close();
    }

    public void añadirCliente(String usuario, String nombre,String direccion,String email, int telefono){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();



            String insert = "INSERT INTO CLIENTES (nombre,direccion,telefono,email,usuario) VALUES('" + nombre + "','" + direccion + "'," + telefono + ",'" + email + "','" + usuario + "')";
            db2.execSQL(insert);

        db2.close();
        usdbh2.close();
    }

    public void actualizarCliente (String usuario, String nombre,String direccion,String email, int telefono){
        ActivitySQL usdbh2 = new ActivitySQL(this, "DBUsuarios", null, 14);

        SQLiteDatabase db2 = usdbh2.getWritableDatabase();

        String update = "UPDATE CLIENTES SET nombre = '"+nombre+"', direccion='"+direccion+"', email='"+email+"',telefono="+telefono+" WHERE usuario='"+usuario+"'";

        db2.execSQL(update);
        db2.close();
        usdbh2.close();
    }



    //METODOS APARTE
    public boolean emailValidator(String correo){
        Pattern pattern;
        Matcher matcher;
        final String EMAIL_PATTERN = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(correo);
        return matcher.matches();
    }


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

}
