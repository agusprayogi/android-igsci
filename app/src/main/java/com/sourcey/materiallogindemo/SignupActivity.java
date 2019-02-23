package com.sourcey.materiallogindemo;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sourcey.materiallogindemo.api.ApiClient;
import com.sourcey.materiallogindemo.model.LoginModel;

import android.util.Patterns;
import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.google.common.collect.Range;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import com.sourcey.materiallogindemo.api.ApiClient;
import com.sourcey.materiallogindemo.model.RegisterModel;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SignupActivity extends AppCompatActivity  {

    private static final String TAG = "SignupActivity";
    private EditText et_usernameText,et_passwordText,et_emailText;
    private String input_username, input_password, input_email;
    private ApiClient apiClient = new ApiClient();
    private String role_user = "user";
    @BindView(R.id.input_username) EditText _usernameText;
    @BindView(R.id.input_password) EditText _passwordText;
    @BindView(R.id.input_email) EditText _emailText;
    @BindView(R.id.btn_signup) TextView _signupButton;
    @BindView(R.id.link_login) TextView _loginLink;

    private AwesomeValidation awesomeValidation;
    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);
        ButterKnife.bind(this);
        et_usernameText = (EditText) findViewById(R.id.input_username);
        et_passwordText = (EditText) findViewById(R.id.input_password);
        et_emailText = (EditText) findViewById(R.id.input_email);

        awesomeValidation.addValidation(this, R.id.input_username, "^[A-Za-z_][A-Za-z0-9_]{4,20}$", R.string.nameerror);
        awesomeValidation.addValidation(this, R.id.input_email, Patterns.EMAIL_ADDRESS, R.string.emailerror);
        awesomeValidation.addValidation(this, R.id.input_password, "^[A-Za-z0-9][A-Za-z0-9]{4,20}$", R.string.passworderror);


        _signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {

                Call<RegisterModel> apiCallRegister = apiClient.getService().registerRequest(_usernameText.getText().toString(),
                        _passwordText.getText().toString(), _emailText.getText().toString(), role_user);
                apiCallRegister.enqueue(new Callback<RegisterModel>() {
                    @Override
                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
                        if (response.isSuccessful()){
                            System.out.println("Regis");
                            int registerStatus = response.body().getStatus();
                            if (registerStatus==200){
                                Toast.makeText(SignupActivity.this, "register Succes", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(SignupActivity.this, LoginActivity.class);
                                startActivity(i);
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<RegisterModel> call, Throwable t) {
                    Toast.makeText(SignupActivity.this, "REGISTER FAILED", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }});

        _loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Finish the registration screen and return to the Login activity
                Intent i = new Intent(SignupActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });
    }



}