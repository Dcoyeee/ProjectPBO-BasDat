package com.bibliometrik.model;

public class TransaksiPenjualan {
    private int id;
    private int idPublikasi;
    private int jumlahBeli;
    private double totalHarga;
    private String tanggalTransaksi;
    private int idPembeli;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdPublikasi() {
        return idPublikasi;
    }

    public void setIdPublikasi(int idPublikasi) {
        this.idPublikasi = idPublikasi;
    }

    public int getJumlahBeli() {
        return jumlahBeli;
    }

    public void setJumlahBeli(int jumlahBeli) {
        this.jumlahBeli = jumlahBeli;
    }

    public double getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(double totalHarga) {
        this.totalHarga = totalHarga;
    }

    public String getTanggalTransaksi() {
        return tanggalTransaksi;
    }

    public void setTanggalTransaksi(String tanggalTransaksi) {
        this.tanggalTransaksi = tanggalTransaksi;
    }

    public int getIdPembeli() {
        return idPembeli;
    }

    public void setIdPembeli(int idPembeli) {
        this.idPembeli = idPembeli;
    }
}