package com.juanefa.shoppingmartapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead  extends AppCompatActivity implements
        AdapterView.OnItemClickListener{

    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<ShoppingMart> ListOrder = new ArrayList<ShoppingMart>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, ListOrder );
        mListView = (ListView) findViewById(R.id.list_belanjaan);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        ListOrder.clear();

        List<ShoppingMart> contacts = db.ReadOrder();
        for (ShoppingMart cn : contacts) {
            ShoppingMart judulModel = new ShoppingMart(sPlh, sNama, sNohp, sQty);
            judulModel.set_pilihan(cn.get_pilihan());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_nohp(cn.get_nohp());
            judulModel.set_qty(cn.get_qty());
            ListOrder.add(judulModel);
            if ((ListOrder.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        Object o = mListView.getItemAtPosition(i);
        ShoppingMart obj_itemDetails = (ShoppingMart) o;
        String sPlh = obj_itemDetails.get_pilihan();
        String sNama = obj_itemDetails.get_nama();
        String sNohp = obj_itemDetails.get_nohp();
        String sQty = obj_itemDetails.get_qty();
        Intent goUpdel = new Intent(MainRead.this, MainUpdel.class);
        goUpdel.putExtra("iPilihan", sPlh);
        goUpdel.putExtra("iNama", sNama);
        goUpdel.putExtra("iNohp", sNohp);
        goUpdel.putExtra("iQty", sQty);
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        ListOrder.clear();
        mListView.setAdapter(adapter_off);
        List<ShoppingMart> contacts = db.ReadOrder();
        for (ShoppingMart cn : contacts) {
            ShoppingMart judulModel = new ShoppingMart (sPlh, sNama, sNohp, sQty);
            judulModel.set_pilihan(cn.get_pilihan());
            judulModel.set_nama(cn.get_nama());
            judulModel.set_nohp(cn.get_nohp());
            judulModel.set_qty(cn.get_qty());
            ListOrder.add(judulModel);
            if ((ListOrder.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}
