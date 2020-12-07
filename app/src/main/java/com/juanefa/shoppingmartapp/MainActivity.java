package com.juanefa.shoppingmartapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void btn_menu(View view){
        Intent a = new Intent(MainActivity.this, MainCreate.class);
        startActivity(a);
    }
    public void btn_troli(View view) {
        Intent b = new Intent(MainActivity.this, MainRead.class);
        startActivity(b);
    }

}