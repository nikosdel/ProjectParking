package com.example.makis.smartpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ButtonBarLayout;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {

   /*public Button but2;

    public void init(){
        but2=(Button)findViewById(R.id.but2);
        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy= new Intent(LoginActivity.this,MainActivity.class);

                startActivity(toy);
            }
        });
    }*/






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //init();
    }
}
