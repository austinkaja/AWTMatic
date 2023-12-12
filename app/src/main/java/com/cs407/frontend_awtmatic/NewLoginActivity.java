package com.cs407.frontend_awtmatic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class NewLoginActivity extends AppCompatActivity {
    private Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_login);

        EditText username = findViewById(R.id.etUsername);
        EditText password = findViewById(R.id.etPassword);
        signupButton = findViewById(R.id.btnSignup);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String inputPassword = password.getText().toString();
                // check if password is valid
                if (!isPasswordValid(inputPassword)) {
                    Toast.makeText(NewLoginActivity.this, "Password must be at least 7 characters, contain a special symbol, and have an uppercase letter.", Toast.LENGTH_LONG).show();
                    return;
                }

                // puts username and password pair into shared preferences
                saveUserCredentials(username.getText().toString(), password.getText().toString());
                username.setText("");
                password.setText("");

                // send user to main page
                Intent intent = new Intent(NewLoginActivity.this, MainScreenActivity.class);
                Toast.makeText(NewLoginActivity.this, "Account Created!", Toast.LENGTH_SHORT).show();
                startActivity(intent);
            }
        });
    }

    private boolean isPasswordValid(String password) {
        if (password.length() < 7) {
            return false;
        }

        boolean hasUppercase = !password.equals(password.toLowerCase());
        boolean hasSpecial = !password.matches("[A-Za-z0-9 ]*");

        return hasUppercase && hasSpecial;
    }

    private void saveUserCredentials(String key, String value){
        SharedPreferences preferences = getSharedPreferences("credentials", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();
    }
}
