package com.example.musicapplicationtemplate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


import adapter.SongAdapter;
import model.Account;
import model.Song;
import sqlserver.SongDAO;

public class HomeActivity extends AppCompatActivity {
TextView txtHelloWorld;
TextView txtInfor;
RecyclerView rvSongs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);


//        Intent intentHome = getIntent();
//        Account a = (Account) intentHome.getSerializableExtra("account");
//        txtHelloWorld = findViewById(R.id.txtHelloWorld);
//        txtInfor = findViewById(R.id.txtInfor);
//        txtHelloWorld.setText("Hello " + a.getFirst_name() + " " + a.getLast_name());
//        txtInfor.setText("Username: " + a.getUsername()
//                       + "\nEmail:" + a.getEmail()
//                       + "\nPhone: " + a.getPhone());


        rvSongs = findViewById(R.id.rvSongs);
        SongDAO songDAO = new SongDAO();
        List<Song> songs = songDAO.getAllSongs();
        SongAdapter songAdapter = new SongAdapter(this,songs);
        rvSongs.setAdapter(songAdapter);
        rvSongs.setLayoutManager(new LinearLayoutManager(this));



    }
}