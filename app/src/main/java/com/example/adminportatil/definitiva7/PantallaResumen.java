package com.example.adminportatil.definitiva7;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;


public class PantallaResumen extends AppCompatActivity {

    ArrayList<String> pedido,pedidosCliente;
    TextView txtResumen;
    Button cancelar;
    Button finalizar;
    Button resumen;

    int codigo,precio,codigoCliente,last,codigoUsuario;
    Double totalBebida,totalPizzas,sumaTodo;


    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_pedido);

        Bundle bundle = getIntent().getExtras();
        pedido = bundle.getStringArrayList("Usuarios");
        codigo = bundle.getInt("Codigo");
        precio = bundle.getInt("Money");
        codigoUsuario = bundle.getInt("codigoUsuario");


        txtResumen = (TextView) findViewById(R.id.cajaResumen);
        finalizar = (Button) findViewById(R.id.button9);
        cancelar = (Button) findViewById(R.id.button11);
        resumen = (Button) findViewById(R.id.btnResumen);

        StringBuilder b = new StringBuilder();
        for (String s : pedido) {
            b.append(s + "\n \n");
        }
        txtResumen.setText(b.toString());
        texto = txtResumen.getText().toString();

        resumen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                recogerDatos(codigoUsuario);
            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PantallaResumen.this, PantallaEleccion.class);

                startActivity(intent);
                finish();
            }
        });

        finalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, texto);
                sendIntent.setType("text/plain");
                startActivity(sendIntent);

                finish();

            }
        });


    }



   public void recogerDatos(int codigo){
       int i=1;
       sumaTodo=0.0;

       ActivitySQL conn = new ActivitySQL(this, "DBUsuarios", null, 14);
       SQLiteDatabase bd = conn.getReadableDatabase();
       Cursor cursor = bd.rawQuery("SELECT codigo_pedido FROM cabecera_pedido WHERE codigo = " + codigo,null );


       pedidosCliente=new ArrayList<String>();

       while (cursor.moveToNext()) {

           codigoCliente = cursor.getInt(0);

           Cursor cursor2 = bd.rawQuery("SELECT sum(precio *cantidad) FROM lineas_bebidas WHERE codigo_pedido = " + codigoCliente,null );

           while (cursor2.moveToNext()) {
               totalBebida = cursor2.getDouble(0);

           }



           Cursor cursor3 = bd.rawQuery("SELECT sum(precio *cantidad) FROM lineas_pizzas WHERE codigo_pedido = " + codigoCliente,null );

           while (cursor3.moveToNext()) {
               totalPizzas = cursor3.getDouble(0);

           }

           pedidosCliente.add("->PEDIDO : "+i);

           pedidosCliente.add("TOTAL DE LAS PIZZAS : "+totalPizzas+"€");

           pedidosCliente.add("TOTAL DE LAS BEBIDAS : "+totalBebida+"€");

           i=i+1;

           sumaTodo=sumaTodo+totalBebida+totalPizzas;


           cursor2.close();
           cursor3.close();
       }
       pedidosCliente.add("- - - - - - - - - - - - - - - - - -");

       pedidosCliente.add("HAS GASTADO EN TOTAL : "+sumaTodo+"€");


       cursor.close();


       StringBuilder b = new StringBuilder();
       for (String s : pedidosCliente){
           b.append(s+"\n \n");
       }

       AlertDialog.Builder builder = new AlertDialog.Builder(this);
       builder.setTitle("Tu historial de pedidos:").setMessage(b.toString());

       AlertDialog alert = builder.create();

       alert.show();


   }
}
