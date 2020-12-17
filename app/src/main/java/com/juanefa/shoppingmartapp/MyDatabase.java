package com.juanefa.shoppingmartapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;


public class MyDatabase extends SQLiteOpenHelper {

    private static int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db_ShoppingMart";
    private static final String tb_order = "tb_ShoppingMart";
    private static final String tb_kode = "kode";
    private static final String tb_pilihan = "plh";
    private static final String tb_nama = "nama";
    private static final String tb_nohp = "noHp";
    private static final String tb_qty = "quantity";

    private static final String CREATE_TABLE_SHOPPING = "CREATE TABLE " +
            tb_order + "("
            + tb_kode + " INTEGER PRIMARY KEY ,"
            + tb_pilihan + " TEXT,"
            + tb_nama + " TEXT,"
            + tb_nohp + " TEXT, "
            + tb_qty + " TEXT" + ")";

    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_SHOPPING);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public void CreateShopping (ShoppingMart mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_kode, mdNotif.get_kode());
        values.put(tb_pilihan, mdNotif.get_plh());
        values.put(tb_nama, mdNotif.get_nama());
        values.put(tb_nohp, mdNotif.get_nohp());
        values.put(tb_qty, mdNotif.get_qty());
        db.insert(tb_order, null, values);
        db.close();
    }
    public List<ShoppingMart> ReadOrder() {
        List<ShoppingMart> judulModelList = new ArrayList<ShoppingMart>();
        String selectQuery = "SELECT * FROM " + tb_order;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ShoppingMart mdKontak = new ShoppingMart();
                mdKontak.set_kode(cursor.getString(0));
                mdKontak.set_plh(cursor.getString(1));
                mdKontak.set_nama(cursor.getString(2));
                mdKontak.set_nohp(cursor.getString(3));
                mdKontak.set_qty(cursor.getString(4));
                judulModelList.add(mdKontak);
            } while (cursor.moveToNext());
        }
        db.close();
        return judulModelList;
    }
    public int UpdateOrder (ShoppingMart mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_pilihan, mdNotif.get_plh());
        values.put(tb_nama, mdNotif.get_nama());
        values.put(tb_nohp, mdNotif.get_nohp());
        values.put(tb_qty, mdNotif.get_qty());
        return db.update(tb_order, values, tb_kode + " = ?",
                new String[] { String.valueOf(mdNotif.get_kode())});
    }
    public void DeleteOrder (ShoppingMart mdNotif) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_order, tb_kode+ " = ?",
                new String[]{String.valueOf(mdNotif.get_kode())});
        db.close();
    }
}
