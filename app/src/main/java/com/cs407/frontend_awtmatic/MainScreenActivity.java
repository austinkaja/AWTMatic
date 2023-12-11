package com.cs407.frontend_awtmatic;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainScreenActivity extends AppCompatActivity {
    private EditText songInput;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> songs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_screen);

        // Following code handles when the add button is pressed - adds song to ListView
        songInput = findViewById(R.id.song_input);
        Button addButton = findViewById(R.id.add_song_button);
        ListView songList = findViewById(R.id.song_list);

        songs = new ArrayList<>();
        adapter = new ArrayAdapter<>(this, R.layout.list_item, songs);
        songList.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String song = songInput.getText().toString();
                if (!song.isEmpty()) {
                    songs.add(song);
                    adapter.notifyDataSetChanged();
                    songInput.setText("");
                }
            }
        });

        // Code handles when 'generate playlist' button is pressed - will take user to next screen and display playlist

        Button generateButton = findViewById(R.id.btnGeneratePlaylist);


        generateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToGeneratePlaylistScreen();

            }

        });
    }

    private void goToGeneratePlaylistScreen() {

        Intent intent = new Intent(MainScreenActivity.this, GeneratedPlaylistActivity.class);
        intent.putExtra("song_list", songs); // Adding the songs list as an extra
        startActivity(intent);




    }
}
