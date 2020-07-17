package com.ashish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private AppCompatEditText etUsername, etPassword;
    private AppCompatButton btnSignIn;
    private AppCompatTextView txtForgotPassword, txtFacebookLogin, txtSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        txtForgotPassword = findViewById(R.id.txtForgotPassword);
        txtFacebookLogin = findViewById(R.id.txtFacebookLogin);
        txtSignUp = findViewById(R.id.txtSignUp);

        txtFacebookLogin.setOnClickListener(this);
        txtForgotPassword.setOnClickListener(this);
        txtSignUp.setOnClickListener(this);
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSignIn:
                String username = etUsername.getText().toString().trim();
                String password = etPassword.getText().toString().trim();
                if (validation(username, password)) {
                    methodToast("Successfully signed in.");
                }
                break;
            case R.id.txtForgotPassword:
                methodToast("You clicked Forgot password.");
                break;
            case R.id.txtFacebookLogin:
                methodToast("You clicked facebook login.");
                break;
            case R.id.txtSignUp:
                methodToast("You clicked on Sign up.");
                break;
            default:
                break;
        }
    }

    private boolean validation(String username, String password) {
        if (TextUtils.isEmpty(username)) {
            methodToast("Enter Username.");
            return false;
        } else if (TextUtils.isEmpty(password)) {
            methodToast("Enter Password.");
            return false;
        } else return true;
    }

    private void methodToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}