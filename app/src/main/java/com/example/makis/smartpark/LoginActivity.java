package com.example.makis.smartpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private Button sing_or_register;
    private EditText email;
    private EditText password;
    private EditText username;
    private static final String URL="";
    private RequestQueue requestQueue;
private StringRequest request;


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
        email=(EditText) findViewById(R.id.email);
        password=(EditText)findViewById(R.id.password);
        username=(EditText) findViewById(R.id.username);
        sing_or_register=(Button)findViewById(R.id.sing_or_register);
       requestQueue = Volley.newRequestQueue(this);
        sing_or_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                request=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject=new JSONObject(response);
                            if(jsonObject.names().get(0).equals("status"))
                            {
                                Toast.makeText(getApplicationContext(),"SUCCESS"+jsonObject.getString("status"),Toast.LENGTH_SHORT).show();
                                init();
                            }
                            else
                            {
                             Toast.makeText(getApplicationContext(),"Error"+jsonObject.getString("error"),Toast.LENGTH_SHORT).show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }){
                    @Override
                    protected Map<String,String> getParams() throws AuthFailureError {
                        HashMap<String,String> hashMap=new HashMap<String,String>();
                        hashMap.put("email",email.getText().toString());
                        hashMap.put("password",password.getText().toString());
                        return hashMap;
                    }
                };
                requestQueue.add(request);
            }
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }

}
