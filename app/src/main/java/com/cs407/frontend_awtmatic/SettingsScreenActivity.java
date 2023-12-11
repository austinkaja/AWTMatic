package com.cs407.frontend_awtmatic;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings_screen);

        ImageView logoutIcon = findViewById(R.id.logoutIcon);
        ImageView backButton = findViewById(R.id.backButton);
        EditText song_input_list_size = findViewById(R.id.inputPlaylistSize);
        EditText song_output_list_size = findViewById(R.id.outputPlaylistSize);
        Button confirmInputSizeButton = findViewById(R.id.confirmInputSizeButton);
        Button confirmOutputSizeButton = findViewById(R.id.confirmOutputSizeButton);


        logoutIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToMainScreen();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToPreviousScreen();
            }
        });

        confirmInputSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePlaylistSize("inputSize", song_input_list_size.getText().toString());
                song_input_list_size.setText("");
            }
        });

        confirmOutputSizeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                savePlaylistSize("outputSize", song_output_list_size.getText().toString());
                song_output_list_size.setText("");
            }
        });
    }

    private void savePlaylistSize(String key, String value) {
        int size = Integer.parseInt(value);
        SharedPreferences preferences = getSharedPreferences("AppSettings", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt(key, size);
        editor.apply();
    }

    private void goToMainScreen() {
        Intent intent = new Intent(SettingsScreenActivity.this, LoginScreenActivity.class);
        startActivity(intent);
    }

    private void goToPreviousScreen() {
        finish();
    }
}
