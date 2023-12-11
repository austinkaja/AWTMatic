package com.cs407.frontend_awtmatic;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class GeneratedPlaylistActivity extends AppCompatActivity {

    // artists to use for prototype - SpotifyAPI nonfunctional:
    // Jay-Z, Drake, Lil Uzi Vert, Michael Jackson, J. Cole

    private ArrayList<String> jayZSongs = new ArrayList<>(Arrays.asList(
            "Empire State of Mind",
            "99 Problems",
            "Hard Knock Life (Ghetto Anthem)",
            "Numb / Encore",
            "Big Pimpin'",
            "Run This Town",
            "Holy Grail",
            "Izzo (H.O.V.A.)",
            "Dirt Off Your Shoulder",
            "Song Cry"
    ));

    private ArrayList<String> drakeSongs = new ArrayList<>(Arrays.asList(
            "God's Plan",
            "In My Feelings",
            "Hotline Bling",
            "Started From the Bottom",
            "One Dance",
            "Take Care",
            "Hold On, We're Going Home",
            "Passionfruit",
            "Nice For What",
            "Best I Ever Had"
    ));

    private ArrayList<String> lilUziVertSongs = new ArrayList<>(Arrays.asList(
            "XO Tour Llif3",
            "The Way Life Goes",
            "Money Longer",
            "You Was Right",
            "P2",
            "Futsal Shuffle 2020",
            "Sanguine Paradise",
            "20 Min",
            "Erase Your Social",
            "Do What I Want"
    ));

    private ArrayList<String> michaelJacksonSongs = new ArrayList<>(Arrays.asList(
            "Billie Jean",
            "Thriller",
            "Beat It",
            "Man in the Mirror",
            "Smooth Criminal",
            "Black or White",
            "Bad",
            "Heal the World",
            "The Way You Make Me Feel",
            "Remember the Time"
    ));

    private ArrayList<String> jColeSongs = new ArrayList<>(Arrays.asList(
            "No Role Modelz",
            "Middle Child",
            "Wet Dreamz",
            "Love Yourz",
            "Crooked Smile",
            "Apparently",
            "A Tale of 2 Citiez",
            "G.O.M.D.",
            "Power Trip",
            "Work Out"
    ));

    private HashMap<String, ArrayList<String>> ARTIST_SONGS = new HashMap<String, ArrayList<String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated_playlist);

        // initializing songs HashMap above
        ARTIST_SONGS.put("Jay Z", jayZSongs);
        ARTIST_SONGS.put("Lil Uzi Vert", lilUziVertSongs);
        ARTIST_SONGS.put("Michael Jackson", michaelJacksonSongs);
        ARTIST_SONGS.put("Drake", drakeSongs);
        ARTIST_SONGS.put("J Cole", jColeSongs);

        // get input and output playlist sizes from shared preferences --

        int inputPlaylistSize = 10;
        int outputPlaylistSize = 20;

        ListView generatedPlaylist = findViewById(R.id.generated_songs);

        Intent intent = getIntent();
        ArrayList<String> inputSongs = (ArrayList<String>) intent.getSerializableExtra("song_list");
        System.out.println(inputSongs);
        ArrayList<String> artistsProvided = new ArrayList<String>();
        if (inputSongs != null) {
            System.out.println(inputSongs.size());
            for(int i = 0; i < inputSongs.size(); i++) {

                // Extracting Artist: format for songs "Song Title - Song Artist"
                String song = inputSongs.get(i);
                String[] parts = song.split("-");
                if (parts.length == 2) {
                    String artist = parts[1].trim();
                    artistsProvided.add(artist);
                    System.out.println(artist);
                }
            }

            // artistsProvided now has all artists user has entered

            // calculating ratios of artists in the provided playlist
            HashMap<String, Double> artistFreq = new HashMap<String, Double>();
            for(int i = 0; i < artistsProvided.size(); i++){

                String artist = artistsProvided.get(i);
                if(artistFreq.containsKey(artist)){
                    double newFreq = artistFreq.get(artist) + 1.0;
                    artistFreq.put(artist, newFreq);

                }
                else{
                    artistFreq.put(artist, 1.0);
                }

            }

            System.out.println(artistFreq.keySet());

            ArrayList<String> newSongs = new ArrayList<String>();
            for(String artist : artistFreq.keySet()){

                // calculating number of songs we need from each artist
                int songsNeeded = (int) (artistFreq.get(artist) / inputSongs.size() * outputPlaylistSize);
                System.out.println(songsNeeded);

                // get predetermined songs we have stored
                List<String> artistsSongs = ARTIST_SONGS.get(artist);
                System.out.println(artistsSongs);

                // get sample of size songsNeeded from list artistsSongs
                Collections.shuffle(artistsSongs);
                List<String> selectedSongs = artistsSongs.subList(0, (int) songsNeeded);
                newSongs.addAll(selectedSongs);

            }

            Collections.shuffle(newSongs);



            // Now put the new songs into ListView that will be the users new generated playlist
            ListView tailoredList = findViewById(R.id.generated_songs);

            // Create an ArrayAdapter using the default list item layout and your list of songs
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item, newSongs);

            // Set the adapter to the ListView
            tailoredList.setAdapter(adapter);

        }


        // Allowing user to click "Shake to Regenerate" as well as actually shaking the phone
        Button shakeButton = findViewById(R.id.shakeButton);
        shakeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ArrayList<String> shake_generated = generateSongs(inputPlaylistSize, outputPlaylistSize, inputSongs);
                ListView tailoredList = findViewById(R.id.generated_songs);
                ArrayAdapter<String> adapter = new ArrayAdapter<>(GeneratedPlaylistActivity.this, R.layout.list_item, shake_generated);
                tailoredList.setAdapter(adapter);

            }
        });

    }

    public ArrayList<String> generateSongs(int inputPlaylistSize, int outputPlaylistSize, ArrayList<String> inputSongs) {
        ArrayList<String> artistsProvided = new ArrayList<String>();
        if (inputSongs != null) {
            System.out.println(inputSongs.size());
            for (int i = 0; i < inputSongs.size(); i++) {

                // Extracting Artist: format for songs "Song Title - Song Artist"
                String song = inputSongs.get(i);
                String[] parts = song.split("-");
                if (parts.length == 2) {
                    String artist = parts[1].trim();
                    artistsProvided.add(artist);
                    System.out.println(artist);
                }
            }

            // artistsProvided now has all artists user has entered

            // calculating ratios of artists in the provided playlist
            HashMap<String, Double> artistFreq = new HashMap<String, Double>();
            for (int i = 0; i < artistsProvided.size(); i++) {

                String artist = artistsProvided.get(i);
                if (artistFreq.containsKey(artist)) {
                    double newFreq = artistFreq.get(artist) + 1.0;
                    artistFreq.put(artist, newFreq);

                } else {
                    artistFreq.put(artist, 1.0);
                }

            }

            System.out.println(artistFreq.keySet());

            ArrayList<String> newSongs = new ArrayList<String>();
            for (String artist : artistFreq.keySet()) {

                // calculating number of songs we need from each artist
                int songsNeeded = (int) (artistFreq.get(artist) / inputSongs.size() * outputPlaylistSize);
                System.out.println(songsNeeded);

                // get predetermined songs we have stored
                List<String> artistsSongs = ARTIST_SONGS.get(artist);
                System.out.println(artistsSongs);

                // get sample of size songsNeeded from list artistsSongs
                Collections.shuffle(artistsSongs);
                List<String> selectedSongs = artistsSongs.subList(0, (int) songsNeeded);
                newSongs.addAll(selectedSongs);

            }

            Collections.shuffle(newSongs);

            return newSongs;


        } else {
            return null;
        }
    }
}