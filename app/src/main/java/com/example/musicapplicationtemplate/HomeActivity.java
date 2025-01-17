package com.example.musicapplicationtemplate;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import model.Account;

public class HomeActivity extends AppCompatActivity {
TextView txtHelloWorld;
TextView txtInfor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        Intent intentHome = getIntent();
        Account a = (Account) intentHome.getSerializableExtra("account");
        txtHelloWorld = findViewById(R.id.txtHelloWorld);
        txtInfor = findViewById(R.id.txtInfor);
        txtHelloWorld.setText("Hello " + a.getFirst_name() + " " + a.getLast_name());
        txtInfor.setText("Username: " + a.getUsername()
                       + "\nEmail:" + a.getEmail()
                       + "\nPhone: " + a.getPhone());

    }
}