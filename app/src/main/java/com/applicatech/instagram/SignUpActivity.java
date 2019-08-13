package com.applicatech.instagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class SignUpActivity extends AppCompatActivity {

    private EditText etUsername2;
    private EditText etEmailSignup;
    private EditText etPassword2;
    private Button btnSignUp;
    private TextView tvSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        etUsername2 = findViewById(R.id.etUserName2);
        etEmailSignup = findViewById(R.id.etEmailSignup);
        etPassword2 = findViewById(R.id.etPassword2);
        btnSignUp = findViewById(R.id.btnSignUp);
        tvSignUp = findViewById(R.id.tvSignUp);

        tvSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
            }
        });



        btnSignUp.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View view) {

                if(etUsername2.getText().toString().isEmpty() || etPassword2.getText().toString().isEmpty()){

                    Toast.makeText(SignUpActivity.this, "Username and password are required", Toast.LENGTH_SHORT).show();

                }



                String username = etUsername2.getText().toString();

                String email = etEmailSignup.getText().toString();

                String password = etPassword2.getText().toString();





                ParseUser user = new ParseUser();

                user.setUsername(username);

                user.setEmail(email);

                user.setPassword(password);




                user.signUpInBackground(new SignUpCallback() {

                    @Override

                    public void done(ParseException e) {

                        if(e == null){

                            etUsername2.setText("");

                            etEmailSignup.setText("");

                            etPassword2.setText("");

                            Intent i = new Intent(getApplicationContext(),MainActivity.class);

                            startActivity(i);

                        }else{

                            ParseErrorHandler.handleParseError(e);

                        }

                    }

                });

            }

        });

    }



}
