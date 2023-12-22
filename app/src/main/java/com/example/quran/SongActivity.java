package com.example.quran;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SongActivity extends AppCompatActivity {
    private List<Song> songList;
    private SongAdapter songAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song);
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        songList = createList(); // Replace with your actual song list
        songAdapter = new SongAdapter(songList);
        recyclerView.setAdapter(songAdapter);
    }

    private List<Song> createList() {
        List<Song> List = new ArrayList<>();
        List.add(new Song("سورة الفاتحة", "عبد الباسط عبد الصمد",R.raw.song1));

        // Add more songs as needed
        return List;
    }
}