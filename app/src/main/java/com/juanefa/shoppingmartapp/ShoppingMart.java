package com.juanefa.shoppingmartapp;

public class ShoppingMart {
    private String _pilihan, _nama, _nohp, _qty;
    public ShoppingMart(String pilihan, String nama, String nohp, String qty) {
        this._pilihan = pilihan;
        this._nama = nama;
        this._nohp = nohp;
        this._qty = qty;
    }
    public ShoppingMart(Object o, String sPlh, String sNama, String sNohp, String sQty) {
    }
    public String get_pilihan() {
        return _pilihan;
    }
    public void set_pilihan(String _pilihan) {
        this._pilihan = _pilihan;
    }
    public String get_nama() {
        return _nama;
    }
    public void set_nama(String _nama) {
        this._nama = _nama;
    }
    public String get_nohp() {
        return _nohp;
    }
    public void set_nohp(String _nohp) {
        this._nohp = _nohp;
    }
    public String get_qty() {
        return _qty;
    }
    public void set_qty(String _qty) {
        this._qty = _qty;
    }
}
