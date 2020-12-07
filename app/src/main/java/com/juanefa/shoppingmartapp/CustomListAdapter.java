package com.juanefa.shoppingmartapp;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<ShoppingMart> movieItems;
    public CustomListAdapter(Activity activity, List<ShoppingMart> movieItems) {
        this.activity = activity;
        this.movieItems = movieItems;
    }
    @Override
    public int getCount() {
        return movieItems.size();
    }
    @Override
    public Object getItem(int location) {
        return movieItems.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView pilihan = (TextView) convertView.findViewById(R.id.text_pilihan);
        TextView nama = (TextView) convertView.findViewById(R.id.text_nama);
        TextView nohp = (TextView) convertView.findViewById(R.id.text_nohp);
        TextView qty = (TextView) convertView.findViewById(R.id.text_qty);
        ImageView imageView = (ImageView) convertView.findViewById(R.id.iconid);
        ShoppingMart m = movieItems.get(position);
        pilihan.setText("Nama : "+ m.get_pilihan());
        nama.setText("Nama : "+ m.get_nama());
        nohp.setText("Harga : Rp "+ m.get_nohp());
        qty.setText("stok : "+ m.get_qty());
        return convertView;
    }
}
