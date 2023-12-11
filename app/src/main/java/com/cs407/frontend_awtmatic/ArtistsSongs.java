package com.cs407.frontend_awtmatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class ArtistsSongs {
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
            "Best I Ever Had",
            "Hours in Silence",
            "Flight's Booked"

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

    ArrayList<String> postMaloneSongs = new ArrayList<>(Arrays.asList("Circles", "Sunflower", "Congratulations", "Rockstar", "White Iverson", "Better Now", "Goodbyes", "Wow", "Psycho", "I Fall Apart", "Saint-Tropez", "Hollywood's Bleeding", "Die For Me", "Take What You Want", "Candy Paint"));
    ArrayList<String> kendrickLamarSongs = new ArrayList<>(Arrays.asList("HUMBLE.", "DNA.", "Alright", "King Kunta", "LOYALTY.", "Swimming Pools (Drank)", "Bitch, Don't Kill My Vibe", "LOVE.", "Poetic Justice", "ELEMENT.", "M.A.A.D City", "Backseat Freestyle", "The Blacker the Berry", "i", "Sing About Me, I'm Dying of Thirst"));
    ArrayList<String> futureSongs = new ArrayList<>(Arrays.asList("Mask Off", "Life is Good", "Low Life", "Turn On the Lights", "Fuck Up Some Commas", "Where Ya At", "Jumpman", "Fine China", "Stick Talk", "March Madness", "Rich $ex", "Used to This", "Crushed Up", "Move That Dope", "Honest"));
    ArrayList<String> savageSongs = new ArrayList<>(Arrays.asList("Bank Account", "a lot", "X", "No Heart", "Savage Mode", "Ball w/o You", "Monster", "Runnin", "Rich N**** Shit", "1.5", "Glock in My Lap", "Mr. Right Now", "Snitches & Rats", "Steppin on Niggas", "Many Men"));

    ArrayList<String> szaSongs = new ArrayList<>(Arrays.asList("Hit Different", "Good Days", "The Weekend", "Love Galore", "Broken Clocks", "Garden (Say It Like Dat)", "Drew Barrymore", "Supermodel", "20 Something", "Prom", "Normal Girl", "Babylon", "Warm Winds", "Doves In The Wind", "Pretty Little Birds"));
    ArrayList<String> theWeekndSongs = new ArrayList<>(Arrays.asList("Blinding Lights", "The Hills", "Starboy", "Can't Feel My Face", "Save Your Tears", "In Your Eyes", "Often", "Die For You", "I Feel It Coming", "Wicked Games", "Call Out My Name", "Heartless", "Reminder", "After Hours", "Take My Breath"));
    ArrayList<String> gunnaSongs = new ArrayList<>(Arrays.asList("Drip Too Hard", "WUNNA", "Skybox", "Dollaz On My Head", "Speed It Up", "Baby Birkin", "Blindfold", "Cooler Than A Bitch", "One Call", "Outstanding", "Oh Okay", "Pedestrian", "Richard Millie Plain", "Top Off", "Who You Foolin"));
    ArrayList<String> playboiCartiSongs = new ArrayList<>(Arrays.asList("Magnolia", "Shoota", "Kid Cudi", "Long Time", "R.I.P.", "Sky", "Molly", "New Choppa", "Location", "Yah Mean", "FlatBed Freestyle", "Fell In Luv", "Stop Breathing", "Punk Monk", "Go2DaMoon"));
    public ArtistsSongs(){

    }

    public HashMap<String, ArrayList<String>>  generateMapping(){

        ArrayList<String> artists = new ArrayList<>(Arrays.asList("Jay Z", "Drake", "J Cole", "Michael Jackson", "Lil Uzi Vert", "Post Malone", "Kendrick Lamar", "Future", "21 Savage", "SZA", "Gunna", "Playboi Carti", "The Weeknd"));

        HashMap<String, ArrayList<String>> songMapping = new HashMap<String, ArrayList<String>>();
        songMapping.put("Jay Z", jayZSongs);
        songMapping.put("Drake", drakeSongs);
        songMapping.put("J Cole", jColeSongs);
        songMapping.put("Michael Jackson", michaelJacksonSongs);
        songMapping.put("Lil Uzi Vert", lilUziVertSongs);
        songMapping.put("Post Malone", postMaloneSongs);
        songMapping.put("Kendrick Lamar", kendrickLamarSongs);
        songMapping.put("Future", futureSongs);
        songMapping.put("21 Savage", savageSongs);
        songMapping.put("SZA", szaSongs);
        songMapping.put("Gunna", gunnaSongs);
        songMapping.put("Playboi Carti", playboiCartiSongs);
        songMapping.put("The Weeknd", theWeekndSongs);

        return songMapping;


    }





}
