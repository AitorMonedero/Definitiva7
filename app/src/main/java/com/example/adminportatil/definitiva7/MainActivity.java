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

public class MainActivity extends AppCompatActivity {

    private Button ubicarme,volver,llamar;


    /*int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE);
    private static final int MY_PERMISSIONS_REQUEST_CALL_PHONE = 1 ;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



/*
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},MY_PERMISSIONS_REQUEST_CALL_PHONE);

            }
        }

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {

            } else {

                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, MY_PERMISSIONS_REQUEST_CALL_PHONE);

            }
        }*/
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
                                            startActivity(intentaa);
                                        }

                                    }

        );

/*
    llamar = (Button) findViewById(R.id.btnLlamada);

    llamar.setOnClickListener(new View.OnClickListener() {
                                  public void onClick(View arg0) {
                                      Intent callIntent = new Intent(Intent.ACTION_CALL);
                                      callIntent.setData(Uri.parse("tel:943316900"));
                                      try {
                                              startActivity(callIntent);
                                      }catch(SecurityException e){
                                          Toast toast1 = Toast.makeText(getApplicationContext(), "No se ha podido realizar la llamada.", Toast.LENGTH_SHORT);
                                          toast1.show();
                                      }
                                  }

                              }

    );*/



    }


    /*@Override
    public void onRequestPermissionsResult(int requestCode,String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_CALL_PHONE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > && grantResults[] == PackageManager.PERMISSION_GRANTED) {

                } else {

                }
                return;
            }
        }
    }*/
}
