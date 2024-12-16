package com.bibliometrik.model;

public class PublikasiEcommerce {
    private int id;
    private String judul;
    private String penulis;
    private String terbitTanggal;
    private double harga;
    private int stok;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPenulis() {
        return penulis;
    }

    public void setPenulis(String penulis) {
        this.penulis = penulis;
    }

    public String getTerbitTanggal() {
        return terbitTanggal;
    }

    public void setTerbitTanggal(String terbitTanggal) {
        this.terbitTanggal = terbitTanggal;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }
}