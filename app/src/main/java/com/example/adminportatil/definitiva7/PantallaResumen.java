package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by adminportatil on 10/01/2018.
 */

public class PantallaResumen extends AppCompatActivity {

    ArrayList<String> pedido;
    TextView txtResumen;
    Button cancelar;
    Button finalizar;
    int dineros;
    String texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumen_pedido);

        Bundle bundle = getIntent().getExtras();
        pedido = bundle.getStringArrayList("Usuarios");



        txtResumen = (TextView) findViewById(R.id.cajaResumen);
        finalizar = (Button) findViewById(R.id.button9);
        cancelar = (Button) findViewById(R.id.button11);

        StringBuilder b = new StringBuilder();
        for (String s : pedido) {
            b.append(s + "\n \n");
        }
        txtResumen.setText(b.toString());
        texto=txtResumen.getText().toString();

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
}
