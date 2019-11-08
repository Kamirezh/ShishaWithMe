package com.kamisolutions.shishawithme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity {

    DatabaseHelper db;
    EditText uName;
    EditText pWord;
    EditText confWord;
    Button regBut;
    TextView logView;



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        uName= (EditText) findViewById(R.id.usernameTextField2);
        pWord= (EditText) findViewById(R.id.passwordTextField2);
        confWord= (EditText) findViewById(R.id.ConfirmPasswordTextField2);
        regBut= (Button) findViewById(R.id.regButton2);
        logView= (TextView) findViewById(R.id.loginText2);


        db = new DatabaseHelper(this);



        logView.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                Intent login = new Intent(getApplicationContext(), MainActivity.class);

                startActivity(login);

            }
        });

        regBut.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {

                String user = uName.getText().toString().trim();
                String pwd = pWord.getText().toString().trim();
                String cnfpwd = confWord.getText().toString().trim();

                if(pwd.equals(cnfpwd)){
                    long val = db.addUser(user, pwd);
                    if (val >0) {
                        Toast.makeText(RegisterActivity.this, "Successfully registered! ", Toast.LENGTH_SHORT).show();

                        Intent moveToLogin = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(moveToLogin);
                    }else{
                        Toast.makeText(RegisterActivity.this, "Registration Error! ", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(RegisterActivity.this, "Passwords are not matching! ", Toast.LENGTH_SHORT).show();

                }




            }
        });




    }


}
