package com.example.adminportatil.definitiva7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button ubicarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ubicarme=(Button)findViewById(R.id.ubicarme);

        ubicarme.setOnClickListener(new View.OnClickListener()
                                    {
                                        public void onClick(View arg0){
                                            Intent inten=new Intent(MainActivity.this,MapsActivity.class);
                                            startActivity(inten);
                                        }

                                    }

        );
    }
}
