package com.example.makis.smartpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainLayerActivity extends AppCompatActivity {
Button findpark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_layer);
        findpark=(Button)findViewById(R.id.fndpark);
        findpark.setOnClickListener( new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent=new Intent(v.getContext(),MapsActivity.class);
                startActivity(myIntent);


            }
        });


    }

}
