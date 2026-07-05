package com.example.lab6;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    EditText userName;
    EditText password;

    TextView loginTxt;

    LoginValidator validator = new LoginValidator();

    public LoginActivity(){}

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin=(Button)findViewById(R.id.btnLogin);
        userName=(EditText)findViewById(R.id.edtUsername);
        password=(EditText)findViewById(R.id.edtPassword);
        loginTxt = findViewById(R.id.loginTxt);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputName = userName.getText().toString();
                String inputPassword = password.getText().toString();

                loginTxt.setVisibility(View.VISIBLE);

                // 1. If it's completely empty, treat it as an invalid last name scenario
                if (inputName.trim().isEmpty()) {
                    loginTxt.setText("Last name is invalid");
                }
                // 2. If it contains numbers (like "John123"), treat it as an invalid name scenario
                else if (!validator.isValidName(inputName)) {
                    loginTxt.setText("Name is invalid");
                }
                // 3. Password handling
                else if (!validator.isValidPassword(inputPassword)) {
                    loginTxt.setText("Invalid login!");
                } else {
                    loginTxt.setText("Login was successful");
                }
            }
        });
    }
    public LoginActivity(Context context){

    }

    public String validate(String userName, String password)
    {
        if(userName.equals("admin") && password.equals("admin"))
            return "Login was successful";
        else
            return "Invalid login!";
    }
}
