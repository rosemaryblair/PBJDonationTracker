package edu.gatech.micheyang.pbjdonationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    EditText userUsername = (EditText)findViewById(R.id.enterLoginUsername);
    EditText userPassword = (EditText)findViewById(R.id.enterLoginPassword);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void onCancelPressed(View view) {
        Log.d("Edit", "canceled");
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void onLoginButtonPressed(View view) {
        Log.d("Edit", "Logged In");
        /**Add Username and Password checking here
         * If the login is invalid, show some text saying that the username or password is invalid
         */
        if (isUsernameValid() && isPassWordCorrect()) {
        /**
         * Comment left from Michelley, Katie, & Sabrina
         * If the login is correct, include the two lines below to go to the main app screen
         */
        Intent intent = new Intent(LoginActivity.this, AppScreen.class);
        startActivity(intent);
        } else {
            if (userUsername.getText().toString().trim().equalsIgnoreCase("")) {
                userUsername.setError("This field cannot be left blank");
            } else if (!isUsernameValid()) {
                userUsername.setError("Email is incorrect");
            }

            if (userPassword.getText().toString().trim().equalsIgnoreCase("")) {
                userPassword.setError("This field cannot be left blank");
            } else if (!isPassWordCorrect()) {
                userUsername.setError("Password is incorrect");
            }
        }
    }

    private boolean isUsernameValid() {
        return (userUsername.getText().toString().equals("user"));
    }

    private boolean isPassWordCorrect() {
        return(userPassword.getText().toString().equals("pass"));
    }
}
