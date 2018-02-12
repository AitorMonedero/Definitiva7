/*Pantalla de carga*/

package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class PrimeraPantalla extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primera_pantalla);

        Thread logoTimer = new Thread(){
            public void run(){
                try{
                    sleep(3000);
                }catch(Exception e){
                    e.printStackTrace();
                }finally{
                    Intent intent = new Intent(PrimeraPantalla.this, PantallaEleccion.class);
                    startActivity(intent);
                }
                finish();
            }
        };

        logoTimer.start();

    }
}