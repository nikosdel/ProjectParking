package com.example.makis.smartpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button login;
    Button register;
    private RequestQueue requestQueue;
    private static final String URL = "http://next-tech.techlimittv.eu/ProjectParkingAPI/api/v1/users/login/index.php";
    private StringRequest request;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = (EditText) findViewById(R.id.email);
        password = (EditText) findViewById(R.id.password);
        login=(Button) findViewById(R.id.Login);
        register=(Button)findViewById(R.id.Register);
        requestQueue = Volley.newRequestQueue(this);
        register.setOnClickListener( new Button.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent myIntent=new Intent(v.getContext(),RegisterActivity.class);
                startActivity(myIntent);


            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                String finUrl=URL+"?email="+email.getText()+"&password="+password.getText();
                request = new StringRequest(Request.Method.GET, finUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if(jsonObject.getString("Status").equals("OK"))
                            {
                                Toast.makeText(getApplicationContext(),jsonObject.getString("Message"),Toast.LENGTH_SHORT).show();
                                new FileHandler().saveFile("token.txt",jsonObject.getString("Token"),view);



                                startActivity(new Intent(getApplicationContext(),MainLayerActivity.class));
                            }
                            else
                            {
                                Toast.makeText(getApplicationContext(),jsonObject.getString("Message"),Toast.LENGTH_SHORT).show();

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

                requestQueue.add(request);
            }
        });
    }
}
