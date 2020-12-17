package com.juanefa.shoppingmartapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private MyDatabase db;
    private EditText ePlh, eNama, eNohp, eQty;
    private String sPlh, sNama, sNohp, sQty;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_create);
        getSupportActionBar().setTitle("Spinner");

        db = new MyDatabase(this);
        ePlh = (EditText) findViewById(R.id.create_pilihan);
        eNama = (EditText) findViewById(R.id.create_nama);
        eNohp = (EditText) findViewById(R.id.create_nohp);
        eQty = (EditText) findViewById(R.id.create_quantity);


        Button btnCreate = (Button) findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sPlh = String.valueOf(ePlh.getText());
                sNama = String.valueOf(eNama.getText());
                sNohp = String.valueOf(eNohp.getText());
                sQty = String.valueOf(eQty.getText());
                if (sPlh.equals("")){
                    ePlh.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Pilihan anda",
                            Toast.LENGTH_SHORT).show();
                } else if (sNama.equals("")){
                    eNama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Nama Anda",
                            Toast.LENGTH_SHORT).show();
                } else if (sNohp.equals("")){
                    eNohp.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Nomer Telpon Anda",
                            Toast.LENGTH_SHORT).show();
                }else if (sQty.equals("")) {
                    eQty.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Quantity",
                            Toast.LENGTH_SHORT).show();
                }else {
                    ePlh.setText("");
                    eNama.setText("");
                    eNohp.setText("");
                    eQty.setText("");
                    Toast.makeText(MainCreate.this, "Pesanan anda telah ditambahkan",
                            Toast.LENGTH_SHORT).show();
                    db.CreateShopping(new ShoppingMart(null, sPlh, sNama, sNohp, sQty));
                    Intent a = new Intent(MainCreate.this, MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}
