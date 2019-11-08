package com.kamisolutions.shishawithme;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper db;
    Button loginButton;
    TextView registerButton;
    EditText username;
    EditText password;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = new DatabaseHelper(this);

        loginButton = (Button) findViewById(R.id.loginButton1);
        registerButton = (TextView) findViewById(R.id.registerView1);
        username = (EditText) findViewById(R.id.PasswordTextField1);
        password = (EditText) findViewById(R.id.PasswordTextField1);


        registerButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Intent registerintent = new Intent(getApplicationContext(), RegisterActivity.class);

                startActivity(registerintent);
            }
        });

        loginButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String user = username.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                boolean res = db.checkUser(user, pwd);

                if(res){

                    Toast.makeText(getApplicationContext(), "Successfully logged in! ", Toast.LENGTH_SHORT).show();
                    Intent callList = new Intent(getApplicationContext(), ShishaList.class);
                    startActivity(callList);

                }else{
                    Toast.makeText(getApplicationContext(), "Failed to login! ", Toast.LENGTH_SHORT).show();

                }



            }
        });


    }
}
