package com.bibliometrik.pengujian;

import com.bibliometrik.model.PublikasiEcommerce;
import com.bibliometrik.model.TransaksiPenjualan;
import com.bibliometrik.service.AnalisisBibliometrik;

import java.util.List;

public class UjiAnalisis {
    public static void main(String[] args) {
        // Contoh penggunaan kelas AnalisisBibliometrik
        AnalisisBibliometrik analisiBibliometrik = new AnalisisBibliometrik();

        // Mendapatkan data publikasi
        List<PublikasiEcommerce> publikasiList = analisiBibliometrik.getPublikasiList();

        // Mendapatkan data transaksi penjualan
        List<TransaksiPenjualan> transaksiList = analisiBibliometrik.getTransaksiList();

        // Menghitung jumlah publikasi
        int totalPublikasi = publikasiList.size();
        System.out.println("Total Publikasi: " + totalPublikasi);

        // Menghitung jumlah transaksi
        int totalTransaksi = transaksiList.size();
        System.out.println("Total Transaksi: " + totalTransaksi);

        // Menghitung total penjualan
        double totalPenjualan = analisiBibliometrik.hitungTotalPenjualan(transaksiList);
        System.out.println("Total Penjualan: " + totalPenjualan);

        // Analisis lain yang dapat dilakukan
        double rataRataHarga = analisiBibliometrik.hitungRataRataHargaPublikasi(publikasiList);
        System.out.println("Rata-rata Harga Publikasi: " + rataRataHarga);

        int publikasiTerlaris = analisiBibliometrik.getPublikasiTerlaris(transaksiList);
        System.out.println("Publikasi Terlaris: " + publikasiTerlaris);
    }
}