package com.cs407.frontend_awtmatic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginScreenActivity extends AppCompatActivity {
    private Button loginButton;
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        EditText username = findViewById(R.id.etUsername);
        EditText password = findViewById(R.id.etPassword);
        loginButton = findViewById(R.id.btnLogin);
        signupButton = findViewById(R.id.btnSignup);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // will only take user to main screen if username/password pair exists.
                System.out.println("LOGIN BUTTON PRESSED");
                SharedPreferences credentials = getSharedPreferences("credentials", MODE_PRIVATE);

                String inputUsername = username.getText().toString();
                String inputPassword = password.getText().toString();

                String defaultPassword = "Null";
                String retrievedPassword = credentials.getString(inputUsername, defaultPassword);
                System.out.println(retrievedPassword);

                if(retrievedPassword.equals(inputPassword)) {
                    goToMainScreen();
                }
                else{
                    Toast.makeText(getApplicationContext(), "Wrong Password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // puts username and password pair into shared preferences
                System.out.println("SIGN UP BUTTON PRESSED");
                System.out.println(username.getText().toString());
                System.out.println(password.getText().toString());
                saveUserCredentials(username.getText().toString(), password.getText().toString());
                username.setText("");
                password.setText("");

            }
        });
    }

    private void goToMainScreen() {
        Intent intent = new Intent(LoginScreenActivity.this, MainScreenActivity.class);
        startActivity(intent);
    }
    private void saveUserCredentials(String key, String value){
        SharedPreferences preferences = getSharedPreferences("credentials", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
