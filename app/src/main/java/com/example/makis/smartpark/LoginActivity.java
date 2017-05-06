package com.example.makis.smartpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {
    private Button sing_or_register;
    private EditText email;
    private EditText password;


    public void init(){
        sing_or_register=(Button)findViewById(R.id.sing_or_register);
        sing_or_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toy= new Intent(LoginActivity.this,MainActivity.class);

                startActivity(toy);
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }

}
