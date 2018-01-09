/*Pantalla con la informacion*/

package com.example.adminportatil.definitiva7;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private Button ubicarme,volver;
    ArrayList<String> pedidos;

    /*int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1 ;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = getIntent().getExtras();
        pedidos=bundle.getStringArrayList("Usuarios");

        ubicarme=(Button)findViewById(R.id.ubicarme);

        ubicarme.setOnClickListener(new View.OnClickListener()
                                    {
                                        public void onClick(View arg0){
                                            Intent inten=new Intent(MainActivity.this,MapsActivity.class);
                                            startActivity(inten);

                                        }

                                    }
        );

        volver=(Button)findViewById(R.id.btnVolver);

        volver.setOnClickListener(new View.OnClickListener()
                                    {
                                        public void onClick(View arg0){
                                            Intent intentaa=new Intent(MainActivity.this,PantallaEleccion.class);
                                            intentaa.putExtra("Usuarios",pedidos);
                                            startActivity(intentaa);

                                        }

                                    }

        );

    }
}
