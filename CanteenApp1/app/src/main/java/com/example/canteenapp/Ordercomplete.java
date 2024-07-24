package com.example.canteenapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Ordercomplete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ordercomplete);
    }

    public void menupage(View view) {
        Intent intent=new Intent(getApplicationContext(),Menupage.class);
        startActivity(intent);
        RecyclerAdapter3.sum=0;
    }
}