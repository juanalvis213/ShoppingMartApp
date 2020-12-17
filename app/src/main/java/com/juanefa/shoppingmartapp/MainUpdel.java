package com.juanefa.shoppingmartapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainUpdel extends AppCompatActivity {
    private MyDatabase db;
    private String sKode, sPlh, sNama, sNohp , sQty;
    private EditText ePlh, eNama, eNohp , eQty;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_updel);
        db = new MyDatabase(this);
        Intent i = this.getIntent();
        sKode = i.getStringExtra("Ikode");
        sPlh = i.getStringExtra("Ipilihan");
        sNama = i.getStringExtra("Inama");
        sNohp = i.getStringExtra("Iharga");
        sQty = i.getStringExtra("IQty");

        ePlh = (EditText) findViewById(R.id.update_pilihan);
        eNama = (EditText) findViewById(R.id.update_nama);
        eNohp = (EditText) findViewById(R.id.update_nohp);
        eQty = (EditText) findViewById(R.id.update_quantity);

        ePlh.setText(sPlh);
        eNama.setText(sNama);
        eNohp.setText(sNohp);
        eQty.setText(sQty);

        Button btnUpdate = (Button) findViewById(R.id.btn_up);
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sPlh = String.valueOf(ePlh.getText());
                sNama = String.valueOf(eNama.getText());
                sNohp = String.valueOf(eNohp.getText());
                sQty = String.valueOf(eQty.getText());
                if (sPlh.equals("")) {
                    ePlh.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan isi Pilihan Anda",
                            Toast.LENGTH_SHORT).show();
                } else if (sNama.equals("")){
                    eNama.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan Masukkan Nama Pembeli",
                            Toast.LENGTH_SHORT).show();
                } else if (sNohp.equals("")){
                    eNohp.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan Masukan No HP",
                            Toast.LENGTH_SHORT).show();
                } else if (sQty.equals("")){
                    eQty.requestFocus();
                    Toast.makeText(MainUpdel.this, "Silahkan Tentukan Quantity",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    db.UpdateOrder(new ShoppingMart(sKode, sPlh, sNama, sNohp, sQty));
                    Toast.makeText(MainUpdel.this, "Pesanan anda telah diupdate",
                            Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
        Button btnDelete = (Button) findViewById(R.id.btn_del);
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                db.DeleteOrder(new ShoppingMart(sKode, sPlh, sNama, sNohp, sQty));
                Toast.makeText(MainUpdel.this, "Pesanan anda telah dihapus",
                        Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
