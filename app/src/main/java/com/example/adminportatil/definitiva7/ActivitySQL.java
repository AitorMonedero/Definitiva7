package com.example.adminportatil.definitiva7;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by jondepedromorales on 7/2/18.
 */

public class ActivitySQL extends SQLiteOpenHelper{

    //CREAMOS LAS TABLAS
    String sqlCreateClientes = "CREATE TABLE Clientes (codigo_cliente INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(15), direccion VARCHAR(30), telefono VARCHAR(9),email VARCHAR(50),usuario VARCHAR(15))";
    String sqlCreatePizzas = "CREATE TABLE Pizzas (codigo_pizza INTEGER PRIMARY KEY AUTOINCREMENT, nombre VARCHAR(15), precio FLOAT)";
    String sqlCreateTamaños = "CREATE TABLE Tamaños (tamaño VARCHAR(10) , precio FLOAT, PRIMARY KEY (tamaño))";
    String sqlCreateMasa = "CREATE TABLE Masas (tipo_masa VARCHAR(10) , precio FLOAT, PRIMARY KEY (tipo_masa))";
    String sqlCreateBebidas = "CREATE TABLE Bebidas (codigo_bebida INTEGER , nombre VARCHAR(20) ,precio FLOAT, PRIMARY KEY (codigo_bebida))";



    String sqlCreateArticulos = "CREATE TABLE Lineas_pizzas (codigo_pedido INTEGER, linea_pizza INTEGER, codigo_pizza INTEGER, cantidad INTEGER, tamanio VARCHAR(10),masa VARCHAR(15),precio FLOAT, FOREIGN KEY(codigo_pedido) REFERENCES Cabecera_pedido(codigo_pedido), FOREIGN KEY(codigo_pizza) REFERENCES Pizzas(Codigo_pizza),FOREIGN KEY(tamanio) REFERENCES Tamaños(tamaño),FOREIGN KEY(masa) REFERENCES Masas(tipo_masa))";
    String sqlCreateDrink = "CREATE TABLE Lineas_bebidas (codigo_pedido INTEGER, linea_bebida INTEGER, codigo_bebida INTEGER, cantidad INTEGER, precio FLOAT, FOREIGN KEY(codigo_pedido) REFERENCES Cabecera_pedido(codigo_pedido), FOREIGN KEY(codigo_bebida) REFERENCES Bebidas(codigo_bebida))";
    String sqlCreatePedidos = "CREATE TABLE Cabecera_pedido (codigo_pedido INTEGER PRIMARY KEY AUTOINCREMENT, codigo INTEGER,fecha_pedido DATE, precio_total INTEGER, FOREIGN KEY(codigo) REFERENCES Clientes(codigo_cliente))";


    //STRINGS PARA INSERTAR LAS PIZZAS
    String sqlInsertPizzasCarbonara="INSERT INTO Pizzas(nombre,precio) VALUES('Carbonara',3)";
    String sqlInsertPizzasBarbacoa="INSERT INTO Pizzas(nombre,precio) VALUES('Barbacoa',4)";
    String sqlInsertPizzas4quesos="INSERT INTO Pizzas(nombre,precio) VALUES('4 Quesos',5)";
    String sqlInsertPizzasVegetal="INSERT INTO Pizzas(nombre,precio) VALUES('Vegetal',2)";
    String sqlInsertPizzasTropical="INSERT INTO Pizzas(nombre,precio) VALUES('Tropical',1)";






    public ActivitySQL(Context contexto, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(contexto, nombre, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {

        ///CREAR TABLAS
        db.execSQL(sqlCreateClientes);
        db.execSQL(sqlCreatePizzas);
        db.execSQL(sqlCreateTamaños);
        db.execSQL(sqlCreateMasa);
        db.execSQL(sqlCreateBebidas);

        db.execSQL(sqlCreateArticulos);
        db.execSQL(sqlCreateDrink);
        db.execSQL(sqlCreatePedidos);

        //INSERTAR PIZZAS
        db.execSQL(sqlInsertPizzasCarbonara);
        db.execSQL(sqlInsertPizzasBarbacoa);
        db.execSQL(sqlInsertPizzas4quesos);
        db.execSQL(sqlInsertPizzasVegetal);
        db.execSQL(sqlInsertPizzasTropical);

        //INSERTAR BEBIDAS
        db.execSQL("INSERT INTO Bebidas(nombre,precio) VALUES('Coca-Cola',1.5)");
        db.execSQL("INSERT INTO Bebidas(nombre,precio) VALUES('Nestea',1.5)");
        db.execSQL("INSERT INTO Bebidas(nombre,precio) VALUES('Kas Limon',1.5)");
        db.execSQL("INSERT INTO Bebidas(nombre,precio) VALUES('Agua',1)");
        db.execSQL("INSERT INTO Bebidas(nombre,precio) VALUES('RedBull',2)");
        db.execSQL("INSERT INTO Bebidas(nombre,precio) VALUES('Cerveza',2)");

        //INSERTAR TAMAÑOS
        db.execSQL("INSERT INTO Tamaños(tamaño,precio) VALUES('Individual',6)");
        db.execSQL("INSERT INTO Tamaños(tamaño,precio) VALUES('Mediana',10)");
        db.execSQL("INSERT INTO Tamaños(tamaño,precio) VALUES('Familiar',12)");

        //INSERTAR TIPOS
        db.execSQL("INSERT INTO Masas(tipo_masa,precio) VALUES('Fina',2)");
        db.execSQL("INSERT INTO Masas(tipo_masa,precio) VALUES('Normal',3)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior,
                          int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente
        //      la opción de eliminar la TABLE anterior y crearla de nuevo
        //      vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la
        //      TABLE antigua a la nueva, por lo que este método debería
        //      ser más elaborado.

        //Se elimina la versión anterior de la TABLE
        db.execSQL("DROP TABLE IF EXISTS Clientes");
        db.execSQL("DROP TABLE IF EXISTS Pizzas");
        db.execSQL("DROP TABLE IF EXISTS Tamaños");
        db.execSQL("DROP TABLE IF EXISTS Bebidas");
        db.execSQL("DROP TABLE IF EXISTS Masas");
        db.execSQL("DROP TABLE IF EXISTS Lineas_bebidas");
        db.execSQL("DROP TABLE IF EXISTS Lineas_pizzas");
        db.execSQL("DROP TABLE IF EXISTS Cabecera_pedido");


        //Se crea la nueva versión de la TABLE
        db.execSQL(sqlCreateClientes);
        db.execSQL(sqlCreatePizzas);
        db.execSQL(sqlCreateTamaños);
        db.execSQL(sqlCreateMasa);
        db.execSQL(sqlCreateBebidas);

        db.execSQL(sqlCreateArticulos);
        db.execSQL(sqlCreateDrink);
        db.execSQL(sqlCreatePedidos);
    }







}
