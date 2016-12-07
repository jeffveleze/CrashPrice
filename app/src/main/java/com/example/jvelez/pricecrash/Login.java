package com.example.jvelez.pricecrash;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import dmax.dialog.SpotsDialog;

public class Login extends AppCompatActivity {

    EditText user, password;
    Button loginButton;
    //DbHelper dataBase = new DbHelper();
    private AlertDialog myProgressDialog;
    String userRead = "jeff@gmail.com";
    String passwordRead = "jeff123";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //dataBase.configurePersistence();
        //dataBase.syncCarsData();

        myProgressDialog = new SpotsDialog(this, R.style.CustomProgressDialogStarting);
        user = (EditText) findViewById(R.id.usuario);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginbutton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validationsAreOkay()){
                    manageProgressDialog();
                }

            }
        });

    }

    private boolean validationsAreOkay() {

        boolean valueToReturn = false;
        if (user.getText().toString().matches("") || password.getText().toString().matches("")){
            Toast.makeText(getApplicationContext(),"Completa los campos",Toast.LENGTH_SHORT).show();
        }else {

            if(!android.util.Patterns.EMAIL_ADDRESS.matcher(user.getText().toString()).matches()){
                Toast.makeText(getApplicationContext(),"Formato de email incorrecto",Toast.LENGTH_SHORT).show();
            }else {

                if (user.getText().toString().equals(userRead) && password.getText().toString().equals(passwordRead))
                // Successfull
                valueToReturn = true;
                else {
                    Toast.makeText(getApplicationContext(),"Verifica tu usuario y/o contraseña",Toast.LENGTH_SHORT).show();
                }
            }
        }

        return valueToReturn;
    }

    private void manageProgressDialog() {

        myProgressDialog.show();

        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        // On complete call either onLoginSuccess or onLoginFailed
                        myProgressDialog.dismiss();
                        saveLoggedStatus();
                        finish();
                        goToNextActivity();
                    }
                }, 2000);
    }

    private void saveLoggedStatus() {

        SharedPreferences sharedPreference = getSharedPreferences("infoapp", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreference.edit();
        editor.putString("logged", "true");
        editor.commit();

    }

    private void goToNextActivity() {

        Intent intent = new Intent(Login.this,QuoteActivity.class);
        startActivity(intent);

    }

}
