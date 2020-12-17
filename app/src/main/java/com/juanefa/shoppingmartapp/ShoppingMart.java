package com.juanefa.shoppingmartapp;

public class ShoppingMart {
    private String _kode, _plh, _nama, _nohp, _qty;
    public ShoppingMart(String kode, String plh, String nama, String nohp, String qty) {
        this._kode = kode;
        this._plh = plh;
        this._nama = nama;
        this._nohp = nohp;
        this._qty = qty;
    }
    public ShoppingMart() {
    }
    public String get_kode() {
        return _kode;
    }
    public void set_kode(String _kode) {
        this._kode = _kode;
    }
    public String get_plh() {
        return _plh;
    }
    public void set_plh(String _plh) {
        this._plh = _plh;
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
